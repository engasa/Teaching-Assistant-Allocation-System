package edu.udel.cis.taschd.extract;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.junit.Test;

import edu.udel.cis.taschd.ca.CourseAssistant;
import edu.udel.cis.taschd.course.CourseInstance;
import edu.udel.cis.taschd.course.Section;

public class CAScheduleExtractorTest {
	
	@Test 
	public void CASExtractorEmptyArgsTest() {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		String[] credentials = {"test","test"};
		int[] CAIDs = {702425216};
		String term = "2188";
		CAScheduleExtractor cas1 = new CAScheduleExtractor("test", credentials, CAIDs, term);
		ArrayList<CourseAssistant> casObj1 = cas1.returnCASchedules();
		assertNull(casObj1);	
		
		String[] credentialsTest = {};
		CAScheduleExtractor cas2 = new CAScheduleExtractor("Web", credentialsTest, CAIDs, term);
		ArrayList<CourseAssistant> casObj2 = cas2.returnCASchedules();
		assertNull(casObj2);	
		
		int[] CAIDsTest = {};
		CAScheduleExtractor cas3 = new CAScheduleExtractor("Web", credentials, CAIDsTest, term);
		ArrayList<CourseAssistant> casObj3 = cas3.returnCASchedules();
		assertNull(casObj3);
		
		String termTest = "";
		CAScheduleExtractor cas4 = new CAScheduleExtractor("Web", credentials, CAIDs, termTest);
		ArrayList<CourseAssistant> casObj4 = cas4.returnCASchedules();
		assertNull(casObj4);
		System.out.println("************** CASExtractorEmptyArgsTest Complete ***************");
	}


	@Test 
	public void CASExtractorArgsTest() {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		
		List<Map<String, String>> caScheduleSource = new ArrayList<Map<String, String>>();
		ArrayList<CourseAssistant> caSchedules = new ArrayList<CourseAssistant>();
		String[][] schDetails = 
			{{"CISC", "675", "Software Engineering", "010", "Siegel,Stephen", "LEC",
				"T","R","11:00 AM","12:15 PM","MDH216"},
			 {"CISC", "662", "Computer Systems: Architecture", "010", "Chandrasekaran,Sunita", "LEC",
				"W","F","3:35 PM","4:50 PM","MEM109"},
			 {"CISC", "882", "Natural Language Processing", "010", "McCoy,Kathleen", "LEC",
					"W","F","3:30 PM","4:45 PM","SMI102A"}};
		for (int i = 0; i<schDetails.length; i++) {
		Map<String, String> sch = new HashMap<String, String>();
		sch.put("departmentID", schDetails[i][0]);
		sch.put("courseCode", schDetails[i][1]);
		sch.put("courseName", schDetails[i][2]);
		sch.put("sectionNumber", schDetails[i][3]);
		sch.put("instructorName", schDetails[i][4]);
		sch.put("sectionType", schDetails[i][5]);
		sch.put("WeekDay1", schDetails[i][6]);
		sch.put("WeekDay2", schDetails[i][7]);
		sch.put("startTime", schDetails[i][8]);
		sch.put("endTime", schDetails[i][9]);
		sch.put("location", schDetails[i][10]);
		caScheduleSource.add(sch);}
		int CAID = 702425216;
		String term = "2188";
		CAScheduleExtractor cas = new CAScheduleExtractor(caScheduleSource, CAID, term);		
		caSchedules = cas.returnCASchedules();
		
		if (caSchedules != null) {
			assertEquals(caSchedules.get(0).getId(), 702425216);
			System.out.println(caSchedules.get(0).getId() + " enrolled for "
					+ caSchedules.get(0).getCourseEnrolled().size() + " Courses, below are CourseInstance Objects");
		for (CourseInstance ci : caSchedules.get(0).getCourseEnrolled()) {
			System.out.print(ci.getCourse());
			assertTrue(ci.getCourse().toString().equals("CISC 675") || ci.getCourse().toString().equals("CISC 662") || ci.getCourse().toString().equals("CISC 882"));
			for (Section se : ci.getSections()) {
				System.out.println(se.getSectionNumber());
				System.out.println(se.getSchedule());
			}
		}
	}
		System.out.println("************** CASExtractorTest Complete ***************");
	}
	
}
