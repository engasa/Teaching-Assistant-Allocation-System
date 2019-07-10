package edu.udel.cis.taschd.ca;

import edu.udel.cis.taschd.ca.CourseAssistant;
import edu.udel.cis.taschd.ca.CourseAssistantPool;
import edu.udel.cis.taschd.course.Course;
import edu.udel.cis.taschd.course.CourseInstance;
import edu.udel.cis.taschd.skill.Skill;
import edu.udel.cis.taschd.skill.SkillSet;
import edu.udel.cis.taschd.ca.CourseAssistantTest;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

import edu.udel.cis.taschd.time.TimeInterval;
import edu.udel.cis.taschd.time.WeeklySchedule;


/**
 * Tests of the {@link CourseAssistant} class.
 *
 * @author Yi Liu
 */
public class CourseAssistantPoolTest {
	public static PrintStream out = System.out;
	
	/**
	 * CourseAssistant ID:888888888; FirstName: Yi; LastName: Liu; Email:y@udel.edu
	 * 
	 */
//	public static CourseAssistant ca1 = new CourseAssistant(888888888);
	CourseAssistant ca1 = CourseAssistantTest.ca1;

	/**
	 * CourseAssistant ID:999999999; FirstName: Mike; LastName: D; Email:md@udel.edu
	 * 
	 */
	public static CourseAssistant ca2 = new CourseAssistant(999999999);
	
	/**
	 * CourseAssistant ID:111111111; FirstName: John; LastName: Lenon; Email:JL@udel.edu
	 * 
	 */

	public static CourseAssistant ca3 = new CourseAssistant(111111111);

