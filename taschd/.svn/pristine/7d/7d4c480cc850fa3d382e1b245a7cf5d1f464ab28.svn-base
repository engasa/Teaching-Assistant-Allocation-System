package edu.udel.cis.taschd.course;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Objects;

import edu.udel.cis.taschd.skill.Skill;
import edu.udel.cis.taschd.skill.SkillSet;

/**
 * Tests of the {@link Course} class.
 *
 * @author matthew
 */
public class CourseTest {

	private static PrintStream out = System.out;

	/**
	 * CISC 675 Software Engineering
	 */
	public static Course c1 = new Course("CISC", "675", "Software Engineering");

	/**
	 * CISC 642 Introduction to Computer Vision
	 */
	public static Course c2 = new Course("CISC", "642", "Intro to Computer Vision");

	/**
	 * CISC 637 Database Systems
	 */
	public static Course c3 = new Course("CISC", "637", "Database Systems");

	/**
	 * CISC 682 Artificial Intelligence
	 */
	public static Course c4 = new Course("CISC", "682", "Artifical Intelligence");

	@Before
	public void setUp() throws Exception {
		SkillSet skillSet1 = new SkillSet(new HashSet<Skill>());
		skillSet1.addSkill(new Skill("Java"));
		skillSet1.addSkill(new Skill("Python"));
		skillSet1.addSkill(new Skill("Javascript"));
		c1.setSkills(skillSet1);
		
		c2.getSkills().addSkill(new Skill("Perl"));
		c2.getSkills().addSkill(new Skill("CSS"));
		c2.getSkills().addSkill(new Skill("HTML"));
		
		SkillSet skillSet3 = new SkillSet(new HashSet<Skill>());
		skillSet3.addSkill(new Skill("PHP"));
		skillSet3.addSkill(new Skill("SQL"));
		skillSet3.addSkill(new Skill("NoSQL"));
		c3.setSkills(skillSet3);
		
		c4.getSkills().addSkill(new Skill("TypeScript"));
		c4.getSkills().addSkill(new Skill("MIPS"));
		c4.getSkills().addSkill(new Skill("Alloy"));
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testHashCode() {
		int h1 = Objects.hash(c1.getPrefix(), c1.getCourseCode(), c1.getCourseName(), c1.getSkills());
		int h2 = Objects.hash(c2.getPrefix(), c2.getCourseCode(), c2.getCourseName(), c2.getSkills());
		int h3 = Objects.hash(c3.getPrefix(), c3.getCourseCode(), c3.getCourseName(), c3.getSkills());
		int h4 = Objects.hash(c4.getPrefix(), c4.getCourseCode(), c4.getCourseName(), c4.getSkills());
		
		assertEquals(c1.hashCode(), h1);
		assertEquals(c2.hashCode(), h2);
		assertEquals(c3.hashCode(), h3);
		assertEquals(c4.hashCode(), h4);
		
		out.println("C1 Hash Code: " + c1.hashCode());
		out.println("C2 Hash Code: " + c2.hashCode());
	}

	@Test (expected = IllegalArgumentException.class)
	public void testGetPrefix() {
		assertEquals(c1.getPrefix(), "CISC");
		assertEquals(c2.getPrefix(), "CISC");
		assertEquals(c3.getPrefix(), "CISC");
		assertEquals(c4.getPrefix(), "CISC");

		out.println("C1 Prefix: " + c1.getPrefix());
		
		Course test1 = new Course("ZZZ", "999", "ZZZZ");
		Course test2 = new Course("Z9Z", "999", "ZZZZ");
		Course test3 = new Course("ZxZ", "999", "ZZZZ");
		Course test4 = new Course("%6", "999", "ZZZZ");
		Course test5 = new Course("ZZZZZ", "999", "ZZZZ");
		
		assertEquals(test1.getPrefix(), new IllegalArgumentException(
                "the prefix must be a 4-character upper-case String"));
		assertEquals(test2.getPrefix(), new IllegalArgumentException(
                "the prefix must be a 4-character upper-case String"));
		assertEquals(test3.getPrefix(), new IllegalArgumentException(
                "the prefix must be a 4-character upper-case String"));
		assertEquals(test4.getPrefix(), new IllegalArgumentException(
                "the prefix must be a 4-character upper-case String"));
		assertEquals(test5.getPrefix(), new IllegalArgumentException(
                "the prefix must be a 4-character upper-case String"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetCourseCode() {
		assertEquals(c1.getCourseCode(), "675");
		assertEquals(c2.getCourseCode(), "642");
		assertEquals(c3.getCourseCode(), "637");
		assertEquals(c4.getCourseCode(), "682");

		out.println("C1 Course Code: " + c1.getCourseCode());
		
		Course test1 = new Course("ZZZ", "90%", "ZZZZ");
		Course test2 = new Course("ZZZ", "9A0", "ZZZZ");
		Course test3 = new Course("ZZZ", "9zZ", "ZZZZ");
		Course test4 = new Course("ZZZ", "9999", "ZZZZ");
		Course test5 = new Course("ZZZ", "", "ZZZZ");
		
		assertEquals(test1.getCourseCode(), new IllegalArgumentException(
                "the course code must be a 3-digit String"));
		assertEquals(test2.getCourseCode(), new IllegalArgumentException(
                "the course code must be a 3-digit String"));
		assertEquals(test3.getCourseCode(), new IllegalArgumentException(
                "the course code must be a 3-digit String"));
		assertEquals(test4.getCourseCode(), new IllegalArgumentException(
                "the course code must be a 3-digit String"));
		assertEquals(test5.getCourseCode(), new IllegalArgumentException(
                "the course code must be a 3-digit String"));
	}

	@Test
	public void testGetCourseName() {
		assertEquals(c1.getCourseName(), "Software Engineering");
		assertEquals(c2.getCourseName(), "Intro to Computer Vision");
		assertEquals(c3.getCourseName(), "Database Systems");
		assertEquals(c4.getCourseName(), "Artifical Intelligence");

		out.println("C1 Course Name: " + c1.getCourseName());
	}

	@Test
	public void testGetSkills() {
		assertEquals(c1.getSkills().toString(), "Java, Javascript, Python");
		assertEquals(c2.getSkills().toString(), "CSS, Perl, HTML");
		assertEquals(c3.getSkills().toString(), "NoSQL, PHP, SQL");
		assertEquals(c4.getSkills().toString(), "TypeScript, MIPS, Alloy");
		
		out.println("C1 Skills: " + c1.getSkills().toString());
		out.println("C2 Skills: " + c2.getSkills().toString());
	}

	@Test
	public void testComparePrefix() {
		assertEquals(c1.comparePrefix(c2), 0);
		assertEquals(c1.comparePrefix(c3), 0);
		assertEquals(c1.comparePrefix(c4), 0);
		assertEquals(c2.comparePrefix(c3), 0);
		out.println("Comparing c1 to c2 prefix:  " + c1.comparePrefix(c2)); // 0

		Course test1 = new Course("ZZZZ", "000", "Test Course 1");
		assertEquals(c1.comparePrefix(test1), -1);
		assertEquals(c2.comparePrefix(test1), -1);
		assertEquals(c3.comparePrefix(test1), -1);
		assertEquals(c4.comparePrefix(test1), -1);
		out.println("Comparing c1 to test prefix:  " + c1.comparePrefix(test1)); // -1

		Course test2 = new Course("AAAA", "999", "Test Course 2");
		assertEquals(c1.comparePrefix(test2), 1);
		assertEquals(c2.comparePrefix(test2), 1);
		assertEquals(c3.comparePrefix(test2), 1);
		assertEquals(c4.comparePrefix(test2), 1);
		out.println("Comparing c1 to test2 prefix:  " + c1.comparePrefix(test2)); // 1
	}

	@Test
	public void testCompareCourseCode() {
		Course test1 = new Course("CISC", "675", "Software Engineering");
		Course test2 = new Course("CISC", "642", "Intro to Computer Vision");
		Course test3 = new Course("CISC", "637", "Database Systems");
		Course test4 = new Course("CISC", "682", "Artificial Intelligence");

		assertEquals(c1.compareCourseCode(test1), 0);
		assertEquals(c2.compareCourseCode(test2), 0);
		assertEquals(c3.compareCourseCode(test3), 0);
		assertEquals(c4.compareCourseCode(test4), 0);
		out.println("Comparing c1 to test1 courseCode:  " + c1.compareCourseCode(test1)); // 0

		Course test5 = new Course("CISC", "999", "Test Course 1");
		assertEquals(c1.compareCourseCode(test4), -1);
		assertEquals(c2.compareCourseCode(test1), -1);
		assertEquals(c3.compareCourseCode(test2), -1);
		assertEquals(c4.compareCourseCode(test5), -1);
		out.println("Comparing c1 to test4 courseCode:  " + c1.compareCourseCode(test4)); // -1

		Course test6 = new Course("CISC", "000", "Test Course 2");
		assertEquals(c1.compareCourseCode(test2), 1);
		assertEquals(c2.compareCourseCode(test3), 1);
		assertEquals(c3.compareCourseCode(test6), 1);
		assertEquals(c4.compareCourseCode(test1), 1);
		out.println("Comparing c1 to test2 courseCode:  " + c1.compareCourseCode(test2)); // 1
	}

	@Test
	public void testCompareCourseName() {
		Course test1 = new Course("CISC", "675", "Software Engineering");
		Course test2 = new Course("CISC", "642", "Intro to Computer Vision");
		Course test3 = new Course("CISC", "637", "Database Systems");
		Course test4 = new Course("CISC", "682", "Artifical Intelligence");

		assertEquals(c1.compareCourseName(test1), 0);
		assertEquals(c2.compareCourseName(test2), 0);
		assertEquals(c3.compareCourseName(test3), 0);
		assertEquals(c4.compareCourseName(test4), 0);
		out.println("Comparing c1 to test1 courseName:  " + c1.compareCourseName(test1)); // 0

		Course test5 = new Course("ZZZZ", "999", "ZZZZ");
		assertEquals(c1.compareCourseName(test5), -1);
		assertEquals(c2.compareCourseName(test5), -1);
		assertEquals(c3.compareCourseName(test5), -1);
		assertEquals(c4.compareCourseName(test5), -1);
		out.println("Comparing c1 to test5 courseName:  " + c1.compareCourseName(test5)); // -1

		Course test6 = new Course("AAAA", "000", "AAAA");
		assertEquals(c1.compareCourseName(test6), 1);
		assertEquals(c2.compareCourseName(test6), 1);
		assertEquals(c3.compareCourseName(test6), 1);
		assertEquals(c4.compareCourseName(test6), 1);
		out.println("Comparing c1 to test6 courseName:  " + c1.compareCourseName(test6)); // 1
	}

	@Test
	public void testToString() {
		assertEquals(c1.toString(), "CISC 675");
		assertEquals(c2.toString(), "CISC 642");
		assertEquals(c3.toString(), "CISC 637");
		assertEquals(c4.toString(), "CISC 682");
	}

	@Test
	public void testEqualsObject() {
		Course test1 = new Course("CISC", "675", "Software Engineering");
		Course test2 = new Course("CISC", "642", "Intro to Computer Vision");

		assertEquals(c1.equals(test1), true);
		assertEquals(c2.equals(test2), true);
		assertEquals(c1.equals(c1), true);
		assertEquals(c2.equals(c2), true);
		out.println("Equals c1 == test1:  " + c1.equals(test1)); // true

		assertEquals(c1.equals(test2), false);
		assertEquals(c2.equals(test1), false);
		assertEquals(c1.equals(c2), false);
		assertEquals(c2.equals(c1), false);
		out.println("Equals c1 == test2:  " + c1.equals(test2)); // false
	}

	@Test
	public void testCompareTo() {
		Course test1 = new Course("CISC", "675", "Software Engineering");
		Course test2 = new Course("CISC", "642", "Intro to Computer Vision");
		Course test3 = new Course("CISC", "637", "Database Systems");
		Course test4 = new Course("CISC", "682", "Artifical Intelligence");

		assertEquals(c1.compareTo(test1), 0);
		assertEquals(c2.compareTo(test2), 0);
		assertEquals(c3.compareTo(test3), 0);
		assertEquals(c4.compareTo(test4), 0);

		Course test5 = new Course("ZZZZ", "999", "ZZZZ Test Course 1");
		assertEquals(c1.compareTo(test5), -1); // Prefix test
		assertEquals(c2.compareTo(test5), -1); // Prefix test
		assertEquals(c3.compareTo(test5), -1); // Prefix test
		assertEquals(c4.compareTo(test5), -1); // Prefix test

		Course test6 = new Course("CISC", "999", "ZZZZ Test Course 1");
		assertEquals(c1.compareTo(test6), -1); // Course code test
		assertEquals(c2.compareTo(test6), -1); // Course name test
		assertEquals(c3.compareTo(test6), -1); // Course name test
		assertEquals(c4.compareTo(test6), -1); // Course name test

		Course test7 = new Course("CISC", "675", "ZZZZ Test Course 1");
		Course test8 = new Course("CISC", "642", "ZZZZ Test Course 1");
		Course test9 = new Course("CISC", "637", "ZZZZ Test Course 1");
		Course test10 = new Course("CISC", "682", "ZZZZ Test Course 1");

		assertEquals(c1.compareTo(test7), -1); // Course code test
		assertEquals(c2.compareTo(test8), -1); // Course code test
		assertEquals(c3.compareTo(test9), -1); // Course code test
		assertEquals(c4.compareTo(test10), -1); // Course code test

		Course test11 = new Course("AAAA", "000", "AAAA Test Course 1");
		assertEquals(c1.compareTo(test11), 1); // Prefix test
		assertEquals(c2.compareTo(test11), 1); // Prefix test
		assertEquals(c3.compareTo(test11), 1); // Prefix test
		assertEquals(c4.compareTo(test11), 1); // Prefix test

		Course test12 = new Course("CISC", "000", "AAAA Test Course 1");
		assertEquals(c1.compareTo(test12), 1); // Course code test
		assertEquals(c2.compareTo(test12), 1); // Course name test
		assertEquals(c3.compareTo(test12), 1); // Course name test
		assertEquals(c4.compareTo(test12), 1); // Course name test

		Course test13 = new Course("CISC", "675", "AAAA Test Course 1");
		Course test14 = new Course("CISC", "642", "AAAA Test Course 1");
		Course test15 = new Course("CISC", "637", "AAAA Test Course 1");
		Course test16 = new Course("CISC", "682", "AAAA Test Course 1");

		assertEquals(c1.compareTo(test13), 1); // Course code test
		assertEquals(c2.compareTo(test14), 1); // Course code test
		assertEquals(c3.compareTo(test15), 1); // Course code test
		assertEquals(c4.compareTo(test16), 1); // Course code test
	}
	
	@Test
	public void testDisplay() {
		c1.display();
		c2.display();
	}

}
