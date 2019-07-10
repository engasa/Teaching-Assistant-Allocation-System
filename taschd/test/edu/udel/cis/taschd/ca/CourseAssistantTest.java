package edu.udel.cis.taschd.ca;

import edu.udel.cis.taschd.ca.CourseAssistant;
import edu.udel.cis.taschd.course.Course;
import edu.udel.cis.taschd.course.CourseInstance;
import edu.udel.cis.taschd.skill.Skill;
import edu.udel.cis.taschd.skill.SkillSet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import org.junit.After;
import org.junit.Before;

import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import edu.udel.cis.taschd.time.TimeInterval;
import edu.udel.cis.taschd.time.WeeklySchedule;

/**
 * Tests of the {@link CourseAssistant} class.
 *
 * @author Yi Liu
 */
public class CourseAssistantTest {
	private static PrintStream out = System.out;

	/**
	 * CourseAssistant ID:888888888; FirstName: Yi; LastName: Liu;
	 * Email:y@udel.edu
	 * 
	 */
	public static CourseAssistant ca1 = new CourseAssistant(888888888);

	/**
	 * CourseAssistant ID:999999999; FirstName: Mike; LastName: D;
	 * Email:md@udel.edu
	 * 
	 */
	public static CourseAssistant ca2 = new CourseAssistant(999999999);

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

		// ca1
		// make a new skil set
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

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testgetId() {
		out.println(ca1);
		out.println(ca2);

		assertEquals(ca1.getId(), 888888888);
		assertEquals(ca2.getId(), 999999999);

	}

	@Test
	public void testToString() {

		out.println(ca1.toString());
		assertEquals(ca1.toString(), "Liu, Yi (888888888)");
		assertEquals(ca2.toString(), "D, Mike (999999999)");
	}

	@Test
	public void testGetCourseEnrolled() {

		CourseInstance ciTest1 = new CourseInstance(new Course("CISC", "675", "Software Engineering"), 2191);
		CourseInstance ciTest2 = new CourseInstance(new Course("CISC", "642", "Intro to Computer Vision"), 2198);

		Set<CourseInstance> caOneCourseEnrolled = new HashSet<CourseInstance>();
		caOneCourseEnrolled.add(ciTest1);
		caOneCourseEnrolled.add(ciTest2);

		CourseAssistant caTest = new CourseAssistant(333333333);
		caTest.setCourseEnrolled(caOneCourseEnrolled);

		boolean isTheSame = caOneCourseEnrolled.equals(caTest.getCourseEnrolled());
		assertEquals(isTheSame, true);
	}

	@Test
	public void testGetFirstName() {
		assertEquals(ca1.getFirstName(), "Yi");
	}

	@Test
	public void testGetLastName() {
		assertEquals(ca1.getLastName(), "Liu");
	}

	@Test
	public void testGetId() {
		assertEquals(ca1.getId(), 888888888);
	}

	@Test
	public void testGetEmailAddress() {
		assertEquals(ca1.getEmailAddress(), "y@udel.edu");
	}

	@Test
	public void testGetPossessedSkillset() {

		SkillSet skillSet1 = new SkillSet(new HashSet<Skill>());
		skillSet1.addSkill(new Skill("Java"));
		skillSet1.addSkill(new Skill("Python"));
		skillSet1.addSkill(new Skill("Javascript"));

		CourseAssistant caTest = new CourseAssistant(333333333);
		caTest.setPossessedSkillset(skillSet1);

		assertEquals(caTest.getPossessedSkillset(), skillSet1);
	}

	@Test
	public void testGetGraduateStudent() {
		assertEquals(ca1.getGraduateStudent(), true);
	}

	@Test
	public void testGetWtps() {

		Collection<TimeInterval> cti1 = new ArrayList<TimeInterval>();
		TimeInterval ti1 = new TimeInterval(DayOfWeek.TUESDAY, 11, 15, 75);
		TimeInterval ti2 = new TimeInterval(DayOfWeek.THURSDAY, 11, 15, 75);
		cti1.add(ti1);
		cti1.add(ti2);

		// Add Weekly Time Schedule Specification
		WeeklySchedule w1 = new WeeklySchedule(cti1);

		CourseAssistant caTest = new CourseAssistant(333333333);
		caTest.setWtps(w1);

		assertEquals(caTest.getWtps(), w1);
	}

	@Test
	public void testGetSetCourseLoad() {

		CourseAssistant ca3 = new CourseAssistant(333333333);
		ca3.setCourseLoad(60);

		assertEquals(ca3.getCourseLoad(), 60);
	}

	@Test
	public void testCompareFirstName() {

		CourseAssistant ca3 = new CourseAssistant(333333333);
		ca3.setFirstName("Yi");

		CourseAssistant ca4 = new CourseAssistant(444444444);
		ca4.setFirstName("Z");

		out.println(ca3.getFirstName());
		out.println(ca1.getFirstName());
		assertEquals(ca1.compareFirstName(ca2), 1);
		assertEquals(ca1.compareFirstName(ca3), 0);
		assertEquals(ca1.compareFirstName(ca4), -1);
	}

	@Test
	public void testCompareLastName() {
		CourseAssistant ca3 = new CourseAssistant(333333333);
		ca3.setLastName("Liu");

		CourseAssistant ca4 = new CourseAssistant(444444444);
		ca4.setLastName("Z");
		assertEquals(ca1.compareLastName(ca2), 1);
		assertEquals(ca1.compareLastName(ca3), 0);
		assertEquals(ca1.compareLastName(ca4), -1);
	}

	@Test
	public void testCompareId() {
		CourseAssistant ca3 = new CourseAssistant(333333333);
		CourseAssistant ca4 = new CourseAssistant(888888888);
		assertEquals(ca1.compareId(ca2), -1);
		assertEquals(ca1.compareId(ca3), 1);
		assertEquals(ca1.compareId(ca4), 0);
	}

	@Test
	public void testDisplay() {
		ca1.display();
		ca2.display();
	}

	@Test
	public void testEquals() {
		CourseAssistant ca3 = new CourseAssistant(333333333);
		CourseAssistant ca4 = new CourseAssistant(888888888);
		CourseAssistant ca5 = new CourseAssistant(333333333);

		assertEquals(ca3.equals(ca5), true);
		assertEquals(ca3.equals(ca4), false);
	}

	@Test
	public void testHashCode() {
		int h1 = Objects.hash(ca1.getId());
		int h2 = Objects.hash(ca2.getId());

		assertEquals(ca1.hashCode(), h1);
		assertEquals(ca2.hashCode(), h2);
	}

	@Test
	public void testCompareTo() {
		CourseAssistant ca3 = new CourseAssistant(333333333);
		CourseAssistant ca4 = new CourseAssistant(444444444);
		CourseAssistant ca5 = new CourseAssistant(555555555);
		CourseAssistant ca6 = new CourseAssistant(666666666);

		ca5.setLastName("A");
		ca5.setFirstName("Z");

		ca3.setLastName("B");
		ca3.setFirstName("C");

		ca4.setLastName("B");
		ca4.setFirstName("B");

		ca6.setLastName("B");
		ca6.setFirstName("B");

		assertEquals(ca5.compareTo(ca3), -1);
		assertEquals(ca3.compareTo(ca4), 1);
		assertEquals(ca4.compareTo(ca6), -1);
	}

}
