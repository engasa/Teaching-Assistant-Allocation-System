package edu.udel.cis.taschd.gen;

//import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import edu.udel.cis.taschd.assign.Assignment;
import edu.udel.cis.taschd.ca.CourseAssistant;
import edu.udel.cis.taschd.ca.CourseAssistantPool;
import edu.udel.cis.taschd.course.Course;
import edu.udel.cis.taschd.course.CourseInstance;
import edu.udel.cis.taschd.course.CourseInstancePool;
import edu.udel.cis.taschd.course.Section;
import edu.udel.cis.taschd.skill.Skill;
import edu.udel.cis.taschd.skill.SkillSet;
import edu.udel.cis.taschd.time.TimeInterval;
import edu.udel.cis.taschd.time.WeeklySchedule;

/**
 * Tests of the {@link LPSovler} class.
 * 
 * There are Three test cases
 *
 * @author Yi Liu
 */
public class LPSolverTest {

	@Test
	public void testNumOfTAMoreThanNumOfSection() {
		/**
		 * In this test, number of sections will be more than course assistants. This
		 * test Case will show that the program tends to assign ca into sections under
		 * the same Course;
		 * 
		 * Also, good good will be qulified for all sections; 9 CA; Barack Obama;
		 * Benjamin Franklin; Bill Clinton; Denzel Washiton; Donald Duck; Good1 Good1;
		 * good good will be qulified for all sections; Good2 Good2; good good will be
		 * qulified for all sections; Good3 Good3; good good will be qulified for all
		 * sections; dummy dummy; who is not qualified for any of these course.
		 * 
		 * 3 Course; 7 sections;
		 *
		 * Course A || Skills Required - C, Matlab 110 : 20 students; Schedule: Mon
		 * 0:00–1:00, NumofTA 1, Qualified CA will be Barack Obama; Benjamin Franklin ,
		 * Bill Clinton 120 : 20 students; Schedule: TUE 0:00–1:00, NumofTA 1, Qualified
		 * CA will be Barack Obama; Benjamin Franklin, Bill Clinton 130 : 20 students;
		 * schedule: WED 0:00–1:00, NumofTA 1, Qualified CA will be Barack Obama;
		 * Benjamin Franklin , Bill Clinton
		 * ----------------------------------------------------------------------------------------------------
		 * Course B || Skills Required - JAVA Section Information (Term 2191): 210, 20,
		 * Tue 9:30–10:45 Qualified CA will be Bill Clinton, Denzel Washiton 220, 20,
		 * Tue 11:00–12:15; Thu 11:00–12:15, Qualified CA will be Bill Clinton, Denzel
		 * Washition
		 * 
		 * CISC 304 Logic and Programming || Skills Required - 604 Section Information
		 * (Term 2191): 310, 20, Tue 11:00–12:15; Thu 11:00–12:15, SHL120, Carberry
		 * Qualified CA will be: Donald Duck,
		 * 
		 * 
		 */
		System.out.println("--------------------------------------");
		System.out.println("------------TEST1------------");
		// Create a Course Assistant Pool object
		CourseAssistant ca1 = new CourseAssistant(111);
		CourseAssistant ca2 = new CourseAssistant(222);
		CourseAssistant ca3 = new CourseAssistant(333);
		CourseAssistant ca4 = new CourseAssistant(444);
		CourseAssistant ca5 = new CourseAssistant(555);
		CourseAssistant ca6 = new CourseAssistant(666);
		CourseAssistant ca7 = new CourseAssistant(777);
		CourseAssistant ca8 = new CourseAssistant(888);
		CourseAssistant ca9 = new CourseAssistant(999);

		////////////////// CA 1 //////////////////////////////////////
		ca1.setFirstName("Barack");
		ca1.setLastName("Obama");
		ca1.setEmailAddress("yeswecan@udel.edu");
		SkillSet skillSet1 = new SkillSet();
		skillSet1.addSkill(new Skill("SQL"));
		skillSet1.addSkill(new Skill("Swift"));
		skillSet1.addSkill(new Skill("Matlab"));
		skillSet1.addSkill(new Skill("Bash"));
		skillSet1.addSkill(new Skill(".NET"));
		skillSet1.addSkill(new Skill("C"));
		ca1.setPossessedSkillset(skillSet1);

		// Create WTPS for CourseAssisstant1
		Collection<TimeInterval> cti2 = new ArrayList<TimeInterval>();
		TimeInterval ti1 = new TimeInterval(DayOfWeek.TUESDAY, 14, 0, 75);
		TimeInterval ti2 = new TimeInterval(DayOfWeek.THURSDAY, 14, 0, 75);
		TimeInterval ti3 = new TimeInterval(DayOfWeek.FRIDAY, 11, 0, 75);
		cti2.add(ti1);
		cti2.add(ti2);
		cti2.add(ti3);
		WeeklySchedule w1 = new WeeklySchedule(cti2);
		ca1.setWtps(w1);
		ca1.setGraduateStudent(true);
		////////////////// CA 2 //////////////////////////////////////
		// set First Name, Last Name
		// Benjamin know java, but schedules is not good for CISC 275 BBB-Introduction
		////////////////// to Software Engineering
		ca2.setFirstName("Benjamin");
		ca2.setLastName("Franklin");
		ca2.setEmailAddress("bfrank@udel.edu");
		SkillSet skillSet2 = new SkillSet();
		skillSet2.addSkill(new Skill("Matlab"));
		skillSet2.addSkill(new Skill("C"));
		skillSet2.addSkill(new Skill("ASP.NET"));
		skillSet2.addSkill(new Skill("JAVA"));
		ca2.setPossessedSkillset(skillSet2);

		// Create WTPS for CourseAssisstant2
		Collection<TimeInterval> cta2 = new ArrayList<TimeInterval>();
		TimeInterval tcnn1 = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval tcnn2 = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		TimeInterval tcnn3 = new TimeInterval(DayOfWeek.TUESDAY, 10, 52, 75);

		cta2.add(tcnn1);
		cta2.add(tcnn2);
		cta2.add(tcnn3);
		WeeklySchedule w2 = new WeeklySchedule(cta2);
		ca2.setWtps(w2);
		ca2.setGraduateStudent(true);
		////////////////// CA 3 //////////////////////////////////////
		// set First Name, Last Name
		ca3.setFirstName("Bill");
		ca3.setLastName("Clinton");
		ca3.setEmailAddress("billclinton@udel.edu");
		SkillSet skillSet3 = new SkillSet();
		skillSet3.addSkill(new Skill("Java"));
		skillSet3.addSkill(new Skill("C"));
		skillSet3.addSkill(new Skill("Matlab"));

		ca3.setPossessedSkillset(skillSet3);

		// Create WTPS for CourseAssisstant3
		Collection<TimeInterval> ctb2 = new ArrayList<TimeInterval>();
		TimeInterval tb1 = new TimeInterval(DayOfWeek.FRIDAY, 15, 30, 75);

		ctb2.add(tb1);

		WeeklySchedule x2 = new WeeklySchedule(ctb2);
		ca3.setWtps(x2);
		ca3.setGraduateStudent(true);
		////////////////// CA 4 //////////////////////////////////////
		// set First Name, Last Name
		ca4.setFirstName("Denzel");
		ca4.setLastName("Washington");
		ca4.setEmailAddress("trainingday@udel.edu");
		SkillSet skillSet4 = new SkillSet();
		skillSet4.addSkill(new Skill("Java"));
		skillSet4.addSkill(new Skill("Alloy"));
		skillSet4.addSkill(new Skill("Perl"));
		skillSet4.addSkill(new Skill("only"));
		ca4.setPossessedSkillset(skillSet4);

		// Create WTPS for CourseAssisstant4
		Collection<TimeInterval> ctc2 = new ArrayList<TimeInterval>();

		TimeInterval ctt = new TimeInterval(DayOfWeek.FRIDAY, 11, 0, 75);

		ctc2.add(ctt);
		WeeklySchedule v2 = new WeeklySchedule(ctc2);
		ca4.setWtps(v2);
		ca4.setGraduateStudent(true);
		////////////////// CA 5 //////////////////////////////////////
		// set First Name, Last Name
		ca5.setFirstName("Donald");
		ca5.setLastName("Duck");
		ca5.setEmailAddress("dduck@udel.edu");
		SkillSet skillSet5 = new SkillSet();
		skillSet5.addSkill(new Skill("Python"));
		skillSet5.addSkill(new Skill("PHP"));
		skillSet5.addSkill(new Skill("Matalb"));
		skillSet5.addSkill(new Skill("C"));

		skillSet5.addSkill(new Skill("604"));
		ca5.setPossessedSkillset(skillSet5);

		// Create WTPS for CourseAssisstant5
		Collection<TimeInterval> cxc2 = new ArrayList<TimeInterval>();

		TimeInterval zc9 = new TimeInterval(DayOfWeek.FRIDAY, 8, 40, 75);
		TimeInterval zc10 = new TimeInterval(DayOfWeek.WEDNESDAY, 00, 00, 60);
		TimeInterval zc11 = new TimeInterval(DayOfWeek.MONDAY, 00, 00, 60);
		TimeInterval zc12 = new TimeInterval(DayOfWeek.TUESDAY, 00, 00, 60);

		cxc2.add(zc9);
		cxc2.add(zc10);
		cxc2.add(zc11);
		cxc2.add(zc12);

		WeeklySchedule z2 = new WeeklySchedule(cxc2);
		ca5.setWtps(z2);
		ca5.setGraduateStudent(true);

		////////////////// CA 6 //////////////////////////////////////
		// set First Name, Last Name
		ca6.setFirstName("Dummy");
		ca6.setLastName("Dummy");
		ca6.setEmailAddress("dduck@udel.edu");
		SkillSet skillSet6 = new SkillSet();
		skillSet5.addSkill(new Skill("000"));
		ca6.setPossessedSkillset(skillSet6);

		// Create WTPS for CourseAssisstant6
		Collection<TimeInterval> cxc6 = new ArrayList<TimeInterval>();

		TimeInterval zc6 = new TimeInterval(DayOfWeek.FRIDAY, 8, 40, 75);

		cxc6.add(zc6);

		WeeklySchedule z6 = new WeeklySchedule(cxc2);
		ca6.setWtps(z6);
		ca6.setGraduateStudent(true);

		////////////////// CA 7 //////////////////////////////////////
		// set First Name, Last Name
		ca7.setFirstName("Good1");
		ca7.setLastName("Good1");
		ca7.setEmailAddress("Good1@udel.edu");
		SkillSet skillSet7 = new SkillSet();
		skillSet7.addSkill(new Skill("Java"));
		skillSet7.addSkill(new Skill("604"));
		skillSet7.addSkill(new Skill("C"));
		skillSet7.addSkill(new Skill("Matlab"));
		ca7.setPossessedSkillset(skillSet7);

		// Create WTPS for CourseAssisstant7
		Collection<TimeInterval> ctc7 = new ArrayList<TimeInterval>();

		TimeInterval ctt71 = new TimeInterval(DayOfWeek.FRIDAY, 0, 0, 10);

		ctc7.add(ctt71);
		WeeklySchedule v7 = new WeeklySchedule(ctc7);
		ca7.setWtps(v7);
		ca7.setGraduateStudent(true);

		////////////////// CA 8 //////////////////////////////////////
		// set First Name, Last Name
		ca8.setFirstName("Good2");
		ca8.setLastName("Good2");
		ca8.setEmailAddress("Good2@udel.edu");
		SkillSet skillSet8 = new SkillSet();
		skillSet8.addSkill(new Skill("Java"));
		skillSet8.addSkill(new Skill("604"));
		skillSet8.addSkill(new Skill("C"));
		skillSet8.addSkill(new Skill("Matlab"));
		ca8.setPossessedSkillset(skillSet8);

		// Create WTPS for CourseAssisstant8
		Collection<TimeInterval> ctc8 = new ArrayList<TimeInterval>();

		TimeInterval ctt81 = new TimeInterval(DayOfWeek.FRIDAY, 0, 0, 10);

		ctc8.add(ctt81);
		WeeklySchedule v8 = new WeeklySchedule(ctc8);
		ca8.setWtps(v8);
		ca8.setGraduateStudent(true);

		////////////////// CA 9 //////////////////////////////////////
		// set First Name, Last Name
		ca9.setFirstName("Good3");
		ca9.setLastName("Good3");
		ca9.setEmailAddress("Good2@udel.edu");
		SkillSet skillSet9 = new SkillSet();
		skillSet9.addSkill(new Skill("Java"));
		skillSet9.addSkill(new Skill("604"));
		skillSet9.addSkill(new Skill("C"));
		skillSet9.addSkill(new Skill("Matlab"));
		ca9.setPossessedSkillset(skillSet9);

		// Create WTPS for CourseAssisstant9
		Collection<TimeInterval> ctc9 = new ArrayList<TimeInterval>();

		TimeInterval ctt91 = new TimeInterval(DayOfWeek.FRIDAY, 0, 0, 10);

		ctc9.add(ctt91);
		WeeklySchedule v9 = new WeeklySchedule(ctc9);
		ca9.setWtps(v9);
		ca9.setGraduateStudent(true);

		// Add COURSE CA POOL;
		CourseAssistantPool cap = new CourseAssistantPool();
		cap.addCourseAssistant(ca1);
		cap.addCourseAssistant(ca2);
		cap.addCourseAssistant(ca3);
		cap.addCourseAssistant(ca4);
		cap.addCourseAssistant(ca5);
		cap.addCourseAssistant(ca6);
		cap.addCourseAssistant(ca7);
		cap.addCourseAssistant(ca8);
		cap.addCourseAssistant(ca9);

		System.out.println("Course Assistant Pool\n");
		Iterable<CourseAssistant> i = cap.getCourseAssistantSet();
		for (CourseAssistant c : i) {
			c.display();
			// System.out.println(c.getWtps().toString());
			// System.out.println(c.toString());
		}

		////////////////// CI 1 //////////////////////////////////////
		ArrayList<CourseInstance> pool1 = new ArrayList<>();
		// Create WTPS for CourseAssisstant5
		Collection<TimeInterval> emw1 = new ArrayList<TimeInterval>();
		TimeInterval er1 = new TimeInterval(DayOfWeek.MONDAY, 00, 00, 60);
		emw1.add(er1);
		pool1.add(new CourseInstance(new Course("CISC", "210", "AAA-Introduction to Systems Programming"), 2191));
		Section s = new Section("Lec", "110", "Silber", 20, 20, "A-A-GOR208", new WeeklySchedule(emw1));
		s.setMtac(true);
		s.setNumOfLA(0);
		s.setNumOfTA(1);
		pool1.get(0).addSection(s);

		Collection<TimeInterval> emw2 = new ArrayList<TimeInterval>();
		TimeInterval er4 = new TimeInterval(DayOfWeek.TUESDAY, 00, 00, 60);
		emw2.add(er4);
		Section s2 = new Section("L", "120", "Silber", 20, 20, "A-B-PRS101", new WeeklySchedule(emw2));
		s2.setMtac(true);
		s2.setNumOfLA(0);
		s2.setNumOfTA(1);
		s.setCorrespondingLab(s2);
		s2.setCorrespondingLecture(s);
		pool1.get(0).addSection(s2);

		Collection<TimeInterval> emw3 = new ArrayList<TimeInterval>();
		TimeInterval er6 = new TimeInterval(DayOfWeek.WEDNESDAY, 00, 00, 60);
		emw3.add(er6);
		Section s3 = new Section("L", "130", "Silber", 20, 20, "A-C-PRS101", new WeeklySchedule(emw3));
		s3.setMtac(true);
		s3.setNumOfLA(0);
		s3.setNumOfTA(1);
		s3.setCorrespondingLecture(s);
		s3.setTaAssigned(false);
		pool1.get(0).addSection(s3);

		TimeInterval er7 = new TimeInterval(DayOfWeek.THURSDAY, 00, 00, 60);
		Collection<TimeInterval> emw4 = new ArrayList<TimeInterval>();
		emw4.add(er7);

		Section s4 = new Section("L", "140", "Silber", 20, 20, "A-D-PRS101", new WeeklySchedule(emw4));
		s4.setMtac(true);
		s4.setNumOfLA(0);
		s4.setNumOfTA(1);
		pool1.get(0).addSection(s4);
		pool1.get(0).getCourse().getSkills().addSkill(new Skill("C"));
		pool1.get(0).getCourse().getSkills().addSkill(new Skill("Matlab"));
		pool1.get(0).setHasLab(true);

		////////////////// CI 2 //////////////////////////////////////
		pool1.add(new CourseInstance(new Course("CISC", "275", "BBB-Introduction to Software Engineering"), 2191));
		Collection<TimeInterval> ss1 = new ArrayList<TimeInterval>();
		TimeInterval e2 = new TimeInterval(DayOfWeek.TUESDAY, 9, 30, 75);
		ss1.add(e2);

		Section p = new Section("Lec", "210", "Harvey", 20, 40, "B-A-GOR117", new WeeklySchedule(ss1));
		p.setMtac(true);
		p.setNumOfLA(0);
		p.setNumOfTA(1);
		p.setMtac(true);

		pool1.get(1).addSection(p);
		pool1.get(1).getCourse().getSkills().addSkill(new Skill("Java"));

		Collection<TimeInterval> tm = new ArrayList<TimeInterval>();
		TimeInterval cc = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval vv = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		tm.add(cc);
		tm.add(vv);

		Section p2 = new Section("Lec", "220", "Harvey", 20, 40, "B-B-GOR117", new WeeklySchedule(tm));
		p2.setMtac(true);
		p2.setNumOfLA(0);
		p2.setNumOfTA(1);
		pool1.get(1).addSection(p2);

		////////////////// CI 3 //////////////////////////////////////
		pool1.add(new CourseInstance(new Course("CISC", "304", "Logic and Programming"), 2191));
		Collection<TimeInterval> hh = new ArrayList<TimeInterval>();
		TimeInterval qw = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval wq = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		hh.add(qw);
		hh.add(wq);
		Section q = new Section("Lec", "310", "Carberry", 20, 35, "SHL120", new WeeklySchedule(hh));
		q.setNumOfLA(0);
		q.setNumOfTA(1);
		q.setMtac(true);

		pool1.get(2).addSection(q);
		pool1.get(2).setHasLab(false);
		pool1.get(2).getCourse().getSkills().addSkill(new Skill("604"));

		// Create a Course Instance Pool object
		System.out.println("\nCourse Instance Pool\n");
		CourseInstancePool cip = new CourseInstancePool(pool1);
		Iterable<CourseInstance> i2 = cip.getCourseInstanceSet();

		for (CourseInstance c2 : i2) {
			c2.display();
		}
		System.out.println("\n");
		LPSolver cplexTest = new LPSolver(cap, cip);

		ArrayList<ArrayList<Double>> testTwo = cplexTest.getScoreTable();

		System.out.println("\n");

		//System.out.println("Score Table: ");

		for (int count = 0; count < testTwo.size(); count++) {
			System.out.println(testTwo.get(count).toString());
		}

		System.out.println("\n");

		System.out.println("In this test, number of sections will be more than course assistants.\n"
				+ "		 * This test Case will show that the program tends to assign ca into sections under the same Course;"
				+ "e.g Obama for example; also, for 210 and 220, two ca assigned to this two section;"
				+ "because the capacity of this two section is 40; ");
		cplexTest.assign().displayAll(System.out);
//		Assignment assignmentVerify = new Assignment();
//		assignmentVerify.setCaForSection(s2, ca1);
//		assignmentVerify.setCaForSection(p, ca4);
//		assignmentVerify.setCaForSection(q, ca5);
//		assignmentVerify.setCaForSection(s, ca1);
//		assignmentVerify.setCaForSection(s, ca2);
//		assignmentVerify.setCaForSection(s4, ca3);
//		assignmentVerify.setCaForSection(s3, ca2);
//		
//		
//
//		assertEquals(cplexTest.getAssignment().getCasForSection(s2), assignmentVerify.getCasForSection(s2));
//		assertEquals(cplexTest.getAssignment().getCasForSection(s), assignmentVerify.getCasForSection(s));
//		assertEquals(cplexTest.getAssignment().getCasForSection(s4), assignmentVerify.getCasForSection(s4));
//		assertEquals(cplexTest.getAssignment().getCasForSection(p), assignmentVerify.getCasForSection(p));
//		assertEquals(cplexTest.getAssignment().getCasForSection(s3), assignmentVerify.getCasForSection(s3));
//		assertEquals(cplexTest.getAssignment().getCasForSection(q), assignmentVerify.getCasForSection(q));

	}

