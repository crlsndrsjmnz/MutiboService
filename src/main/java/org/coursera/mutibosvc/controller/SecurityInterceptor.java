/* 
 **
 ** Copyright 2014, 
 ** Carlos Andres Jimenez
 ** apps@carlosandresjimenez.co
 ** 
 */
package org.coursera.mutibosvc.controller;

import javax.jdo.JDOObjectNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.coursera.mutibosvc.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private SessionRepository sessionRep;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String sessionId = request.getHeader("sessionId");

		if (sessionId == null || sessionId.equals("")) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			
			return false;
		}
		
		try {
			sessionRep.findOne(sessionId);
			
		} catch (JDOObjectNotFoundException jdoex) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}

		return true;	
	}
}