/* 
 **
 ** Copyright 2014, 
 ** Carlos Andres Jimenez
 ** apps@carlosandresjimenez.co
 ** 
 */
package org.coursera.mutibosvc.beans;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.common.base.Objects;

@PersistenceCapable
public class Answer {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long answerId;

	@Persistent
	private Long setId;

	@Persistent
	private int answerPoint;
	
	@Persistent
	private String username;

	@Persistent
	private int userRating;
	
	@Persistent
	private String sessionId;

	public Answer() {
	}

	public Answer(Long setId, int answerPoint, String username, int userRating, String sessionId) {
		super();
		this.setId = setId;
		this.answerPoint = answerPoint;
		this.username = username;
		this.userRating = userRating;
		this.sessionId = sessionId;
	}
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public Long getSetId() {
		return setId;
	}

	public void setSetId(Long setId) {
		this.setId = setId;
	}

	public int getAnswerPoint() {
		return answerPoint;
	}

	public void setAnswerPoint(int answerPoint) {
		this.answerPoint = answerPoint;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUserRating() {
		return userRating;
	}

	public void setUserRating(int userRating) {
		this.userRating = userRating;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Answer) {
			Answer other = (Answer) obj;
			// Google Guava provides great utilities for equals too!
			return Objects.equal(setId, other.setId)
					&& Objects.equal(answerPoint, other.answerPoint)
					&& Objects.equal(username, other.username)
					&& Objects.equal(userRating, other.userRating)
					&& Objects.equal(sessionId, other.sessionId);
		} else {
			return false;
		}
	}	

}
