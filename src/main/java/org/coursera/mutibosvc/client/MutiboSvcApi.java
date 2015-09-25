/* 
 **
 ** Copyright 2014, 
 ** Carlos Andres Jimenez
 ** apps@carlosandresjimenez.co
 ** 
 */
package org.coursera.mutibosvc.client;

import java.util.Collection;

import org.coursera.mutibosvc.beans.Session;
import org.coursera.mutibosvc.beans.Answer;
import org.coursera.mutibosvc.beans.CachedSet;
import org.coursera.mutibosvc.beans.QuestionSet;
import javax.servlet.http.HttpServletRequest;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * This interface defines an API for a MutiboSvc. The interface is used to
 * provide a contract for client/server interactions. The interface is annotated
 * with Retrofit annotations so that clients can automatically convert the
 * 
 * 
 * @author Carlos Andres Jimenez
 *
 */
public interface MutiboSvcApi {

	public static final double MIN_TOTAL_RATINGS = 10;
	public static final double MIN_APPROVAL_RATING = 0.6;

	public static final String SESSIONID_PARAMETER = "id";
	public static final String QSETNUM_PARAMETER = "num";
	public static final String RANDOM_PARAMETER = "random";
	public static final String DIFFICULTY_PARAMETER = "difficulty";

	public static final String QSET_PATH = "/qset";
	public static final String QSET_FIND_ALL = QSET_PATH + "/all";

	public static final String ANSWER_PATH = "/answer";

	public static final String CACHEDQSET_PATH = QSET_PATH + "/cache";

	public static final String CREATE_SESSION_PATH = "/oauth/session";
	
	public static final float MAX_DIFFICULTY_LEVEL = 3;

	@GET(QSET_FIND_ALL)
	public Collection<QuestionSet> getSetList();
	
	@GET(QSET_PATH)
	public Collection<QuestionSet> getSetList(
			@Query(SESSIONID_PARAMETER) String sessionId,
			@Query(QSETNUM_PARAMETER) int numberOfQSets,
			@Query(RANDOM_PARAMETER) boolean randomize,
			@Query(DIFFICULTY_PARAMETER) int difficulty);

	@POST(QSET_PATH)
	public boolean addSet(@Body QuestionSet v);

	@GET(ANSWER_PATH)
	public Collection<Answer> getAnswerList();

	@POST(ANSWER_PATH)
	public int addAnswer(@Body Answer a);

	@GET(CACHEDQSET_PATH)
	public Collection<CachedSet> getCachedSetList();

	@POST(CACHEDQSET_PATH)
	public int addCachedSet(@Body CachedSet cs);

	@POST(CREATE_SESSION_PATH)
	public String saveSession(@Body Session s, HttpServletRequest request);
}
