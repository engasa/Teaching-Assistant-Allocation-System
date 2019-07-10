package edu.udel.cis.taschd.extract;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.logging.Level;

import org.junit.Test;

import edu.udel.cis.taschd.course.CourseInstance;

public class CourseScheduleExtractorTest {
	
	@Test 
	public void CSExtractorEmptyArgsTest() {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		CourseScheduleExtractor cs1 = new CourseScheduleExtractor("Web","","2188");
		ArrayList<CourseInstance> cis1 = cs1.returnCourseInstances();
		ArrayList<CourseInstance> exp = new ArrayList<CourseInstance>();
		assertArrayEquals(cis1.toArray(), exp.toArray());	
		
		CourseScheduleExtractor cs2 = new CourseScheduleExtractor("Web","CISC675","");
		ArrayList<CourseInstance> cis2 = cs2.returnCourseInstances();
		assertArrayEquals(cis2.toArray(), exp.toArray());
		
		CourseScheduleExtractor cs3 = new CourseScheduleExtractor("test","CISC675","2188");
		ArrayList<CourseInstance> cis3 = cs3.returnCourseInstances();
		assertArrayEquals(cis3.toArray(), exp.toArray());
		System.out.println("******************* CSExtractorEmptyArgsTest Complete *******************");
	}

	@Test 
	public void CSExtractorTest() {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		CourseScheduleExtractor cs1 = new CourseScheduleExtractor("Web","CISC675","2188");
		ArrayList<CourseInstance> cis1 = cs1.returnCourseInstances();
		
		assertEquals(cis1.toString(),"[CISC 675 - 020LAB 010LEC]");
		//"[CISC 675 Software Engineering Principles and Practices\nSection: 020LAB, 24 of 35, Wed 16:40–17:55, BRL205, Siegel,Stephen\nSection: 010LEC, 9 of 20, Tue 11:00–12:15; Thu 11:00–12:15, MDH216, Siegel,Stephen]");		
		System.out.println(cis1);
		
		CourseScheduleExtractor cs2 = new CourseScheduleExtractor("Web","CISC681","2193");
		ArrayList<CourseInstance> cis2 = cs2.returnCourseInstances();
		
		assertEquals(cis2.toString(),"[CISC 681 - 010LEC]");
		//"[CISC 681 Artificial Intelligence\nSection: 010LEC, 0 of 15, Tue 12:30–13:45; Thu 12:30–13:45, , Beheshti,Rahmatollah]");		
		System.out.println(cis2);
		
		System.out.println("********************** CSExtractorTest Complete *************************");
	}
	
	@Test 
	public void CSAllCoursesExtractorTest() {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		CourseScheduleExtractor cs = new CourseScheduleExtractor("Web","CISC","2193");
		ArrayList<CourseInstance> cis = cs.returnCourseInstances();
		
		assertNotNull(cis);
		//"[CISC 675 Software Engineering Principles and Practices\nSection: 020LAB, 24 of 35, Wed 16:40–17:55, BRL205, Siegel,Stephen\nSection: 010LEC, 9 of 20, Tue 11:00–12:15; Thu 11:00–12:15, MDH216, Siegel,Stephen]");		
		System.out.println(cis.size() + " Courses are returned for key CISC in term 2193");
				
		System.out.println("******************* CSAllCoursesExtractorTest Complete *******************");
	}


}
