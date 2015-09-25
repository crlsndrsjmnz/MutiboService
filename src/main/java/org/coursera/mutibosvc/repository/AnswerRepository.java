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

import org.coursera.mutibosvc.beans.Answer;
import org.springframework.stereotype.Service;

@Service
public class AnswerRepository extends JDOCrudRepository<Answer, Long>{

	public AnswerRepository() {
		super(Answer.class);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Answer> findByName(String name){
		Query query = PMF.get().getPersistenceManager().newQuery(Answer.class);
		query.setFilter("name == n");
		query.declareParameters("String n");
		return (List<Answer>)query.execute(name);
	}
	
		

}
