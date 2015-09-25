/* 
 **
 ** Copyright 2014, 
 ** Carlos Andres Jimenez
 ** apps@carlosandresjimenez.co
 ** 
 */
package org.coursera.mutibosvc.integration;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Iterator;

import org.coursera.mutibosvc.TestData;
import org.coursera.mutibosvc.beans.QuestionSet;
import org.coursera.mutibosvc.client.MutiboSvcApi;
import org.junit.Test;

import retrofit.RestAdapter;
import retrofit.RestAdapter.LogLevel;

/**
 * 
 * This integration test sends a POST request to the fill the DB.
 * Actual network communication using HTTP is performed with this test.
 * 
 * The test requires that the MutivoSvc be running first (see the directions in
 * the README.md file for how to launch the Application).
 * 
 * To run this test, right-click on it in Eclipse and select
 * "Run As"->"JUnit Test"
 * 
 * @author Carlos Andres Jimenez
 *
 */
public class VideoSvcClientApiTest {

	private final String TEST_URL = "https://stable-plasma-775.appspot.com";
	
	private MutiboSvcApi mutiboService = new RestAdapter.Builder()
			.setEndpoint(TEST_URL).setLogLevel(LogLevel.FULL).build()
			.create(MutiboSvcApi.class);
	
	private QuestionSet qset;
	
	@Test
	public void testQSetAddAndList() throws Exception {
		
		Collection<QuestionSet> qsets;
		Collection<QuestionSet> qsetsToInsert = TestData.fillCollection();
		
		for (Iterator<QuestionSet> iterator = qsetsToInsert.iterator(); iterator.hasNext();) {
			qset = iterator.next();
			
			qsets = mutiboService.getSetList();
			if(!qsets.contains(qset)) {
				
				// Add the video
				boolean ok = mutiboService.addSet(qset);
				assertTrue(ok);
				
			} else {
				System.out.println("QSet already exist");
			}
		}
	}	

}