	@Test
	public void testNumOfTAlessThanNumOfSection() {
		
		/**
		 * 
		 * Course 1(Sections 100, 110, 120, 130) All TA in this tests cases are graduate
		 * student; Skill will be qualified TA: Obama, Franklin,Clinton,Donald
		 * 
		 * 
		 * Section 100: Number of TA required is 2; 
		 * Workload for this section is 40;
		 * wtps will be qualified TA: Obama Franklin Clinton Washington 
		 * Final result should be: Obama or Franklin or Clinton 
		 * 
		 * Section 110: Number of TA required is 1;
		 * Workload for this section is 20;
		 * wtps will be qualified TA: Obama Franklin
		 * Clinton Washington Final result should be: Obama or Franklin or Clinton
		 * 
		 * Section 120:
		 * 
		 * Number of TA required is 1; 
		 * Workload for this section is 20; 
		 * wtps will be qualified TA: Obama Franklin Clinton Washington 
		 * Final result should be: Obama or Franklin or Clinton 
		 * 
		 * Section 130:
		 * 
		 * Number of TA required is 1;
		 *  Workload for this section is 20;
		 *  wtps will be qualified TA: Obama Franklin Clinton Washington 
		 *  Final result should be: Obama or Franklin or Clinton
		 * 
		 * Course 2(Sections 210, 220) 
		 * All TA in this tests cases are graduate student;
		 * Skill will be qualified TA: Franklin, Clinton, Washington
		 * 
		 * 
		 * Section 210:
		 * Number of TA required is 1;
		 * Workload for this section is 40;
		 * wtps will be qualified TA: Obama, Franklin,Clinton,Washington, Donald, Dummy
		 * Final result should be: Clinton or Washington 
		 * Section 220: Number of TA required is 1;
		 * Workload for this section is 40;
		 * wtps will be qualified TA:
		 * Obama, Clinton Washington 
		 * Final result should be: Obama or Clinton
		 * 
		 * Course 3(Sections 310) 
		 * All TA in this tests cases are graduate student; 
		 * Skill will be qualified TA: Donald
		 * 
		 * 
		 * Section 210: Number of TA required is 1;
		 *  Workload for this section is 35;
		 * wtps will be qualified TA: Obama, Clinton, Washington, Donald, Dummy 
		 * Final result should be: Donald
		 */
		System.out.println("--------------------------------------");
		System.out.println("------------TEST2------------");
		// Create a Course Assistant Pool object
		CourseAssistant ca1 = new CourseAssistant(111);
		CourseAssistant ca2 = new CourseAssistant(222);
		CourseAssistant ca3 = new CourseAssistant(333);
		CourseAssistant ca4 = new CourseAssistant(444);
		CourseAssistant ca5 = new CourseAssistant(555);
		CourseAssistant ca6 = new CourseAssistant(666);

		////////////////// CA 1 //////////////////////////////////////
		ca1.setFirstName("Barack");
		ca1.setLastName("Obama");
		ca1.setEmailAddress("yeswecan@udel.edu");
		SkillSet skillSet1 = new SkillSet();
		skillSet1.addSkill(new Skill("SQL"));
		skillSet1.addSkill(new Skill("Swift"));
		skillSet1.addSkill(new Skill("Matlab"));
		skillSet1.addSkill(new Skill("Bash"));
		skillSet1.addSkill(new Skill(".NET"));
		skillSet1.addSkill(new Skill("C"));
		ca1.setPossessedSkillset(skillSet1);

		// Create WTPS for CourseAssisstant1
		Collection<TimeInterval> cti2 = new ArrayList<TimeInterval>();
		TimeInterval ti1 = new TimeInterval(DayOfWeek.TUESDAY, 14, 0, 75);
		TimeInterval ti2 = new TimeInterval(DayOfWeek.THURSDAY, 14, 0, 75);
		TimeInterval ti3 = new TimeInterval(DayOfWeek.FRIDAY, 11, 0, 75);
		cti2.add(ti1);
		cti2.add(ti2);
		cti2.add(ti3);
		WeeklySchedule w1 = new WeeklySchedule(cti2);
		ca1.setWtps(w1);
		ca1.setGraduateStudent(true);
		////////////////// CA 2 //////////////////////////////////////
		// set First Name, Last Name
		// Benjamin know java, but schedules is not good for CISC 275 BBB-Introduction
		////////////////// to Software Engineering
		ca2.setFirstName("Benjamin");
		ca2.setLastName("Franklin");
		ca2.setEmailAddress("bfrank@udel.edu");
		SkillSet skillSet2 = new SkillSet();
		skillSet2.addSkill(new Skill("Matlab"));
		skillSet2.addSkill(new Skill("C"));
		skillSet2.addSkill(new Skill("ASP.NET"));
		skillSet2.addSkill(new Skill("JAVA"));
		ca2.setPossessedSkillset(skillSet2);

		// Create WTPS for CourseAssisstant2
		Collection<TimeInterval> cta2 = new ArrayList<TimeInterval>();
		TimeInterval tcnn1 = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval tcnn2 = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		TimeInterval tcnn3 = new TimeInterval(DayOfWeek.TUESDAY, 10, 52, 75);

		cta2.add(tcnn1);
		cta2.add(tcnn2);
		cta2.add(tcnn3);
		WeeklySchedule w2 = new WeeklySchedule(cta2);
		ca2.setWtps(w2);
		ca2.setGraduateStudent(true);
		////////////////// CA 3 //////////////////////////////////////
		// set First Name, Last Name
		ca3.setFirstName("Bill");
		ca3.setLastName("Clinton");
		ca3.setEmailAddress("billclinton@udel.edu");
		SkillSet skillSet3 = new SkillSet();
		skillSet3.addSkill(new Skill("Java"));
		skillSet3.addSkill(new Skill("C"));
		skillSet3.addSkill(new Skill("Matlab"));

		ca3.setPossessedSkillset(skillSet3);

		// Create WTPS for CourseAssisstant3
		Collection<TimeInterval> ctb2 = new ArrayList<TimeInterval>();
		TimeInterval tb1 = new TimeInterval(DayOfWeek.FRIDAY, 15, 30, 75);

		ctb2.add(tb1);

		WeeklySchedule x2 = new WeeklySchedule(ctb2);
		ca3.setWtps(x2);
		ca3.setGraduateStudent(true);
		////////////////// CA 4 //////////////////////////////////////
		// set First Name, Last Name
		ca4.setFirstName("Denzel");
		ca4.setLastName("Washington");
		ca4.setEmailAddress("trainingday@udel.edu");
		SkillSet skillSet4 = new SkillSet();
		skillSet4.addSkill(new Skill("Java"));
		skillSet4.addSkill(new Skill("Alloy"));
		skillSet4.addSkill(new Skill("Perl"));
		ca4.setPossessedSkillset(skillSet4);

		// Create WTPS for CourseAssisstant4
		Collection<TimeInterval> ctc2 = new ArrayList<TimeInterval>();

		TimeInterval ctt = new TimeInterval(DayOfWeek.FRIDAY, 11, 0, 75);

		ctc2.add(ctt);
		WeeklySchedule v2 = new WeeklySchedule(ctc2);
		ca4.setWtps(v2);
		ca4.setGraduateStudent(true);
		////////////////// CA 5 //////////////////////////////////////
		// set First Name, Last Name
		ca5.setFirstName("Donald");
		ca5.setLastName("Duck");
		ca5.setEmailAddress("dduck@udel.edu");
		SkillSet skillSet5 = new SkillSet();
		skillSet5.addSkill(new Skill("Python"));
		skillSet5.addSkill(new Skill("PHP"));
		skillSet5.addSkill(new Skill("Matalb"));
		skillSet5.addSkill(new Skill("C"));

		skillSet5.addSkill(new Skill("604"));
		ca5.setPossessedSkillset(skillSet5);

		// Create WTPS for CourseAssisstant5
		Collection<TimeInterval> cxc2 = new ArrayList<TimeInterval>();

		TimeInterval zc9 = new TimeInterval(DayOfWeek.FRIDAY, 8, 40, 75);
		TimeInterval zc10 = new TimeInterval(DayOfWeek.WEDNESDAY, 00, 00, 60);
		TimeInterval zc11 = new TimeInterval(DayOfWeek.MONDAY, 00, 00, 60);
		TimeInterval zc12 = new TimeInterval(DayOfWeek.TUESDAY, 00, 00, 60);

		cxc2.add(zc9);
		cxc2.add(zc10);
		cxc2.add(zc11);
		cxc2.add(zc12);

		WeeklySchedule z2 = new WeeklySchedule(cxc2);
		ca5.setWtps(z2);
		ca5.setGraduateStudent(true);

		////////////////// CA 6 //////////////////////////////////////
		// set First Name, Last Name
		ca6.setFirstName("Dummy");
		ca6.setLastName("Dummy");
		ca6.setEmailAddress("dduck@udel.edu");
		SkillSet skillSet6 = new SkillSet();
		skillSet5.addSkill(new Skill("000"));
		ca6.setPossessedSkillset(skillSet6);

		// Create WTPS for CourseAssisstant6
		Collection<TimeInterval> cxc6 = new ArrayList<TimeInterval>();

		TimeInterval zc6 = new TimeInterval(DayOfWeek.FRIDAY, 8, 40, 75);

		cxc6.add(zc6);

		WeeklySchedule z6 = new WeeklySchedule(cxc2);
		ca6.setWtps(z6);
		ca6.setGraduateStudent(true);

		CourseAssistantPool cap = new CourseAssistantPool();
		cap.addCourseAssistant(ca1);
		cap.addCourseAssistant(ca2);
		cap.addCourseAssistant(ca3);
		cap.addCourseAssistant(ca4);
		cap.addCourseAssistant(ca5);
		cap.addCourseAssistant(ca6);

		System.out.println("Course Assistant Pool\n");
		Iterable<CourseAssistant> i = cap.getCourseAssistantSet();
		for (CourseAssistant c : i) {
			c.display();
			// System.out.println(c.getWtps().toString());
			// System.out.println(c.toString());
		}

		////////////////// CI 1 //////////////////////////////////////
		ArrayList<CourseInstance> pool1 = new ArrayList<>();
		// Create WTPS for CourseAssisstant5
		Collection<TimeInterval> emw1 = new ArrayList<TimeInterval>();
		TimeInterval er1 = new TimeInterval(DayOfWeek.MONDAY, 00, 00, 60);
		emw1.add(er1);
		pool1.add(new CourseInstance(new Course("CISC", "210", "AAA-Introduction to Systems Programming"), 2191));
		Section s = new Section("Lec", "100", "Silber", 40, 40, "A-A-GOR208", new WeeklySchedule(emw1));
		s.setMtac(true);
		s.setNumOfLA(0);
		s.setNumOfTA(2);
		pool1.get(0).addSection(s);

		Collection<TimeInterval> emw2 = new ArrayList<TimeInterval>();
		TimeInterval er4 = new TimeInterval(DayOfWeek.TUESDAY, 00, 00, 60);
		emw2.add(er4);
		Section s2 = new Section("L", "110", "Silber", 20, 20, "A-B-PRS101", new WeeklySchedule(emw2));
		s2.setMtac(true);
		s2.setNumOfLA(0);
		s2.setNumOfTA(1);
		s.setCorrespondingLab(s2);
		s2.setCorrespondingLecture(s);
		pool1.get(0).addSection(s2);

		Collection<TimeInterval> emw3 = new ArrayList<TimeInterval>();
		TimeInterval er6 = new TimeInterval(DayOfWeek.WEDNESDAY, 00, 00, 60);
		emw3.add(er6);
		Section s3 = new Section("L", "120", "Silber", 20, 20, "A-C-PRS101", new WeeklySchedule(emw3));
		s3.setMtac(true);
		s3.setNumOfLA(0);
		s3.setNumOfTA(1);
		s3.setCorrespondingLecture(s);
		s3.setTaAssigned(false);
		pool1.get(0).addSection(s3);

		TimeInterval er7 = new TimeInterval(DayOfWeek.THURSDAY, 00, 00, 60);
		Collection<TimeInterval> emw4 = new ArrayList<TimeInterval>();
		emw4.add(er7);

		Section s4 = new Section("L", "130", "Silber", 20, 20, "A-D-PRS101", new WeeklySchedule(emw4));
		s4.setMtac(true);
		s4.setNumOfLA(0);
		s4.setNumOfTA(1);
		pool1.get(0).addSection(s4);
		pool1.get(0).getCourse().getSkills().addSkill(new Skill("C"));
		pool1.get(0).getCourse().getSkills().addSkill(new Skill("Matlab"));
		pool1.get(0).setHasLab(true);

		////////////////// CI 2 //////////////////////////////////////
		pool1.add(new CourseInstance(new Course("CISC", "275", "BBB-Introduction to Software Engineering"), 2191));
		Collection<TimeInterval> ss1 = new ArrayList<TimeInterval>();
		TimeInterval e2 = new TimeInterval(DayOfWeek.TUESDAY, 9, 30, 75);
		ss1.add(e2);

		Section p = new Section("Lec", "210", "Harvey", 40, 40, "B-A-GOR117", new WeeklySchedule(ss1));
		p.setMtac(true);
		p.setNumOfLA(0);
		p.setNumOfTA(1);
		p.setMtac(true);

		pool1.get(1).addSection(p);
		pool1.get(1).setHasLab(true);
		pool1.get(1).getCourse().getSkills().addSkill(new Skill("Java"));

		Collection<TimeInterval> tm = new ArrayList<TimeInterval>();
		TimeInterval cc = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval vv = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		tm.add(cc);
		tm.add(vv);
		Section p2 = new Section("Lec", "220", "Harvey", 40, 40, "B-B-GOR117", new WeeklySchedule(tm));
		p2.setMtac(true);
		p2.setNumOfLA(0);
		p2.setNumOfTA(1);
		p2.setTaAssigned(false);
		pool1.get(1).addSection(p2);

		////////////////// CI 3 //////////////////////////////////////
		pool1.add(new CourseInstance(new Course("CISC", "304", "Logic and Programming"), 2191));
		Collection<TimeInterval> hh = new ArrayList<TimeInterval>();
		TimeInterval qw = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval wq = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		hh.add(qw);
		hh.add(wq);
		Section q = new Section("Lec", "310", "Carberry", 35, 35, "SHL120", new WeeklySchedule(hh));
		q.setNumOfLA(0);
		q.setNumOfTA(1);
		q.setMtac(true);

		pool1.get(2).addSection(q);
		pool1.get(2).setHasLab(false);
		pool1.get(2).getCourse().getSkills().addSkill(new Skill("604"));

		// Create a Course Instance Pool object
		System.out.println("\nCourse Instance Pool\n");
		CourseInstancePool cip = new CourseInstancePool(pool1);
		Iterable<CourseInstance> i2 = cip.getCourseInstanceSet();

		for (CourseInstance c2 : i2) {
			c2.display();
		}

		LPSolver cplexTest = new LPSolver(cap, cip);

		ArrayList<ArrayList<Double>> testTwo = cplexTest.getScoreTable();

		// System.out.println(testTwo.size());

		//System.out.println("Score Table: ");

		for (int count = 0; count < testTwo.size(); count++) {
			System.out.println(testTwo.get(count).toString());
		}

		System.out.println("\n");
		System.out.println("\n");
		System.out.println(
				"Test, TA less than sections \n6 TA; 3 course; 7 sections; 110; 120; 130; 140; 210; 220; 230, 310;"
						+ "\nsection 100Lec: requires two TA");

		cplexTest.assign().displayAll(System.out);
		Assignment assignmentVerify = new Assignment();
		assignmentVerify.setCaForSection(s2, ca1);
		assignmentVerify.setCaForSection(p, ca4);
		assignmentVerify.setCaForSection(q, ca5);
		assignmentVerify.setCaForSection(s, ca1);
		assignmentVerify.setCaForSection(s, ca2);
		assignmentVerify.setCaForSection(s4, ca3);
		assignmentVerify.setCaForSection(s3, ca2);

		//assertEquals(cplexTest.assign().getCasForSection(s2), assignmentVerify.getCasForSection(s2));
		//assertEquals(cplexTest.assign().getCasForSection(s), assignmentVerify.getCasForSection(s));
		//assertEquals(cplexTest.assign().getCasForSection(s4), assignmentVerify.getCasForSection(s4));
		//assertEquals(cplexTest.assign().getCasForSection(p), assignmentVerify.getCasForSection(p));
		//assertEquals(cplexTest.assign().getCasForSection(s3), assignmentVerify.getCasForSection(s3));
		//assertEquals(cplexTest.assign().getCasForSection(q), assignmentVerify.getCasForSection(q));
	}

