/* 
 **
 ** Copyright 2014, 
 ** Carlos Andres Jimenez
 ** apps@carlosandresjimenez.co
 ** 
 */
package org.coursera.mutibosvc.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.coursera.mutibosvc.beans.Answer;
import org.coursera.mutibosvc.beans.CachedSet;
import org.coursera.mutibosvc.beans.QuestionSet;
import org.coursera.mutibosvc.beans.Session;
import org.coursera.mutibosvc.client.MutiboSvcApi;
import org.coursera.mutibosvc.repository.AnswerRepository;
import org.coursera.mutibosvc.repository.CachedSetRepository;
import org.coursera.mutibosvc.repository.QuestionSetRepository;
import org.coursera.mutibosvc.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.client.util.Lists;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

// Tell Spring that this class is a Controller that should
// handle certain HTTP requests for the DispatcherServlet
@Controller
public class MutiboSvc implements MutiboSvcApi {

	private final static String CLIENT_ID = "528274095287-i27t4taimipbq7avuunvbuui52rfrkac.apps.googleusercontent.com";
	
	@Autowired
	private QuestionSetRepository qSetsRep;

	@Autowired
	private AnswerRepository answerRep;

	@Autowired
	private CachedSetRepository cachedSetsRep;	

	@Autowired
	private SessionRepository sessionRep;
	
	@RequestMapping(value = MutiboSvcApi.QSET_PATH, method = RequestMethod.POST)
	public @ResponseBody boolean addSet(@RequestBody QuestionSet q) {
		qSetsRep.save(q);
		return true;
	}
	
	@RequestMapping(value = MutiboSvcApi.QSET_FIND_ALL, method = RequestMethod.GET)
	public @ResponseBody Collection<QuestionSet> getSetList() {
		return Lists.newArrayList(qSetsRep.findAll());
	}

	@RequestMapping(value = MutiboSvcApi.QSET_PATH, method = RequestMethod.GET)
	public @ResponseBody Collection<QuestionSet> getSetList(
			@RequestParam(SESSIONID_PARAMETER) String sessionId,
			@RequestParam(QSETNUM_PARAMETER) int numberOfQSets,
			@RequestParam(RANDOM_PARAMETER) boolean randomize,
			@RequestParam(DIFFICULTY_PARAMETER) int difficulty) {
		
		List<CachedSet> lCachedQSets = Lists.newArrayList(cachedSetsRep.findBySession(sessionId));
		
		List<QuestionSet> lQSets = Lists.newArrayList(qSetsRep.findAll(numberOfQSets, randomize, lCachedQSets, difficulty));
		
		cachedSetsRep.save(cachedSetsRep.getCachedQSets(sessionId, lQSets));
		
		return lQSets;
	}

	@RequestMapping(value = MutiboSvcApi.ANSWER_PATH, method = RequestMethod.GET)
	public @ResponseBody Collection<Answer> getAnswerList() {
		return Lists.newArrayList(answerRep.findAll());
	}
	
	@RequestMapping(value = MutiboSvcApi.ANSWER_PATH, method = RequestMethod.POST)
	public @ResponseBody int addAnswer(@RequestBody Answer a) {
		answerRep.save(a);
		
		return qSetsRep.updateQSet(a.getSetId(), a.getUserRating(), a.getAnswerPoint());
	}	

	@RequestMapping(value = MutiboSvcApi.CACHEDQSET_PATH, method = RequestMethod.GET)
	public @ResponseBody Collection<CachedSet> getCachedSetList() {
		return Lists.newArrayList(cachedSetsRep.findAll());
	}
	
	@RequestMapping(value = MutiboSvcApi.CACHEDQSET_PATH, method = RequestMethod.POST)
	public @ResponseBody int addCachedSet(@RequestBody CachedSet cs) {
		cachedSetsRep.save(cs);
		return 1;
	}
	
	@RequestMapping(value = MutiboSvcApi.CREATE_SESSION_PATH, method = RequestMethod.POST)
	public @ResponseBody String saveSession(@RequestBody Session s, HttpServletRequest request) {
		
		if (validateGoogleToken(CLIENT_ID, s.getToken())) {
			
			// Prevents the Google+ token from being saved into the DB.
			s.setToken("");
			
			s = sessionRep.save(s);
			
			return s.getSessionId();			
		} else {
			return "INVALID_TOKEN";
		}
	}
	
	private boolean validateGoogleToken(String clientId, String auth_token) {

		HttpURLConnection connection = null;
		String response = "";
		String audience = "";
		try {
			connection = (HttpURLConnection) new URL(
					("https://www.googleapis.com/oauth2/v1/tokeninfo?access_token=" + auth_token))
					.openConnection();

			// read response
			response = streamToString(connection.getInputStream());

			JsonElement element = new Gson().fromJson(response, JsonObject.class).get("audience");
			
			if (element != null)
				audience = element.getAsString();
			
			if (!CLIENT_ID.equals(audience)) {
				return false;
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	private String streamToString(InputStream is) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}
}