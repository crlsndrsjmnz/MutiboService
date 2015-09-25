/* 
 **
 ** Copyright 2014, 
 ** Carlos Andres Jimenez
 ** apps@carlosandresjimenez.co
 ** 
 */
package org.coursera.mutibosvc.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.coursera.mutibosvc.beans.CachedSet;
import org.coursera.mutibosvc.beans.QuestionSet;
import org.coursera.mutibosvc.client.MutiboSvcApi;
import org.springframework.stereotype.Service;

import com.google.api.client.util.Lists;

@Service
public class QuestionSetRepository extends JDOCrudRepository<QuestionSet, Long> {

	public QuestionSetRepository() {
		super(QuestionSet.class);
	}

	@SuppressWarnings("unchecked")
	public Collection<QuestionSet> findById(String setId) {
		Query query = PMF.get().getPersistenceManager()
				.newQuery(QuestionSet.class);
		query.setFilter("setId == s");
		query.declareParameters("String setId");
		return (List<QuestionSet>) query.execute(setId);
	}

	@SuppressWarnings("unchecked")
	public List<QuestionSet> findAll(int numberOfQSets, boolean randomize,
			List<CachedSet> lCachedQSets, int difficultyLevel) {
		Query query = PMF.get().getPersistenceManager()
				.newQuery(QuestionSet.class);

		if (randomize)
			return getRandomQSets(numberOfQSets,
					(List<QuestionSet>) query.execute(), lCachedQSets, difficultyLevel);
		else
			return (List<QuestionSet>) query.execute();
	}

	public int updateQSet(Long setId, int userRating, int answerPoint) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		float badVotes = 0;
		float totalVotes = 0;
		float ratingIndex = 0;
		
		float badResponses = 0;
		float totalResposes = 0;
		float difficultyIndex = 0;
		
		try {
			pm.currentTransaction().begin();
			
			QuestionSet qset = pm.getObjectById(QuestionSet.class, setId);

			if (qset != null) {
				
				if (userRating != 0) {
					badVotes = qset.getBadVotes();
					totalVotes = qset.getTotalVotes();

					if (userRating == -1) {
						badVotes++;
						qset.setBadVotes(badVotes);
					}
					totalVotes++;
					qset.setTotalVotes(totalVotes);
					
					if (totalVotes > 0){
						ratingIndex = (totalVotes - badVotes) / totalVotes;
						qset.setqSetRating(ratingIndex);
					}
				}
				
				badResponses = qset.getBadResponses();
				totalResposes = qset.getTotalResposes();
					
				if (answerPoint == 0) {
					badResponses++;
					qset.setBadResponses(badResponses);
				}
				totalResposes++;
				qset.setTotalResposes(totalResposes);
				
				if (totalResposes > 0) {
					difficultyIndex = badResponses / totalResposes;
					qset.setDifficultyIndex(difficultyIndex);
				}
			}
			
	        pm.currentTransaction().commit();
	        
		} catch (Exception e) {
	        e.printStackTrace();
	        pm.currentTransaction().rollback();
	    } finally {
			pm.close();
		}

		return 1;
	}

	private List<QuestionSet> getRandomQSets(int numberOfQSets,
			List<QuestionSet> lQSets, List<CachedSet> lCachedQSets, float difficultyLevel) {
		Random rnd = new Random();
		int random = 0;
		boolean backwards = false;
		float difficultyIndex = 0;
		
		QuestionSet qset;

		List<QuestionSet> lQSetsRandom = new ArrayList<QuestionSet>();
		List<QuestionSet> lQSetsDiscard = new ArrayList<QuestionSet>();
		List<QuestionSet> lQSetsCopy = Lists.newArrayList(lQSets);

		while (lQSetsRandom.size() < numberOfQSets && difficultyLevel <= MutiboSvcApi.MAX_DIFFICULTY_LEVEL) {
			while (lQSetsRandom.size() < numberOfQSets && lQSetsCopy.size() > 0) {
				random = rnd.nextInt(lQSetsCopy.size());
				qset = lQSetsCopy.get(random);
	
				difficultyIndex = difficultyLevel/MutiboSvcApi.MAX_DIFFICULTY_LEVEL;
				if (qset.getDifficultyIndex() >= difficultyIndex)
					lQSetsDiscard.add(qset);
				else if (!lQSetsRandom.contains(qset) && !lCachedQSets.contains(qset))
					if (qset.getTotalVotes() <= MutiboSvcApi.MIN_TOTAL_RATINGS)
						lQSetsRandom.add(qset);
					else if (qset.getqSetRating() >= MutiboSvcApi.MIN_APPROVAL_RATING)
						lQSetsRandom.add(qset);
	
				lQSetsCopy.remove(random);
			}
			
			lQSetsCopy.addAll(lQSetsDiscard);
			lQSetsDiscard.clear();
			
			if (difficultyLevel == MutiboSvcApi.MAX_DIFFICULTY_LEVEL)
				backwards = true;
			
			if (backwards)
				difficultyLevel--;
			else	
				difficultyLevel++;
		}
		return lQSetsRandom;
	}

}
