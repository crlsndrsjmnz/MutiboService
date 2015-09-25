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
public class QuestionSet {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long setId;

	@Persistent
	private String movieName1;

	@Persistent
	private String movieName2;

	@Persistent
	private String movieName3;

	@Persistent
	private String movieName4;

	@Persistent
	private int wrongMovieNum;

	@Persistent
	private String questionType;
	
	@Persistent
	private String reason;

	// Counting operations variables
	
	@Persistent
	private float totalVotes;

	@Persistent
	private float badVotes;

	@Persistent
	private float qSetRating;
	
	@Persistent
	private float totalResposes;

	@Persistent
	private float badResponses;

	@Persistent
	private float difficultyIndex;
	
	public QuestionSet() {
	}

	public QuestionSet(String movieName1, String movieName2, String movieName3,
			String movieName4, int wrongMovieNum, String questionType, String reason, 
			float totalVotes, float badVotes, float qSetRating, float totalResposes, 
			float badResponses, float difficultyIndex ) {
		super();
		this.movieName1 = movieName1;
		this.movieName2 = movieName2;
		this.movieName3 = movieName3;
		this.movieName4 = movieName4;
		this.wrongMovieNum = wrongMovieNum;
		this.questionType = questionType;
		this.reason = reason;
		this.totalVotes = totalVotes;
		this.badVotes = badVotes;
		this.qSetRating = qSetRating;
		this.totalResposes = totalResposes;
		this.badResponses = badResponses;
		this.difficultyIndex = difficultyIndex;
	}

	protected QuestionSet(QuestionSet original) {
		this.movieName1 = original.movieName1;
		this.movieName2 = original.movieName2;
		this.movieName3 = original.movieName3;
		this.movieName4 = original.movieName4;
		this.wrongMovieNum = original.wrongMovieNum;
		this.questionType = original.questionType;
		this.reason = original.reason;
		this.totalVotes = original.totalVotes;
		this.badVotes = original.badVotes;
		this.qSetRating = original.qSetRating;
		this.totalResposes = original.totalResposes;
		this.badResponses = original.badResponses;
		this.difficultyIndex = original.difficultyIndex;
    }
	
	public float getTotalVotes() {
		return totalVotes;
	}

	public void setTotalVotes(float totalVotes) {
		this.totalVotes = totalVotes;
	}

	public float getBadVotes() {
		return badVotes;
	}

	public void setBadVotes(float badVotes) {
		this.badVotes = badVotes;
	}

	public float getqSetRating() {
		return qSetRating;
	}

	public void setqSetRating(float qSetRating) {
		this.qSetRating = qSetRating;
	}

	public Long getSetId() {
		return setId;
	}

	public void setSetId(Long setId) {
		this.setId = setId;
	}

	public String getMovieName1() {
		return movieName1;
	}

	public void setMovieName1(String movieName1) {
		this.movieName1 = movieName1;
	}

	public String getMovieName2() {
		return movieName2;
	}

	public void setMovieName2(String movieName2) {
		this.movieName2 = movieName2;
	}

	public String getMovieName3() {
		return movieName3;
	}

	public void setMovieName3(String movieName3) {
		this.movieName3 = movieName3;
	}

	public String getMovieName4() {
		return movieName4;
	}

	public void setMovieName4(String movieName4) {
		this.movieName4 = movieName4;
	}

	public int getWrongMovieNum() {
		return wrongMovieNum;
	}

	public void setWrongMovieNum(int wrongMovieNum) {
		this.wrongMovieNum = wrongMovieNum;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public float getTotalResposes() {
		return totalResposes;
	}

	public void setTotalResposes(float totalResposes) {
		this.totalResposes = totalResposes;
	}

	public float getBadResponses() {
		return badResponses;
	}

	public void setBadResponses(float badResponses) {
		this.badResponses = badResponses;
	}

	public float getDifficultyIndex() {
		return difficultyIndex;
	}

	public void setDifficultyIndex(float difficultyIndex) {
		this.difficultyIndex = difficultyIndex;
	}

	/**
	 * Two Sets are considered equal if they have exactly the same values for
	 * their movieName1, movieName2, movieName3, movieName4, wrongMovieNum,
	 * reason.
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof QuestionSet) {
			QuestionSet other = (QuestionSet) obj;
			// Google Guava provides great utilities for equals too!
			return Objects.equal(movieName1, other.movieName1)
					&& Objects.equal(movieName2, other.movieName2)
					&& Objects.equal(movieName3, other.movieName3)
					&& Objects.equal(movieName4, other.movieName4)
					&& wrongMovieNum == other.wrongMovieNum
					&& Objects.equal(reason, other.reason);
		} else if (obj instanceof CachedSet) {
			CachedSet other = (CachedSet) obj;
			// Google Guava provides great utilities for equals too!
			return Objects.equal(setId, other.getSetId());
		} else {
			return false;
		}
	}
	
	public QuestionSet copy() {
		return new QuestionSet(this);
	}

}
