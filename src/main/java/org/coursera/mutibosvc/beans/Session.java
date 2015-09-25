/* 
 **
 ** Copyright 2014, 
 ** Carlos Andres Jimenez
 ** apps@carlosandresjimenez.co
 ** 
 */
package org.coursera.mutibosvc.beans;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.common.base.Objects;

@PersistenceCapable
public class Session {

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Key sessionId;

	@Persistent
	private String username;

	@Persistent
	private String datetime;

	@Persistent
	private String device;

	@Persistent
	private String ipAddress;

	@NotPersistent
	private String token;

	@Persistent
	private Boolean clearCache;
	
	@NotPersistent
	private String errorMsg;

	public Session() {
	}

	public Session(String sessionId, String username, String datetime, String device,
			String ipAddress, String token, Boolean clearCache, String errorMsg) {
		super();
		setSessionId(sessionId);
		this.username = username;
		this.datetime = datetime;
		this.device = device;
		this.ipAddress = ipAddress;
		this.token = token;
		this.clearCache = clearCache;
		this.errorMsg = errorMsg;
	}

	public String getSessionId() {
		return this.sessionId != null ? KeyFactory.keyToString(this.sessionId) : null;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = null;
		
		if (sessionId != null && !sessionId.equals("")) {
			this.sessionId = KeyFactory.stringToKey(sessionId);
		}
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}
	
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Boolean getClearCache() {
		return clearCache;
	}

	public void setClearCache(Boolean clearCache) {
		this.clearCache = clearCache;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Session) {
			Session other = (Session) obj;
			// Google Guava provides great utilities for equals too!
			return Objects.equal(sessionId, other.sessionId)
					&& Objects.equal(username, other.username)
					&& Objects.equal(device, other.device)
					&& Objects.equal(ipAddress, other.ipAddress)
					&& Objects.equal(clearCache, other.clearCache);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Session [sessionId=" + sessionId + ", username=" + username
				+ ", datetime=" + datetime + ", device=" + device
				+ ", ipAddress=" + ipAddress + ", token=" + token
				+ ", clearCache=" + clearCache + ", errorMsg=" + errorMsg + "]";
	}
}
