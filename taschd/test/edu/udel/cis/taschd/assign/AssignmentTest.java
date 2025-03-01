package edu.udel.cis.taschd.assign;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.udel.cis.taschd.assign.Assignment;
import edu.udel.cis.taschd.ca.CourseAssistant;
import edu.udel.cis.taschd.course.Section;
import edu.udel.cis.taschd.time.WeeklySchedule;


/**
 * 
 * Tests of the {@link Assignment} class.
 * 
 * @author zhangjianbo
 *
 */
public class AssignmentTest {

	
	Section sec1 = null; // new Section();

	CourseAssistant ca1 = null; // Need to create one
	
	// test case 2
	Section sec2 = new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule());
	
	CourseAssistant ca2 = new CourseAssistant(191191021);
	
	// test case 3
	Section sec3 = new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule());
	
	CourseAssistant ca3 = new CourseAssistant(759512932);
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		Assignment assign1 = new Assignment();

		assign1.setCaForSection(sec1, ca1);
		
		assertEquals(new HashSet<>(Arrays.asList(ca1)),
				assign1.getCasForSection(sec1));
		assertEquals(new HashSet<>(Arrays.asList(sec1)),
				assign1.getSectionForCa(ca1));
	}
	
	@Test
	public void test2() {
		Assignment assign2 = new Assignment();

		assign2.setCaForSection(sec2, ca2);
		
		assertEquals(new HashSet<>(Arrays.asList(ca2)),
				assign2.getCasForSection(sec2));
		assertEquals(new HashSet<>(Arrays.asList(sec2)),
				assign2.getSectionForCa(ca2));
	}
	
	@Test
	public void test3() {
		Assignment assign3 = new Assignment();

		assign3.setCaForSection(sec2, ca2);
		assign3.setCaForSection(sec2, ca1);
		
		assertEquals(new HashSet<>(Arrays.asList(new CourseAssistant[]{ca1, ca2})),
				assign3.getCasForSection(sec2));
		assertEquals(new HashSet<>(Arrays.asList(sec2)),
				assign3.getSectionForCa(ca2));
		assertEquals(new HashSet<>(Arrays.asList(sec2)),
				assign3.getSectionForCa(ca1));
	}
	
	@Test
	public void test4() {
		Assignment assign4 = new Assignment();

		assign4.setCaForSection(sec2, ca2);
		assign4.setCaForSection(sec1, ca1);
		assign4.setCaForSection(sec3, ca3);
		assign4.setCaForSection(sec3, ca1);
		
		assertEquals(new HashSet<>(Arrays.asList(new CourseAssistant[]{ca1, ca3})),
				assign4.getCasForSection(sec3));
		assertEquals(new HashSet<>(Arrays.asList(sec2)),
				assign4.getSectionForCa(ca2));
		assertEquals(new HashSet<>(Arrays.asList(new Section[]{sec1, sec3})),
				assign4.getSectionForCa(ca1));
	}
	
	@Test
	public void test5() {
		Assignment assign5 = new Assignment();

		assign5.setCaForSection(sec1, ca2);
		assign5.setCaForSection(sec1, ca1);
		assign5.setCaForSection(sec1, ca3);
		assign5.setCaForSection(sec2, ca2);
		assign5.setCaForSection(sec3, ca2);
		assign5.setCaForSection(sec2, ca1);
		
		assertEquals(new HashSet<>(Arrays.asList(new CourseAssistant[]{ca2})),
				assign5.getCasForSection(sec3));
		assertEquals(new HashSet<>(Arrays.asList(new CourseAssistant[]{ca1, ca2})),
				assign5.getCasForSection(sec2));
		assertEquals(new HashSet<>(Arrays.asList(new CourseAssistant[]{ca1, ca2, ca3})),
				assign5.getCasForSection(sec1));
		assertEquals(new HashSet<>(Arrays.asList(sec1, sec2, sec3)),
				assign5.getSectionForCa(ca2));
		assertEquals(new HashSet<>(Arrays.asList(new Section[]{sec1, sec2})),
				assign5.getSectionForCa(ca1));
	}
	
	

}
