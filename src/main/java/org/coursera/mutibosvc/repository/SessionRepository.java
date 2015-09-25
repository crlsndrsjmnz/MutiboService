/* 
 **
 ** Copyright 2014, 
 ** Carlos Andres Jimenez
 ** apps@carlosandresjimenez.co
 ** 
 */
package org.coursera.mutibosvc.repository;

import java.util.Collection;
import java.util.List;

import javax.jdo.Query;

import org.coursera.mutibosvc.beans.QuestionSet;
import org.coursera.mutibosvc.beans.Session;
import org.springframework.stereotype.Service;

@Service
public class SessionRepository extends JDOCrudRepository<Session, String> {

	public SessionRepository() {
		super(Session.class);
	}

	@SuppressWarnings("unchecked")
	public Collection<QuestionSet> findByName(String name) {
		Query query = PMF.get().getPersistenceManager()
				.newQuery(QuestionSet.class);
		query.setFilter("name == n");
		query.declareParameters("String n");
		return (List<QuestionSet>) query.execute(name);
	}

}
