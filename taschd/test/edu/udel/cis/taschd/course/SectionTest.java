package edu.udel.cis.taschd.course;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import org.junit.Test;

import edu.udel.cis.taschd.time.TimeInterval;
import edu.udel.cis.taschd.time.WeeklySchedule;

import org.junit.After;
import org.junit.Before;

/**
 * Tests of the {@link Section} class.
 *
 * @author matthew
 * @author Yi Liu
 */
public class SectionTest {

	private static PrintStream out = System.out;

	/**
	 * CISC 675 Software Engineering
	 */
	public static Section s1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());

	/**
	 * CISC 675 Software Engineering
	 */
	public static Section s2 = new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());

	@Before
	public void setUp() throws Exception {
		// Create Lecture Sections WTPS for Section s1
		Collection<TimeInterval> cti1 = new ArrayList<TimeInterval>();
		TimeInterval ti1 = new TimeInterval(DayOfWeek.TUESDAY, 11, 15, 75);
		TimeInterval ti2 = new TimeInterval(DayOfWeek.THURSDAY, 11, 15, 75);
		cti1.add(ti1);
		cti1.add(ti2);

		// Add Weekly Time Schedule Specification
		WeeklySchedule w1 = new WeeklySchedule(cti1);
		s1.setSchedule(w1);

		// Create Lab Section WTPS for CISC 675 Fall 2018
		Collection<TimeInterval> cti2 = new ArrayList<TimeInterval>();
		TimeInterval ti3 = new TimeInterval(DayOfWeek.WEDNESDAY, 16, 40, 75);
		cti2.add(ti3);

		// Add Weekly Time Schedule Specification
		WeeklySchedule w2 = new WeeklySchedule(cti2);
		s2.setSchedule(w2);

		s2.setTaAssigned(true);
		s2.setNumOfLA(0);
		s2.setNumOfTA(1);
		s2.setMtac(true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHashCode() {
		int h1 = Objects.hash(s1.getSectionType(), s1.getSectionNumber(), s1.getCurrentEnrollment(),
				s1.getEnrollmentCap(), s1.getLocation(), s1.getInstructorName(), s1.getSchedule(), s1.getNumOfTA(),
				s1.getNumOfLA(), s1.isMtac(), s1.isTaAssigned());
		int h2 = Objects.hash(s2.getSectionType(), s2.getSectionNumber(), s2.getCurrentEnrollment(),
				s2.getEnrollmentCap(), s2.getLocation(), s2.getInstructorName(), s2.getSchedule(), s2.getNumOfTA(),
				s2.getNumOfLA(), s2.isMtac(), s2.isTaAssigned());

		assertEquals(s1.hashCode(), h1);
		assertEquals(s2.hashCode(), h2);

		out.println("Section 1 Hash Code: " + s1.hashCode());
		out.println("Section 2 Hash Code: " + s2.hashCode());
	}

	@Test
	public void testGetSectionType() {
		assertEquals(s1.getSectionType(), "");
		assertEquals(s2.getSectionType(), "L");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetSectionNumber() {
		assertEquals(s1.getSectionNumber(), "010");
		assertEquals(s2.getSectionNumber(), "020");

		Section test1 = new Section("L", "", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());
		Section test2 = new Section("L", "0Q0", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());
		Section test3 = new Section("L", "0000", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());
		Section test4 = new Section("L", "9&c", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());
		out.println(s1.getSectionNumber());

		assertEquals(test1.getSectionType(),
				new IllegalArgumentException("the section number must be a 3-digit String"));
		assertEquals(test2.getSectionType(),
				new IllegalArgumentException("the section number must be a 3-digit String"));
		assertEquals(test3.getSectionType(),
				new IllegalArgumentException("the section number must be a 3-digit String"));
		assertEquals(test4.getSectionType(),
				new IllegalArgumentException("the section number must be a 3-digit String"));
	}

	@Test
	public void testGetInstructorName() {
		out.println(s1.getInstructorName());
		assertEquals(s1.getInstructorName(), "Siegel,Stephen");
		assertEquals(s2.getInstructorName(), "Siegel,Stephen");
	}

	@Test
	public void testGetCurrentEnrollment() {
		assertEquals(s1.getCurrentEnrollment(), 11);
		assertEquals(s2.getCurrentEnrollment(), 11);
	}

	@Test
	public void testGetEnrollmentCap() {
		assertEquals(s1.getEnrollmentCap(), 20);
		assertEquals(s2.getEnrollmentCap(), 35);
	}

	@Test
	public void testGetLocation() {
		assertEquals(s1.getLocation(), "MDH216");
		assertEquals(s2.getLocation(), "BRL205");
	}

	@Test
	public void testGetSchedule() {
	}

	@Test
	public void testSetSchedule() {
	}

	@Test
	public void testIsTaAssigned() {
		assertEquals(s1.isTaAssigned(), false);
		assertEquals(s2.isTaAssigned(), true);
	}

	@Test
	public void testGetNumOfTA() {
		assertEquals(s1.getNumOfTA(), 0);
		assertEquals(s2.getNumOfTA(), 1);
	}

	@Test
	public void testGetNumOfLA() {
		assertEquals(s1.getNumOfLA(), 0);
		assertEquals(s2.getNumOfLA(), 0);
	}

	@Test
	public void testIsMtac() {
		assertEquals(s1.isMtac(), false);
		assertEquals(s2.isMtac(), true);
		out.println(s1);
	}

	@Test
	public void testEqualsObject() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());

		assertEquals(s1.equals(test1), true);
		assertEquals(s2.equals(test2), true);
		assertEquals(s1.equals(s1), true);
		assertEquals(s2.equals(s2), true);
		out.println("Equals c1 == test1:  " + s1.equals(test1)); // true

		assertEquals(s1.equals(test2), false);
		assertEquals(s2.equals(test1), false);
		assertEquals(s1.equals(s2), false);
		assertEquals(s2.equals(s1), false);
		out.println("Equals c1 == test2:  " + s1.equals(test2)); // false
	}

	@Test
	public void testCompareSectionType() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());
		Section test3 = new Section("A", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test4 = new Section("Z", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());

		assertEquals(s1.compareSectionType(test1), 0);
		assertEquals(s2.compareSectionType(test2), 0);
		out.println("Comparing Section 1 to Test 1 sectionType:  " + s1.compareSectionType(test1)); // 0

		assertEquals(s1.compareSectionType(test2), -1);
		assertEquals(s1.compareSectionType(test3), -1);
		assertEquals(s2.compareSectionType(test4), -1);
		out.println("Comparing Section 1 to Test 2 sectionType:  " + s1.compareSectionType(test2)); // -1

		assertEquals(s2.compareSectionType(test1), 1);
		assertEquals(s2.compareSectionType(test3), 1);
		out.println("Comparing Section 2 to Test 1 sectionType:  " + s2.compareSectionType(test1)); // 1
	}

	@Test
	public void testCompareSectionNumber() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());
		Section test3 = new Section("A", "999", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test4 = new Section("Z", "000", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());

		assertEquals(s1.compareSectionNumber(test1), 0);
		assertEquals(s2.compareSectionNumber(test2), 0);
		out.println("Comparing Section 1 to Test 1 sectionNumber:  " + s1.compareSectionNumber(test1)); // 0

		assertEquals(s1.compareSectionNumber(test2), -1);
		assertEquals(s1.compareSectionNumber(test3), -1);
		assertEquals(s2.compareSectionNumber(test3), -1);
		out.println("Comparing Section 1 to Test 2 sectionNumber:  " + s1.compareSectionNumber(test2)); // -1

		assertEquals(s2.compareSectionNumber(test1), 1);
		assertEquals(s1.compareSectionNumber(test4), 1);
		out.println("Comparing Section 2 to Test 1 sectionNumber:  " + s2.compareSectionNumber(test1)); // 1
	}

	@Test
	public void testCompareInstructorName() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());
		Section test3 = new Section("A", "999", "Pollock,Lori", 11, 20, "MDH216", new WeeklySchedule());
		Section test4 = new Section("Z", "000", "Zig,Ziglar", 11, 20, "MDH216", new WeeklySchedule());

		assertEquals(s1.compareInstructorName(test1), 0);
		assertEquals(s2.compareInstructorName(test2), 0);
		assertEquals(s1.compareInstructorName(test2), 0);
		assertEquals(s2.compareInstructorName(test1), 0);
		out.println("Comparing Section 1 to Test 1 instructorName:  " + s1.compareInstructorName(test1)); // 0

		assertEquals(s1.compareInstructorName(test4), -1);
		assertEquals(s2.compareInstructorName(test4), -1);
		out.println("Comparing Section 1 to Test 4 instructorName:  " + s1.compareInstructorName(test4)); // -1

		assertEquals(s2.compareInstructorName(test3), 1);
		assertEquals(s1.compareInstructorName(test3), 1);
		out.println("Comparing Section 2 to Test 3 instructorName:  " + s2.compareInstructorName(test3)); // 1
	}

	@Test
	public void testCompareCurrentEnrollment() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 15, 35, "BRL205", new WeeklySchedule());
		Section test3 = new Section("A", "999", "Pollock,Lori", 0, 20, "MDH216", new WeeklySchedule());
		Section test4 = new Section("Z", "000", "Zig,Ziglar", 99, 20, "MDH216", new WeeklySchedule());

		assertEquals(s1.compareCurrentEnrollment(test1), 0);
		assertEquals(s2.compareCurrentEnrollment(test1), 0);
		out.println("Comparing Section 1 to Test 1 currentEnrollment:  " + s1.compareCurrentEnrollment(test1)); // 0

		assertEquals(s1.compareCurrentEnrollment(test4), -1);
		assertEquals(s2.compareCurrentEnrollment(test4), -1);
		assertEquals(s2.compareCurrentEnrollment(test2), -1);
		assertEquals(s1.compareCurrentEnrollment(test2), -1);
		out.println("Comparing Section 1 to Test 4 currentEnrollment:  " + s1.compareCurrentEnrollment(test4)); // -1

		assertEquals(s2.compareCurrentEnrollment(test3), 1);
		assertEquals(s1.compareCurrentEnrollment(test3), 1);
		out.println("Comparing Section 2 to Test 3 currentEnrollment:  " + s2.compareCurrentEnrollment(test3)); // 1
	}

	@Test
	public void testCompareEnrollmentCap() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 15, 35, "BRL205", new WeeklySchedule());
		Section test3 = new Section("A", "999", "Pollock,Lori", 0, 15, "MDH216", new WeeklySchedule());
		Section test4 = new Section("Z", "000", "Zig,Ziglar", 99, 40, "MDH216", new WeeklySchedule());

		assertEquals(s1.compareEnrollmentCap(test1), 0);
		assertEquals(s2.compareEnrollmentCap(test2), 0);
		out.println("Comparing Section 1 to Test 1 enrollmentCap:  " + s1.compareEnrollmentCap(test1)); // 0

		assertEquals(s1.compareEnrollmentCap(test4), -1);
		assertEquals(s2.compareEnrollmentCap(test4), -1);
		assertEquals(s1.compareEnrollmentCap(test2), -1);
		out.println("Comparing Section 1 to Test 4 enrollmentCap:  " + s1.compareEnrollmentCap(test4)); // -1

		assertEquals(s2.compareEnrollmentCap(test3), 1);
		assertEquals(s1.compareEnrollmentCap(test3), 1);
		assertEquals(s2.compareEnrollmentCap(test1), 1);
		out.println("Comparing Section 2 to Test 3 enrollmentCap:  " + s2.compareEnrollmentCap(test3)); // 1
	}

	@Test
	public void testCompareLocation() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 15, 35, "BRL205", new WeeklySchedule());
		Section test3 = new Section("A", "999", "Pollock,Lori", 0, 15, "AAA000", new WeeklySchedule());
		Section test4 = new Section("Z", "000", "Zig,Ziglar", 99, 40, "ZZZ999", new WeeklySchedule());

		assertEquals(s1.compareLocation(test1), 0);
		assertEquals(s2.compareLocation(test2), 0);
		out.println("Comparing Section 1 to Test 1 location:  " + s1.compareLocation(test1)); // 0

		assertEquals(s1.compareLocation(test4), -1);
		assertEquals(s2.compareLocation(test4), -1);
		assertEquals(s2.compareLocation(test1), -1);
		out.println("Comparing Section 1 to Test 4 location:  " + s1.compareLocation(test4)); // -1

		assertEquals(s2.compareLocation(test3), 1);
		assertEquals(s1.compareLocation(test3), 1);
		assertEquals(s1.compareLocation(test2), 1);
		out.println("Comparing Section 2 to Test 3 location:  " + s2.compareLocation(test3)); // 1
	}

	@Test
	public void testCompareNumberOfTA() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 15, 35, "BRL205", new WeeklySchedule());
		Section test3 = new Section("L", "020", "Siegel,Stephen", 15, 35, "BRL205", new WeeklySchedule());
		Section test4 = new Section("L", "020", "Siegel,Stephen", 15, 35, "BRL205", new WeeklySchedule());

		s1.setNumOfTA(0);
		test1.setNumOfTA(5);
		test2.setNumOfTA(4);
		test3.setNumOfTA(0);
		test4.setNumOfTA(1);

		assertEquals(s1.compareNumberOfTA(test3), 0);
		assertEquals(s2.compareNumberOfTA(test4), 0);
		out.println("Comparing Section 1 to Test 3 numberOfTA:  " + s1.compareNumberOfTA(test3)); // 0

		assertEquals(s1.compareNumberOfTA(test1), -1);
		assertEquals(s1.compareNumberOfTA(test2), -1);
		assertEquals(s1.compareNumberOfTA(test4), -1);
		assertEquals(s1.compareNumberOfTA(s2), -1);
		out.println("Comparing Section 1 to Test 1 numberOfTA:  " + s1.compareNumberOfTA(test1)); // -1

		// Set Section 1 numberOfTA to 10
		s1.setNumOfTA(10);
		assertEquals(s1.compareNumberOfTA(test1), 1);
		assertEquals(s1.compareNumberOfTA(test2), 1);
		assertEquals(s1.compareNumberOfTA(test3), 1);
		assertEquals(s1.compareNumberOfTA(test4), 1);
		out.println("Comparing Section 1 to Test 1 numberOfTA:  " + s1.compareNumberOfTA(test1)); // 1
	}

	@Test
	public void testCompareNumberOfLA() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 15, 35, "BRL205", new WeeklySchedule());
		Section test3 = new Section("L", "020", "Siegel,Stephen", 15, 35, "BRL205", new WeeklySchedule());
		Section test4 = new Section("L", "020", "Siegel,Stephen", 15, 35, "BRL205", new WeeklySchedule());

		s1.setNumOfLA(0);
		s2.setNumOfLA(1);
		test1.setNumOfLA(5);
		test2.setNumOfLA(4);
		test3.setNumOfLA(0);
		test4.setNumOfLA(1);

		assertEquals(s1.compareNumberOfLA(test3), 0);
		assertEquals(s2.compareNumberOfLA(test4), 0);
		out.println("Comparing Section 1 to Test 3 numberOfLA:  " + s1.compareNumberOfLA(test3)); // 0

		assertEquals(s1.compareNumberOfLA(test1), -1);
		assertEquals(s1.compareNumberOfLA(test2), -1);
		assertEquals(s1.compareNumberOfLA(test4), -1);
		assertEquals(s1.compareNumberOfLA(s2), -1);
		out.println("Comparing Section 1 to Test 1 numberOfLA:  " + s1.compareNumberOfLA(test1)); // -1

		// Set Section 1 numberOfLA to 10
		s1.setNumOfLA(10);
		assertEquals(s1.compareNumberOfLA(test1), 1);
		assertEquals(s1.compareNumberOfLA(test2), 1);
		assertEquals(s1.compareNumberOfLA(test3), 1);
		assertEquals(s1.compareNumberOfLA(test4), 1);
		out.println("Comparing Section 1 to Test 1 numberOfLA:  " + s1.compareNumberOfLA(test1)); // 1
	}

	@Test
	public void testCompareMTAC() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 15, 35, "BRL205", new WeeklySchedule());

		s1.setMtac(false);
		test1.setMtac(false);
		test2.setMtac(true);

		assertEquals(s1.compareMTAC(test1), 0);
		assertEquals(s2.compareMTAC(test2), 0);
		out.println("Comparing Section 1 to Test 1 mtac:  " + s1.compareMTAC(test1)); // 0

		assertEquals(s2.compareMTAC(test1), -1);
		assertEquals(s2.compareMTAC(s1), -1);
		out.println("Comparing Section 2 to Test 1 mtac:  " + s2.compareMTAC(test1)); // -1

		assertEquals(s1.compareMTAC(test2), 1);
		assertEquals(s1.compareMTAC(s2), 1);
		out.println("Comparing Section 1 to Test 2 mtac:  " + s1.compareMTAC(test2)); // 1
	}

	@Test
	public void testCompareTaAssigned() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 15, 35, "BRL205", new WeeklySchedule());

		s1.setTaAssigned(false);
		test1.setTaAssigned(false);
		test2.setTaAssigned(true);

		assertEquals(s1.compareTaAssigned(test1), 0);
		assertEquals(s2.compareTaAssigned(test2), 0);
		out.println("Comparing Section 1 to Test 1 taAssigned:  " + s1.compareTaAssigned(test1)); // 0

		assertEquals(s2.compareTaAssigned(test1), -1);
		assertEquals(s2.compareTaAssigned(s1), -1);
		out.println("Comparing Section 2 to Test 1 taAssigned:  " + s2.compareTaAssigned(test1)); // -1

		assertEquals(s1.compareTaAssigned(test2), 1);
		assertEquals(s1.compareTaAssigned(s2), 1);
		out.println("Comparing Section 1 to Test 2 taAssigned:  " + s1.compareTaAssigned(test2)); // 1
	}

	@Test
	public void testCompareTo() {
		Section test1 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test2 = new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());
		s1.setMtac(false);
		s1.setTaAssigned(false);
		test1.setMtac(false);
		test1.setTaAssigned(false);

		// Create Lecture Sections WTPS for Section s1
		Collection<TimeInterval> testcti1 = new ArrayList<TimeInterval>();
		TimeInterval testti1 = new TimeInterval(DayOfWeek.TUESDAY, 11, 15, 75);
		TimeInterval testti2 = new TimeInterval(DayOfWeek.THURSDAY, 11, 15, 75);
		testcti1.add(testti1);
		testcti1.add(testti2);

		// Add Weekly Time Schedule Specification
		WeeklySchedule testw1 = new WeeklySchedule(testcti1);
		test1.setSchedule(testw1);

		// Create Lab Section WTPS for CISC 675 Fall 2018
		Collection<TimeInterval> testcti2 = new ArrayList<TimeInterval>();
		TimeInterval testti3 = new TimeInterval(DayOfWeek.WEDNESDAY, 16, 40, 75);
		testcti2.add(testti3);

		// Add Weekly Time Schedule Specification
		WeeklySchedule testw2 = new WeeklySchedule(testcti2);
		test2.setSchedule(testw2);

		test2.setTaAssigned(true);
		test2.setNumOfLA(0);
		test2.setNumOfTA(1);
		test2.setMtac(true);

		// out.println(s1.toString()+"\n");
		// out.println(test1.toString());
		//
		// out.println(s2.toString()+"\n");
		// out.println(test2.toString());

		assertEquals(s1.compareTo(test1), 0);
		assertEquals(s2.compareTo(test2), 0);

		Section test3 = new Section("A", "000", "AAA", 0, 5, "AAA000", new WeeklySchedule());
		Section test4 = new Section("Z", "999", "ZZZZ", 99, 99, "ZZZ999", new WeeklySchedule());

		assertEquals(s1.compareTo(test3), -1); // Section type test
		assertEquals(s1.compareTo(test4), -1); // Section type test
		assertEquals(s1.compareTo(s2), -1); // Section type test

		assertEquals(s2.compareTo(test1), 1); // Section type test
		assertEquals(s2.compareTo(test3), 1); // Section type test
		assertEquals(s2.compareTo(s1), 1); // Section type test

		Section test5 = new Section("", "000", "AAA", 0, 5, "AAA000", new WeeklySchedule());
		Section test6 = new Section("L", "999", "ZZZZ", 99, 99, "ZZZ999", new WeeklySchedule());

		assertEquals(s1.compareTo(test6), -1); // Section number test
		assertEquals(s2.compareTo(test6), -1); // Section number test
		assertEquals(test1.compareTo(test6), -1); // Section number test

		assertEquals(s1.compareTo(test5), 1); // Section number test
		assertEquals(s2.compareTo(test5), 1); // Section number test
		assertEquals(test1.compareTo(test5), 1); // Section number test

		Section test7 = new Section("", "010", "AAA", 0, 5, "AAA000", new WeeklySchedule());
		Section test8 = new Section("L", "020", "ZZZZ", 99, 99, "ZZZ999", new WeeklySchedule());

		assertEquals(s1.compareTo(test8), -1); // Instructor name test
		assertEquals(s2.compareTo(test8), -1); // Instructor name test
		assertEquals(test1.compareTo(test8), -1); // Instructor name test
		assertEquals(test2.compareTo(test8), -1); // Instructor name test

		assertEquals(s1.compareTo(test7), 1); // Instructor name test
		assertEquals(s2.compareTo(test7), 1); // Instructor name test
		assertEquals(test1.compareTo(test7), 1); // Instructor name test
		assertEquals(test2.compareTo(test7), 1); // Instructor name test

		Section test9 = new Section("", "010", "Siegel,Stephen", 0, 5, "AAA000", new WeeklySchedule());
		Section test10 = new Section("L", "020", "Siegel,Stephen", 99, 99, "ZZZ999", new WeeklySchedule());

		assertEquals(s1.compareTo(test10), -1); // Current enrollment test
		assertEquals(s2.compareTo(test10), -1); // Current enrollment test
		assertEquals(test1.compareTo(test10), -1); // Current enrollment test
		assertEquals(test2.compareTo(test10), -1); // Current enrollment test

		assertEquals(s1.compareTo(test9), 1); // Current enrollment test
		assertEquals(s2.compareTo(test9), 1); // Current enrollment test
		assertEquals(test1.compareTo(test9), 1); // Current enrollment test
		assertEquals(test2.compareTo(test9), 1); // Current enrollment test

		Section test11 = new Section("", "010", "Siegel,Stephen", 11, 5, "AAA000", new WeeklySchedule());
		Section test12 = new Section("L", "020", "Siegel,Stephen", 11, 99, "ZZZ999", new WeeklySchedule());

		assertEquals(s1.compareTo(test12), -1); // Enrollment cap test
		assertEquals(s2.compareTo(test12), -1); // Enrollment cap test
		assertEquals(test1.compareTo(test12), -1); // Enrollment cap test
		assertEquals(test2.compareTo(test12), -1); // Enrollment cap test

		assertEquals(s1.compareTo(test11), 1); // Enrollment cap test
		assertEquals(s2.compareTo(test11), 1); // Enrollment cap test
		assertEquals(test1.compareTo(test11), 1); // Enrollment cap test
		assertEquals(test2.compareTo(test11), 1); // Enrollment cap test

		Section test13 = new Section("", "010", "Siegel,Stephen", 11, 20, "AAA000", new WeeklySchedule());
		Section test14 = new Section("L", "020", "Siegel,Stephen", 11, 35, "ZZZ999", new WeeklySchedule());

		assertEquals(s1.compareTo(test14), -1); // Location test
		assertEquals(s2.compareTo(test14), -1); // Location test
		assertEquals(test1.compareTo(test14), -1); // Location test
		assertEquals(test2.compareTo(test14), -1); // Location test

		assertEquals(s1.compareTo(test13), 1); // Location test
		assertEquals(s2.compareTo(test13), 1); // Location test
		assertEquals(test1.compareTo(test13), 1); // Location test
		assertEquals(test2.compareTo(test13), 1); // Location test

		Section test15 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
		Section test16 = new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());

		// out.println(s1.getNumOfTA());
		// out.println(test15.getNumOfTA());
		// out.println(s1.compareNumberOfTA(test15));
		// out.println(test16.compareNumberOfTA(s2));
		//
		// out.println(s2.compareNumberOfTA(test16));
		// out.println(test15.compareNumberOfTA(s1));
		// out.println(s1.toString());
		// out.println(test15.toString());

		test15.setNumOfTA(1);
		test16.setNumOfTA(0);

		assertEquals(s1.compareTo(test15), -1); // Number of TA test
		assertEquals(test16.compareTo(s2), -1); // Number of TA test

		assertEquals(s2.compareTo(test16), 1); // Number of TA test
		assertEquals(test15.compareTo(s1), 1); // Number of TA test

		// out.println(s1.getNumOfLA());
		// out.println(test15.getNumOfLA());
		// out.println(s1.compareNumberOfLA(test15));
		// out.println(test16.compareNumberOfLA(s2));
		//
		// out.println(s2.compareNumberOfLA(test16));
		// out.println(test15.compareNumberOfLA(s1));

		// Resetting Number of TA's to match s1 & s2
		test15.setNumOfTA(0);
		test16.setNumOfTA(1);

		test15.setNumOfLA(1);
		test16.setNumOfLA(1);

		assertEquals(s1.compareTo(test15), -1); // Number of LA test
		assertEquals(s2.compareTo(test16), -1); // Number of LA test

		assertEquals(test15.compareTo(s1), 1); // Number of LA test
		assertEquals(test16.compareTo(s2), 1); // Number of LA test

		// Resetting Number of LA's to match s1 & s2
		test15.setNumOfLA(0);
		test16.setNumOfLA(0);

		test15.setMtac(true);
		test16.setMtac(false);

		assertEquals(s1.compareTo(test15), 1); // MTAC test
		assertEquals(test16.compareTo(s2), 1); // MTAC test

		assertEquals(s2.compareTo(test16), -1); // MTAC test
		assertEquals(test15.compareTo(s1), -1); // MTAC test

		// Resetting Number of LA's to match s1 & s2
		test15.setMtac(false);
		test16.setMtac(true);

		test15.setTaAssigned(true);
		test16.setTaAssigned(false);

		assertEquals(s1.compareTo(test15), 1); // TA Assigned test
		assertEquals(test16.compareTo(s2), 1); // TA Assigned test

		assertEquals(s2.compareTo(test16), -1); // TA Assigned test
		assertEquals(test15.compareTo(s1), -1); // TA Assigned test
	}

	@Test
	public void testToString() {
		out.println(s1);

		assertEquals(s1.toString(), "010 - Siegel,Stephen");
		assertEquals(s2.toString(), "020L - Siegel,Stephen");
	}

	@Test
	public void testDisplay() {
		s1.display();

	}
}