	@Before
	public void setUp() throws Exception {

		// ca1
		// make a new skil set
		SkillSet skillSet1 = new SkillSet(new HashSet<Skill>());
		skillSet1.addSkill(new Skill("Java"));
		skillSet1.addSkill(new Skill("Python"));
		skillSet1.addSkill(new Skill("Javascript"));

		// Create WTPS for CourseAssisstant1
		Collection<TimeInterval> cti1 = new ArrayList<TimeInterval>();
		TimeInterval ti1 = new TimeInterval(DayOfWeek.TUESDAY, 11, 15, 75);
		TimeInterval ti2 = new TimeInterval(DayOfWeek.THURSDAY, 11, 15, 75);
		cti1.add(ti1);
		cti1.add(ti2);

		// Add Weekly Time Schedule Specification
		WeeklySchedule w1 = new WeeklySchedule(cti1);

		// Course Enrrolled
		CourseInstance ci1 = new CourseInstance(new Course("CISC", "675", "Software Engineering"), 2191);
		CourseInstance ci2 = new CourseInstance(new Course("CISC", "642", "Intro to Computer Vision"), 2198);

		Set<CourseInstance> caOneCourseEnrolled = new HashSet<CourseInstance>();
		caOneCourseEnrolled.add(ci1);
		caOneCourseEnrolled.add(ci2);

		// set First Name, Last Name
		ca1.setFirstName("Yi");
		ca1.setLastName("Liu");
		ca1.setEmailAddress("y@udel.edu");
		ca1.setPossessedSkillset(skillSet1);
		ca1.setWtps(w1);
		ca1.setCourseEnrolled(caOneCourseEnrolled);
		ca1.setGraduateStudent(true);

		// ca2
		// make a new skill set
		SkillSet skillSet2 = new SkillSet(new HashSet<Skill>());
		skillSet1.addSkill(new Skill("Java"));
		skillSet1.addSkill(new Skill("Python"));
		skillSet1.addSkill(new Skill("Matlab"));

		// Create WTPS for CourseAssisstant1
		Collection<TimeInterval> cti2 = new ArrayList<TimeInterval>();
		TimeInterval ti3 = new TimeInterval(DayOfWeek.MONDAY, 11, 15, 75);
		TimeInterval ti4 = new TimeInterval(DayOfWeek.TUESDAY, 11, 15, 75);
		cti1.add(ti3);
		cti1.add(ti4);

		// Add Weekly Time Schedule Specification
		WeeklySchedule w2 = new WeeklySchedule(cti2);

		// Course Enrrolled
		CourseInstance ci3 = new CourseInstance(new Course("CISC", "220", "Datastrucutre"), 1234);
		CourseInstance ci4 = new CourseInstance(new Course("CISC", "677", "Ghost Course"), 7777);

		Set<CourseInstance> caOneCourseEnrolled2 = new HashSet<CourseInstance>();
		caOneCourseEnrolled2.add(ci1);
		caOneCourseEnrolled2.add(ci3);
		caOneCourseEnrolled2.add(ci4);

		// set First Name, Last Name
		ca2.setFirstName("Mike");
		ca2.setLastName("D");
		ca2.setEmailAddress("md@udel.edu");
		ca2.setPossessedSkillset(skillSet2);
		ca2.setWtps(w2);
		ca2.setCourseEnrolled(caOneCourseEnrolled2);
		ca2.setGraduateStudent(false);

		// ca3
		// make a new skill set
		SkillSet skillSet3 = new SkillSet(new HashSet<Skill>());
		skillSet3.addSkill(new Skill("Java"));
		skillSet3.addSkill(new Skill("Python"));
		skillSet3.addSkill(new Skill("Matlab"));

		// Create WTPS for CourseAssisstant1
		Collection<TimeInterval> cti3 = new ArrayList<TimeInterval>();
		TimeInterval ti5 = new TimeInterval(DayOfWeek.MONDAY, 11, 15, 75);
		TimeInterval ti6 = new TimeInterval(DayOfWeek.TUESDAY, 11, 15, 75);
		cti3.add(ti5);
		cti3.add(ti6);

		// Add Weekly Time Schedule Specification
		WeeklySchedule w3 = new WeeklySchedule(cti2);

		// Course Enrrolled
		CourseInstance ci5 = new CourseInstance(new Course("CISC", "555", "Hard Math"), 5555);
		CourseInstance ci6 = new CourseInstance(new Course("CISC", "233", "Artificial Intelegence"), 4444);

		Set<CourseInstance> caOneCourseEnrolled3 = new HashSet<CourseInstance>();
		caOneCourseEnrolled2.add(ci5);
		caOneCourseEnrolled2.add(ci6);
		caOneCourseEnrolled2.add(ci4);

		// set First Name, Last Name
		ca3.setFirstName("John");
		ca3.setLastName("Lenon");
		ca3.setEmailAddress("JL@udel.edu");
		ca3.setPossessedSkillset(skillSet3);
		ca3.setWtps(w3);
		ca3.setCourseEnrolled(caOneCourseEnrolled3);
		ca3.setGraduateStudent(true);

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void addCourseAssistantTest() {
		out.println(ca1);
		out.println(ca2);
		out.println(ca3);


		
	    List<CourseAssistant> CourseAssistantSetOne = new ArrayList<CourseAssistant>();
	    CourseAssistantSetOne.add(ca1);
	    CourseAssistantSetOne.add(ca2);
	    
		CourseAssistantPool pool1 = new CourseAssistantPool(CourseAssistantSetOne); 
		out.println("------------------");
		out.println("Before Add");
		pool1.displayCourseAssistants();
		
		pool1.addCourseAssistant(ca3);
		

		
		out.println("Before After Add");
		pool1.displayCourseAssistants();
		out.println("------------------");
		
		boolean ca1Found = false;
		boolean ca2Found = false;
		boolean ca3Found = false;
		Iterable<CourseAssistant> CourseAssistantSetTwo = pool1.getCourseAssistantSet();
		for (CourseAssistant oneCourseAssistant : CourseAssistantSetTwo) {
			if(oneCourseAssistant == ca1){
				ca1Found = true;
			}else if (oneCourseAssistant == ca2) {
				ca2Found = true;
			}else if (oneCourseAssistant == ca3) {
				ca3Found = true;
			}
		}
		assertEquals(ca1Found && ca2Found && ca3Found, true);
		
		
	}
	
	@Test
	public void removeCourseAssistantById() {
		out.println(ca1);
		out.println(ca2);
		out.println(ca3);


		
	    List<CourseAssistant> CourseAssistantSetOne = new ArrayList<CourseAssistant>();
	    CourseAssistantSetOne.add(ca1);
	    CourseAssistantSetOne.add(ca2);
	    
		CourseAssistantPool pool1 = new CourseAssistantPool(CourseAssistantSetOne);  
		pool1.addCourseAssistant(ca3);
		
		boolean ca1Found = false;
		boolean ca2Found = false;
		boolean ca3Found = false;
		Iterable<CourseAssistant> CourseAssistantSetTwo = pool1.getCourseAssistantSet();
		for (CourseAssistant oneCourseAssistant : CourseAssistantSetTwo) {
			if(oneCourseAssistant == ca1){
				ca1Found = true;
			}else if (oneCourseAssistant == ca2) {
				ca2Found = true;
			}else if (oneCourseAssistant == ca3) {
				ca3Found = true;
			}
		}
		assertEquals(ca1Found && ca2Found && ca3Found, true);
		
		pool1.removeCourseAssistantById(111111111);
		
		Iterable<CourseAssistant> CourseAssistantSetThree = pool1.getCourseAssistantSet();
		
		
		ca1Found = false;
		ca2Found = false;
		ca3Found = false;
		for (CourseAssistant oneCourseAssistant : CourseAssistantSetThree) {
			if(oneCourseAssistant == ca1){
				ca1Found = true;
			}else if (oneCourseAssistant == ca2) {
				ca2Found = true;
			}else if (oneCourseAssistant == ca3) {
				ca3Found = true;
			}
		}
		assertEquals(ca1Found && ca2Found && !ca3Found, true);
	}
	
	
	@Test
	public void findCourseAssistantByNameTest() {
		
	    List<CourseAssistant> CourseAssistantSetOne = new ArrayList<CourseAssistant>();
	    CourseAssistantSetOne.add(ca1);
	    CourseAssistantSetOne.add(ca2);
	    
		CourseAssistantPool pool1 = new CourseAssistantPool(CourseAssistantSetOne);  
		pool1.addCourseAssistant(ca3);
		
		boolean ca1Found = false;
		boolean ca2Found = false;
		boolean ca3Found = false;
		
		CourseAssistantPool pool2 = pool1.findCourseAssistantByName("John", "Lenon");
		
		Iterable<CourseAssistant> CourseAssistantSetThree = pool2.getCourseAssistantSet();
		
		for (CourseAssistant oneCourseAssistant : CourseAssistantSetThree) {
			if(oneCourseAssistant == ca1){
				ca1Found = true;
			}else if (oneCourseAssistant == ca2) {
				ca2Found = true;
			}else if (oneCourseAssistant == ca3) {
				ca3Found = true;
			}
			out.println(oneCourseAssistant);
		}
		assertEquals(!ca1Found && !ca2Found && ca3Found, true);
	}
	
	@Test
	public void findCourseAssistantById() {
	    List<CourseAssistant> CourseAssistantSetOne = new ArrayList<CourseAssistant>();
	    CourseAssistantSetOne.add(ca1);
	    CourseAssistantSetOne.add(ca2);
	    
		CourseAssistantPool pool1 = new CourseAssistantPool(CourseAssistantSetOne);  
		pool1.addCourseAssistant(ca3);
		
		CourseAssistant assistantOne = pool1.findCourseAssistantById(111111111);
		CourseAssistant assistantNone = pool1.findCourseAssistantById(0);
		assertEquals(assistantNone, null);
		assertEquals(assistantOne, ca3);
		out.println(assistantOne);
	}
	
	@Test
	public void getSizeTest() {
		out.println(ca1);
		out.println(ca2);
		out.println(ca3);
	    List<CourseAssistant> CourseAssistantSetOne = new ArrayList<CourseAssistant>();
	    CourseAssistantSetOne.add(ca1);
	    CourseAssistantSetOne.add(ca2);
	    
		CourseAssistantPool pool1 = new CourseAssistantPool(CourseAssistantSetOne); 
		pool1.addCourseAssistant(ca2); //add twice this should not be in the course assistant poopl
		assertEquals(pool1.getSize(), 2);

		}

}