	@Test
	public void checkHardCoreRequirement() {
		/**
		 * In this test, requirements will be checked one by one; a. mtac; b. schedule
		 * violation; c. skill violation; d. undergrad violation; e. capacity; CHECKED
		 * IN PREVIOUS TEST; f. numOfTA: CHECKED IN PREVIOUS TEST;
		 * 
		 * CISC 210 AAA-Introduction to Systems Programming || Skills Required - C,
		 * Matlab 220 : 20 students; Schedule: Tue 0:00–1:00, Qualified CA will be
		 * Barack Obama; Benjamin Franklin , Bill Clinton 120: 20 students; Schedule:
		 * Wed 0:00–1:00, Qualified CA will be Barack Obama; Benjamin Franklin, Bill
		 * Clinton 130 20 students; Schedule: Thu 0:00–1:00, Qualified CA will be Barack
		 * Obama; Benjamin Franklin, Bill Clinton; Donald Duck, 100 4: 40 students;
		 * schedule: Mon 0:00–1:00, NumofTA 2 Qualified CA will be Barack Obama;
		 * Benjamin Franklin , Bill Clinton
		 * ----------------------------------------------------------------------------------------------------
		 * CISC 275 BBB-Introduction to Software Engineering || Skills Required - JAVA
		 * Section Information (Term 2191): 210, 33 of 40, Tue 9:30–10:45 Qualified CA
		 * will be Bill Clinton, Denzel Washiton 220, 38 of 40, Tue 11:00–12:15; Thu
		 * 11:00–12:15, Qualified CA will be Bill Clinton, Denzel Washition
		 * 
		 * CISC 304 Logic and Programming || Skills Required - 604 Section Information
		 * (Term 2191): 310, 35 of 35, Tue 11:00–12:15; Thu 11:00–12:15, SHL120,
		 * Carberry Qualified CA will be: Donald Duck,
		 * 
		 * Course 4: Section 410 will be only valid for Lucky guy
		 * 
		 * Course 5 and course 6: Section 610 and section 510 only Washington, Denzel
		 * and Girl Knows have the skills But 610 is undergrad course; 510 is graduate
		 * level course; So 610 only for Girl knows; and 510 only for Denzel;
		 * 
		 * 
		 * One more TA dummy dummy, who is not qualified for any of these course.
		 */
		System.out.println("--------------------------------------");
		System.out.println("------------TEST3------------");
		// Create a Course Assistant Pool object
		CourseAssistant ca1 = new CourseAssistant(111);
		CourseAssistant ca2 = new CourseAssistant(222);
		CourseAssistant ca3 = new CourseAssistant(333);
		CourseAssistant ca4 = new CourseAssistant(444);
		CourseAssistant ca5 = new CourseAssistant(555);
		CourseAssistant ca6 = new CourseAssistant(666);
		CourseAssistant ca7 = new CourseAssistant(777);
		CourseAssistant ca8 = new CourseAssistant(888);
		// CourseAssistant ca9 = new CourseAssistant(999);

		////////////////// CA 1 //////////////////////////////////////
		ca1.setFirstName("Barack");
		ca1.setLastName("Obama");
		ca1.setEmailAddress("yeswecan@udel.edu");
		SkillSet skillSet1 = new SkillSet();
		skillSet1.addSkill(new Skill("SQL"));
		skillSet1.addSkill(new Skill("Swift"));
		skillSet1.addSkill(new Skill("Matlab"));
		skillSet1.addSkill(new Skill("Bash"));
		skillSet1.addSkill(new Skill(".NET"));
		skillSet1.addSkill(new Skill("C"));
		ca1.setPossessedSkillset(skillSet1);

		// Create WTPS for CourseAssisstant1
		Collection<TimeInterval> cti2 = new ArrayList<TimeInterval>();
		TimeInterval ti1 = new TimeInterval(DayOfWeek.TUESDAY, 14, 0, 75);
		TimeInterval ti2 = new TimeInterval(DayOfWeek.THURSDAY, 14, 0, 75);
		TimeInterval ti3 = new TimeInterval(DayOfWeek.FRIDAY, 11, 0, 75);
		cti2.add(ti1);
		cti2.add(ti2);
		cti2.add(ti3);
		WeeklySchedule w1 = new WeeklySchedule(cti2);
		ca1.setWtps(w1);
		ca1.setGraduateStudent(true);
		////////////////// CA 2 //////////////////////////////////////
		// set First Name, Last Name
		// Benjamin know java, but schedules is not good for CISC 275 BBB-Introduction
		////////////////// to Software Engineering
		ca2.setFirstName("Benjamin");
		ca2.setLastName("Franklin");
		ca2.setEmailAddress("bfrank@udel.edu");
		SkillSet skillSet2 = new SkillSet();
		skillSet2.addSkill(new Skill("Matlab"));
		skillSet2.addSkill(new Skill("C"));
		skillSet2.addSkill(new Skill("ASP.NET"));
		skillSet2.addSkill(new Skill("JAVA"));
		ca2.setPossessedSkillset(skillSet2);

		// Create WTPS for CourseAssisstant2
		Collection<TimeInterval> cta2 = new ArrayList<TimeInterval>();
		TimeInterval tcnn1 = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval tcnn2 = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		TimeInterval tcnn3 = new TimeInterval(DayOfWeek.TUESDAY, 10, 52, 75);

		cta2.add(tcnn1);
		cta2.add(tcnn2);
		cta2.add(tcnn3);
		WeeklySchedule w2 = new WeeklySchedule(cta2);
		ca2.setWtps(w2);
		ca2.setGraduateStudent(true);
		////////////////// CA 3 //////////////////////////////////////
		// set First Name, Last Name
		ca3.setFirstName("Bill");
		ca3.setLastName("Clinton");
		ca3.setEmailAddress("billclinton@udel.edu");
		SkillSet skillSet3 = new SkillSet();
		skillSet3.addSkill(new Skill("Java"));
		skillSet3.addSkill(new Skill("C"));
		skillSet3.addSkill(new Skill("Matlab"));

		ca3.setPossessedSkillset(skillSet3);

		// Create WTPS for CourseAssisstant3
		Collection<TimeInterval> ctb2 = new ArrayList<TimeInterval>();
		TimeInterval tb1 = new TimeInterval(DayOfWeek.FRIDAY, 15, 30, 75);

		ctb2.add(tb1);

		WeeklySchedule x2 = new WeeklySchedule(ctb2);
		ca3.setWtps(x2);
		ca3.setGraduateStudent(true);
		////////////////// CA 4 //////////////////////////////////////
		// set First Name, Last Name
		ca4.setFirstName("Denzel");
		ca4.setLastName("Washington");
		ca4.setEmailAddress("trainingday@udel.edu");
		SkillSet skillSet4 = new SkillSet();
		skillSet4.addSkill(new Skill("Java"));
		skillSet4.addSkill(new Skill("Alloy"));
		skillSet4.addSkill(new Skill("only"));
		ca4.setPossessedSkillset(skillSet4);

		// Create WTPS for CourseAssisstant4
		Collection<TimeInterval> ctc2 = new ArrayList<TimeInterval>();

		TimeInterval ctt = new TimeInterval(DayOfWeek.FRIDAY, 11, 0, 75);

		ctc2.add(ctt);
		WeeklySchedule v2 = new WeeklySchedule(ctc2);
		ca4.setWtps(v2);
		ca4.setGraduateStudent(true);
		////////////////// CA 5 //////////////////////////////////////
		// set First Name, Last Name
		ca5.setFirstName("Donald");
		ca5.setLastName("Duck");
		ca5.setEmailAddress("dduck@udel.edu");
		SkillSet skillSet5 = new SkillSet();
		skillSet5.addSkill(new Skill("Python"));
		skillSet5.addSkill(new Skill("PHP"));
		skillSet5.addSkill(new Skill("Matalb"));
		skillSet5.addSkill(new Skill("C"));

		skillSet5.addSkill(new Skill("604"));
		ca5.setPossessedSkillset(skillSet5);

		// Create WTPS for CourseAssisstant5
		Collection<TimeInterval> cxc2 = new ArrayList<TimeInterval>();

		TimeInterval zc9 = new TimeInterval(DayOfWeek.FRIDAY, 8, 40, 75);
		TimeInterval zc10 = new TimeInterval(DayOfWeek.WEDNESDAY, 00, 00, 60);
		TimeInterval zc11 = new TimeInterval(DayOfWeek.MONDAY, 00, 00, 60);
		TimeInterval zc12 = new TimeInterval(DayOfWeek.TUESDAY, 00, 00, 60);

		cxc2.add(zc9);
		cxc2.add(zc10);
		cxc2.add(zc11);
		cxc2.add(zc12);

		WeeklySchedule z2 = new WeeklySchedule(cxc2);
		ca5.setWtps(z2);
		ca5.setGraduateStudent(true);

		////////////////// CA 6 //////////////////////////////////////
		// set First Name, Last Name
		ca6.setFirstName("Dummy");
		ca6.setLastName("Dummy");
		ca6.setEmailAddress("dduck@udel.edu");
		SkillSet skillSet6 = new SkillSet();
		skillSet5.addSkill(new Skill("000"));
		ca6.setPossessedSkillset(skillSet6);

		// Create WTPS for CourseAssisstant6
		Collection<TimeInterval> cxc6 = new ArrayList<TimeInterval>();

		TimeInterval zc6 = new TimeInterval(DayOfWeek.FRIDAY, 8, 40, 75);

		cxc6.add(zc6);

		WeeklySchedule z6 = new WeeklySchedule(cxc2);
		ca6.setWtps(z6);
		ca6.setGraduateStudent(true);

		////////////////// CA 7 //////////////////////////////////////
		// set First Name, Last Name
		ca7.setFirstName("Lucky");
		ca7.setLastName("MtacGuy");
		ca7.setEmailAddress("Good1@udel.edu");
		SkillSet skillSet7 = new SkillSet();
		skillSet7.addSkill(new Skill("unique"));
		// Create WTPS for CourseAssisstant6
		Collection<TimeInterval> cxc7 = new ArrayList<TimeInterval>();

		TimeInterval zc7 = new TimeInterval(DayOfWeek.SATURDAY, 0, 0, 10);

		cxc7.add(zc7);
		ca7.setPossessedSkillset(skillSet7);
		ca7.setGraduateStudent(true);

		////////////////// CA 8 //////////////////////////////////////
		// set First Name, Last Name
		ca8.setFirstName("undergrad");
		ca8.setLastName("Girl Knows");
		ca8.setEmailAddress("undergrad@udel.edu");
		SkillSet skillSet8 = new SkillSet();
		skillSet8.addSkill(new Skill("only"));
		ca8.setPossessedSkillset(skillSet8);
		ca8.setGraduateStudent(false);

		CourseAssistantPool cap = new CourseAssistantPool();
		cap.addCourseAssistant(ca1);
		cap.addCourseAssistant(ca2);
		cap.addCourseAssistant(ca3);
		cap.addCourseAssistant(ca4);
		cap.addCourseAssistant(ca5);
		cap.addCourseAssistant(ca6);
		cap.addCourseAssistant(ca7);
		cap.addCourseAssistant(ca8);

		System.out.println("Course Assistant Pool\n");
		Iterable<CourseAssistant> i = cap.getCourseAssistantSet();
		for (CourseAssistant c : i) {
			c.display();
			// System.out.println(c.getWtps().toString());
			// System.out.println(c.toString());
		}

		////////////////// CI 1 //////////////////////////////////////
		ArrayList<CourseInstance> pool1 = new ArrayList<>();
		// Create WTPS for CourseAssisstant5
		Collection<TimeInterval> emw1 = new ArrayList<TimeInterval>();
		TimeInterval er1 = new TimeInterval(DayOfWeek.MONDAY, 00, 00, 60);
		emw1.add(er1);
		pool1.add(new CourseInstance(new Course("CISC", "210", "AAA-Introduction to Systems Programming"), 2191));
		Section s = new Section("Lec", "100", "Silber", 40, 40, "A-A-GOR208", new WeeklySchedule(emw1));
		s.setMtac(true);
		s.setNumOfLA(0);
		s.setNumOfTA(2);
		pool1.get(0).addSection(s);

		Collection<TimeInterval> emw2 = new ArrayList<TimeInterval>();
		TimeInterval er4 = new TimeInterval(DayOfWeek.TUESDAY, 00, 00, 60);
		emw2.add(er4);
		Section s2 = new Section("L", "110", "Silber", 20, 20, "A-B-PRS101", new WeeklySchedule(emw2));
		s2.setMtac(true);
		s2.setNumOfLA(0);
		s2.setNumOfTA(1);
		s.setCorrespondingLab(s2);
		s2.setCorrespondingLecture(s);
		pool1.get(0).addSection(s2);

		Collection<TimeInterval> emw3 = new ArrayList<TimeInterval>();
		TimeInterval er6 = new TimeInterval(DayOfWeek.WEDNESDAY, 00, 00, 60);
		emw3.add(er6);
		Section s3 = new Section("L", "120", "Silber", 20, 20, "A-C-PRS101", new WeeklySchedule(emw3));
		s3.setMtac(true);
		s3.setNumOfLA(0);
		s3.setNumOfTA(1);
		s3.setCorrespondingLecture(s);
		s3.setTaAssigned(false);
		pool1.get(0).addSection(s3);

		TimeInterval er7 = new TimeInterval(DayOfWeek.THURSDAY, 00, 00, 60);
		Collection<TimeInterval> emw4 = new ArrayList<TimeInterval>();
		emw4.add(er7);

		Section s4 = new Section("L", "130", "Silber", 20, 20, "A-D-PRS101", new WeeklySchedule(emw4));
		s4.setMtac(true);
		s4.setNumOfLA(0);
		s4.setNumOfTA(1);
		pool1.get(0).addSection(s4);
		pool1.get(0).getCourse().getSkills().addSkill(new Skill("C"));
		pool1.get(0).getCourse().getSkills().addSkill(new Skill("Matlab"));
		pool1.get(0).setHasLab(true);

		////////////////// CI 2 //////////////////////////////////////
		pool1.add(new CourseInstance(new Course("CISC", "275", "BBB-Introduction to Software Engineering"), 2191));
		Collection<TimeInterval> ss1 = new ArrayList<TimeInterval>();
		TimeInterval e2 = new TimeInterval(DayOfWeek.TUESDAY, 9, 30, 75);
		ss1.add(e2);

		Section p = new Section("Lec", "210", "Harvey", 40, 40, "B-A-GOR117", new WeeklySchedule(ss1));
		p.setMtac(true);
		p.setNumOfLA(0);
		p.setNumOfTA(1);
		p.setMtac(true);

		pool1.get(1).addSection(p);
		pool1.get(1).setHasLab(true);
		pool1.get(1).getCourse().getSkills().addSkill(new Skill("Java"));

		Collection<TimeInterval> tm = new ArrayList<TimeInterval>();
		TimeInterval cc = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval vv = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		tm.add(cc);
		tm.add(vv);
		Section p2 = new Section("Lec", "220", "Harvey", 40, 40, "B-B-GOR117", new WeeklySchedule(tm));
		p2.setMtac(true);
		p2.setNumOfLA(0);
		p2.setNumOfTA(1);
		p2.setTaAssigned(false);
		pool1.get(1).addSection(p2);

		////////////////// CI 3 //////////////////////////////////////
		pool1.add(new CourseInstance(new Course("CISC", "304", "Logic and Programming"), 2191));
		Collection<TimeInterval> hh = new ArrayList<TimeInterval>();
		TimeInterval qw = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval wq = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		hh.add(qw);
		hh.add(wq);
		Section q = new Section("Lec", "310", "Carberry", 35, 35, "SHL120", new WeeklySchedule(hh));
		q.setNumOfLA(0);
		q.setNumOfTA(1);
		q.setMtac(true);

		pool1.get(2).addSection(q);
		pool1.get(2).setHasLab(false);
		pool1.get(2).getCourse().getSkills().addSkill(new Skill("604"));

		////////////////// CI 4 //////////////////////////////////////
		pool1.add(new CourseInstance(new Course("CISC", "699", "NOmATACCourse"), 2191));
		Collection<TimeInterval> cit4 = new ArrayList<TimeInterval>();
		TimeInterval cti41 = new TimeInterval(DayOfWeek.SATURDAY, 0, 0, 10);
		cit4.add(cti41);
		Section ci4s1 = new Section("Lec", "410", "onlyForLuckyguy", 35, 35, "SHL120", new WeeklySchedule(cit4));
		ci4s1.setNumOfLA(0);
		ci4s1.setNumOfTA(1);
		ci4s1.setMtac(false);

		pool1.get(3).addSection(ci4s1);
		pool1.get(3).getCourse().getSkills().addSkill(new Skill("unique"));

		////////////////// CI 5 //////////////////////////////////////
		pool1.add(new CourseInstance(new Course("CISC", "999", "ONLY skill for UnderGilr and Danzel"), 2191));
		Collection<TimeInterval> cit5 = new ArrayList<TimeInterval>();
		TimeInterval cti51 = new TimeInterval(DayOfWeek.SUNDAY, 0, 0, 10);
		cit5.add(cti51);
		Section ci5s1 = new Section("Lec", "510", "onlyForDanzel", 20, 20, "SHL120", new WeeklySchedule(cit5));
		ci5s1.setNumOfLA(0);
		ci5s1.setNumOfTA(1);
		ci5s1.setMtac(true);

		pool1.get(4).addSection(ci5s1);
		pool1.get(4).getCourse().getSkills().addSkill(new Skill("only"));

		////////////////// CI 6 //////////////////////////////////////
		pool1.add(new CourseInstance(new Course("CISC", "499", "ONLY skill for UnderGilr and Danzel"), 2191));
		Collection<TimeInterval> cit6 = new ArrayList<TimeInterval>();
		TimeInterval cti61 = new TimeInterval(DayOfWeek.SUNDAY, 0, 0, 10);
		cit6.add(cti61);
		Section ci6s1 = new Section("Lec", "610", "onlyForUnderGirl", 20, 20, "SHL120", new WeeklySchedule(cit6));
		ci6s1.setNumOfLA(0);
		ci6s1.setNumOfTA(1);
		ci6s1.setMtac(true);

		pool1.get(5).addSection(ci6s1);
		pool1.get(5).getCourse().getSkills().addSkill(new Skill("only"));

		// Create a Course Instance Pool object
		System.out.println("\nCourse Instance Pool\n");
		CourseInstancePool cip = new CourseInstancePool(pool1);
		Iterable<CourseInstance> i2 = cip.getCourseInstanceSet();

		for (CourseInstance c2 : i2) {
			c2.display();
		}

		LPSolver cplexTest = new LPSolver(cap, cip);

		//ArrayList<ArrayList<Double>> testTwo = cplexTest.getScoreTable();

		// System.out.println(testTwo.size());

		//System.out.println("Score Table: ");

		//for (int count = 0; count < testTwo.size(); count++) {
		//	System.out.println(testTwo.get(count).toString());
		//}

		System.out.println("\n");
		System.out.println("\n");
		System.out.println("Test for hard constrain\n" + "\nmtac will be satisfied: Lucky guy"
				+ "\nUndergrad will be satisfied: Dezel and Girl Knows EXAMPLE "

				+ "8 TA; 6 course; \n 10 sections; 110; 120; 130; 140; 210; 220; 230, 310;410; 510;610"
				+ "\nsection 100Lec: requires two TA\n\n");

		cplexTest.assign().displayAll(System.out);
		
//		Assignment assignmentVerify = new Assignment();
//		assignmentVerify.setCaForSection(s2, ca1);
//		assignmentVerify.setCaForSection(p, ca4);
//		assignmentVerify.setCaForSection(q, ca5);
//		assignmentVerify.setCaForSection(s, ca1);
//		assignmentVerify.setCaForSection(s, ca2);
//		assignmentVerify.setCaForSection(s4, ca3);
//		assignmentVerify.setCaForSection(s3, ca2);
//		
//		
//
//		assertEquals(cplexTest.getAssignment().getCasForSection(s2), assignmentVerify.getCasForSection(s2));
//		assertEquals(cplexTest.getAssignment().getCasForSection(s), assignmentVerify.getCasForSection(s));
//		assertEquals(cplexTest.getAssignment().getCasForSection(s4), assignmentVerify.getCasForSection(s4));
//		assertEquals(cplexTest.getAssignment().getCasForSection(p), assignmentVerify.getCasForSection(p));
//		assertEquals(cplexTest.getAssignment().getCasForSection(s3), assignmentVerify.getCasForSection(s3));
//		assertEquals(cplexTest.getAssignment().getCasForSection(q), assignmentVerify.getCasForSection(q));
	}

}
