/* 
 **
 ** Copyright 2014, 
 ** Carlos Andres Jimenez
 ** apps@carlosandresjimenez.co
 ** 
 */
package org.coursera.mutibosvc.beans;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import com.google.common.base.Objects;

@PersistenceCapable
public class CachedSet {

	@Persistent
	private String sessionId;

	@Persistent
	private Long setId;

	public CachedSet() {
	}

	public CachedSet(String sessionId, Long setId) {
		super();
		this.sessionId = sessionId;
		this.setId = setId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public Long getSetId() {
		return setId;
	}

	public void setSetId(Long setId) {
		this.setId = setId;
	}

	/**
	 * Two Sets are considered equal if they have exactly the same values for
	 * their movieName1, movieName2, movieName3, movieName4, wrongMovieNum,
	 * reason.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CachedSet) {
			CachedSet other = (CachedSet) obj;
			return Objects.equal(sessionId, other.sessionId)
					&& Objects.equal(setId, other.setId);
		} else if (obj instanceof QuestionSet) {
			QuestionSet other = (QuestionSet) obj;
			return Objects.equal(setId, other.getSetId());
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "CachedSet [sessionId=" + sessionId + ", setId=" + setId + "]";
	}
}
