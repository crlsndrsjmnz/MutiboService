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

import javax.jdo.Query;

import org.coursera.mutibosvc.beans.CachedSet;
import org.coursera.mutibosvc.beans.QuestionSet;
import org.springframework.stereotype.Service;

@Service
public class CachedSetRepository extends JDOCrudRepository<CachedSet, Long>{

	public CachedSetRepository() {
		super(CachedSet.class);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<CachedSet> findBySession(String sessionId){
		Query query = PMF.get().getPersistenceManager().newQuery(CachedSet.class);
		query.setFilter("sessionId == s");
		query.declareParameters("String s");
		return (List<CachedSet>)query.execute(sessionId);
	}
	
	public long deleteBySession(String sessionId){
		Query query = PMF.get().getPersistenceManager().newQuery(CachedSet.class);
		query.setFilter("sessionId == s");
		query.declareParameters("String s");
		return query.deletePersistentAll(sessionId);
	}
	
	public List<CachedSet> getCachedQSets(String sessionId, List<QuestionSet> lQSets) {
		
		List<CachedSet> lCachedQSets = new ArrayList<CachedSet>();
		
		for (QuestionSet qSet : lQSets) {
			lCachedQSets.add(new CachedSet(sessionId, qSet.getSetId()));
		}
		
		return lCachedQSets;
	}		

}
