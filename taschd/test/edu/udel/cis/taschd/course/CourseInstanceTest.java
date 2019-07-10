package edu.udel.cis.taschd.course;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.AfterClass;
import org.junit.Before;

import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;

import edu.udel.cis.taschd.skill.Skill;
import edu.udel.cis.taschd.time.TimeInterval;
import edu.udel.cis.taschd.time.WeeklySchedule;

/**
 * Tests of the {@link CourseInstance} class.
 *
 * @author matthew
 */
public class CourseInstanceTest {

	private static PrintStream out = System.out;

	/**
	 * CISC 675 Software Engineering Spring 2019
	 */
	public static CourseInstance ci1 = new CourseInstance(new Course("CISC", "675", "Software Engineering"), 2191);

	/**
	 * CISC 675 Software Engineering Fall 2019
	 */
	public static CourseInstance ci2 = new CourseInstance(new Course("CISC", "642", "Intro to Computer Vision"), 2198);

	@Before
	public void setUp() throws Exception {
		ci1.setHasLab(true);
		ci2.setHasLab(false);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCourseInstance() {
		// Create Lecture Sections WTPS for CISC 675 Fall 2018
		Collection<TimeInterval> cti1 = new ArrayList<TimeInterval>();
		TimeInterval ti1 = new TimeInterval(DayOfWeek.TUESDAY, 11, 15, 75);
		TimeInterval ti2 = new TimeInterval(DayOfWeek.THURSDAY, 11, 15, 75);
		cti1.add(ti1);
		cti1.add(ti2);

		// Create Lab Section WTPS for CISC 675 Fall 2018
		Collection<TimeInterval> cti2 = new ArrayList<TimeInterval>();
		TimeInterval ti3 = new TimeInterval(DayOfWeek.WEDNESDAY, 16, 40, 75);
		cti2.add(ti3);

		// Add sections to Course Instance
		ci1.addSection(new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule(cti1)));
		ci1.addSection(new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule(cti1))); // this
																												// will
																												// not
																												// be
																												// added
																												// as
																												// it
																												// is
																												// duplicated
		ci1.addSection(new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule(cti2)));

		out.println(ci1);

		// Test Course Instance
		assertEquals(ci1.toString(), "CISC 675 - 010 020L");

		// Create Lecture Sections WTPS for CISC 642 Fall 2018
		Collection<TimeInterval> cti3 = new ArrayList<TimeInterval>();
		TimeInterval ti4 = new TimeInterval(DayOfWeek.TUESDAY, 15, 30, 75);
		TimeInterval ti5 = new TimeInterval(DayOfWeek.THURSDAY, 15, 30, 75);
		cti3.add(ti4);
		cti3.add(ti5);

		// Add sections to Course Instance
		ci2.addSection(new Section("", "010", "Kambhamettu,Chandra", 19, 20, "MEM110", new WeeklySchedule(cti3)));

		// Test Course Instance
		out.println(ci2);
		assertEquals(ci2.toString(), "CISC 642 - 010");

		CourseInstance ci3 = new CourseInstance(new Course("CISC", "666", "GhostCourse"), 0000);
		ci3.addSection(new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule(cti2)));
		ci3.addSection(new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule(cti1)));

		assertEquals(ci3.toString(), "CISC 666 - 010 020L");
	}

	@Test
	public void testGetCourse() {
		out.println(ci1.getCourse());
		assertEquals(ci1.getCourse().toString(), "CISC 675");
		assertEquals(ci2.getCourse().toString(), "CISC 642");
	}

	@Test
	public void testIsHasLab() {
		out.println("Course Instance 1 has lab? " + ci1.isHasLab());
		assertEquals(ci1.isHasLab(), true);
		assertEquals(ci2.isHasLab(), false);
	}

	@Test
	public void testGetSections() {
		CourseInstance test1 = new CourseInstance(new Course("CISC", "681", "Artificial Intelligence"), 2191);

		// Create Lecture Sections WTPS for CISC 682 Fall 2018
		Collection<TimeInterval> cti1 = new ArrayList<TimeInterval>();
		TimeInterval ti1 = new TimeInterval(DayOfWeek.MONDAY, 11, 15, 50);
		TimeInterval ti2 = new TimeInterval(DayOfWeek.WEDNESDAY, 11, 15, 50);
		TimeInterval ti3 = new TimeInterval(DayOfWeek.FRIDAY, 11, 15, 50);

		// Add Time Intervals to Section
		cti1.add(ti1);
		cti1.add(ti2);
		cti1.add(ti3);

		test1.addSection(new Section("", "010", "Beheshti,Rahmatollah", 20, 20, "MEM110", new WeeklySchedule(cti1)));

		out.println(test1);

		// Test getSections
		assertEquals(test1.toString(), "CISC 681 - 010");

		// Test number of sections
		int count1 = 0;
		for (@SuppressWarnings("unused")
		Section section : test1.getSections()) {
			count1++;
		}
		assertEquals(count1, 1);

		CourseInstance test2 = new CourseInstance(new Course("CISC", "637", "Database Systems"), 2191);

		// Create Lecture Sections WTPS for CISC 637 Fall 2018
		Collection<TimeInterval> cti2 = new ArrayList<TimeInterval>();
		TimeInterval ti4 = new TimeInterval(DayOfWeek.TUESDAY, 14, 0, 75);
		TimeInterval ti5 = new TimeInterval(DayOfWeek.THURSDAY, 14, 0, 75);

		// Add Time Intervals to Section
		cti2.add(ti4);
		cti2.add(ti5);

		test2.addSection(new Section("", "010", "Shatkay,Hagit", 20, 20, "OSM221", new WeeklySchedule(cti2)));

		out.println(test2);

		// Test getSections
		assertEquals(test2.toString(), "CISC 637 - 010");

		// Test number of sections
		int count2 = 0;
		for (@SuppressWarnings("unused")
		Section section : test2.getSections()) {
			count2++;
		}
		assertEquals(count2, 1);
	}

	@Test
	public void testToString() {
		assertEquals(ci1.toString(), "CISC 675 - 010 020L");
		ci2.addSection(new Section("", "010", "Kambhamettu,Chandra", 19, 20, "MEM110", new WeeklySchedule()));
		assertEquals(ci2.toString(), "CISC 642 - 010");
		out.println(ci1.toString());
	}

	@Test
	public void testDisplay() {
		ci1.getCourse().getSkills().addSkill(new Skill("Java"));
		ci1.getCourse().getSkills().addSkill(new Skill("C++"));
		ci1.display();

		ci2.getCourse().getSkills().addSkill(new Skill("Python"));
		ci2.display();
		assertEquals(ci1.toString(), "CISC 675 - 010 020L");
		assertEquals(ci2.toString(), "CISC 642 - 010");
	}

	@Test
	public void testGetTerm() {

		assertEquals(ci1.getTerm(), 2191);
	}

}
