package edu.udel.cis.taschd.course;

import static org.junit.Assert.assertEquals;

import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;

import edu.udel.cis.taschd.course.CourseInstance;
import edu.udel.cis.taschd.skill.Skill;
import edu.udel.cis.taschd.time.TimeInterval;
import edu.udel.cis.taschd.time.WeeklySchedule;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the {@link CourseInstancePool} class.
 *
 * @author matthew
 */
public class CourseInstancePoolTest {

	private static PrintStream out = System.out;

	private static ArrayList<CourseInstance> pool2 = new ArrayList<>();

	@Before
	public void setUp() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCourseInstancePool() {
		// Pool #1
		ArrayList<CourseInstance> tester1 = new ArrayList<>();
		/*
		 * Course Instance 1
		 */
		// Create WTPS for CourseInstance 1
		Collection<TimeInterval> emw1 = new ArrayList<TimeInterval>();
		TimeInterval er2 = new TimeInterval(DayOfWeek.TUESDAY, 15, 30, 75);
		TimeInterval er3 = new TimeInterval(DayOfWeek.THURSDAY, 15, 30, 75);
		emw1.add(er2);
		emw1.add(er3);
		tester1.add(new CourseInstance(new Course("CISC", "210", "Introduction to Systems Programming"), 2191));
		Section s = new Section("Lec", "010", "Silber", 40, 40, "GOR208", new WeeklySchedule(emw1));
		s.setMtac(true);
		s.setNumOfLA(0);
		s.setNumOfTA(1);
		s.setTaAssigned(false);
		tester1.get(0).addSection(s);

		Collection<TimeInterval> emw2 = new ArrayList<TimeInterval>();
		TimeInterval er4 = new TimeInterval(DayOfWeek.WEDNESDAY, 13, 25, 50);
		emw2.add(er4);
		Section s2 = new Section("L", "020", "Silber", 20, 20, "PRS101", new WeeklySchedule(emw2));
		s2.setMtac(true);
		s2.setNumOfLA(0);
		s2.setNumOfTA(1);
		s2.setTaAssigned(false);
		s.setCorrespondingLab(s2);
		s2.setCorrespondingLecture(s);
		tester1.get(0).addSection(s2);

		Collection<TimeInterval> emw3 = new ArrayList<TimeInterval>();
		TimeInterval er6 = new TimeInterval(DayOfWeek.WEDNESDAY, 14, 30, 50);
		emw3.add(er6);
		Section s3 = new Section("L", "021", "Silber", 20, 20, "PRS101", new WeeklySchedule(emw3));
		s3.setMtac(true);
		s3.setNumOfLA(0);
		s3.setNumOfTA(1);
		s3.setCorrespondingLecture(s);
		s3.setTaAssigned(false);
		tester1.get(0).addSection(s3);
		tester1.get(0).getCourse().getSkills().addSkill(new Skill("C"));
		tester1.get(0).getCourse().getSkills().addSkill(new Skill("C++"));
		tester1.get(0).setHasLab(true);

		/*
		 * Course Instance 2
		 */
		tester1.add(new CourseInstance(new Course("CISC", "275", "Introduction to Software Engineering"), 2191));
		Collection<TimeInterval> ss1 = new ArrayList<TimeInterval>();
		TimeInterval e2 = new TimeInterval(DayOfWeek.TUESDAY, 9, 30, 75);
		TimeInterval e3 = new TimeInterval(DayOfWeek.THURSDAY, 9, 30, 75);
		TimeInterval e4 = new TimeInterval(DayOfWeek.WEDNESDAY, 17, 0, 120);
		ss1.add(e2);
		ss1.add(e3);
		ss1.add(e4);

		Section p = new Section("Lec", "010", "Harvey", 33, 40, "GOR117", new WeeklySchedule(ss1));
		p.setMtac(true);
		p.setNumOfLA(0);
		p.setNumOfTA(1);
		p.setMtac(true);
		p.setTaAssigned(false);

		tester1.get(1).addSection(p);
		tester1.get(1).setHasLab(true);
		tester1.get(1).getCourse().getSkills().addSkill(new Skill("Any"));

		Collection<TimeInterval> tm = new ArrayList<TimeInterval>();
		TimeInterval cc = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval vv = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		TimeInterval bb = new TimeInterval(DayOfWeek.WEDNESDAY, 17, 0, 120);
		tm.add(cc);
		tm.add(vv);
		tm.add(bb);
		Section p2 = new Section("Lec", "011", "Harvey", 38, 40, "GOR117", new WeeklySchedule(tm));
		p2.setMtac(true);
		p2.setNumOfLA(0);
		p2.setNumOfTA(1);
		p2.setTaAssigned(false);
		tester1.get(1).addSection(p2);

		/*
		 * Course Instance 3
		 */
		tester1.add(new CourseInstance(new Course("CISC", "303", "Automata Theory"), 2191));
		Collection<TimeInterval> tt = new ArrayList<TimeInterval>();
		TimeInterval ii = new TimeInterval(DayOfWeek.MONDAY, 10, 10, 50);
		TimeInterval oo = new TimeInterval(DayOfWeek.WEDNESDAY, 10, 10, 50);
		TimeInterval pp = new TimeInterval(DayOfWeek.FRIDAY, 10, 10, 50);
		tt.add(ii);
		tt.add(oo);
		tt.add(pp);
		Section d = new Section("Lec", "010", "Carberry", 43, 45, "ALS318", new WeeklySchedule(tt));
		d.setMtac(true);
		d.setNumOfLA(0);
		d.setNumOfTA(1);
		d.setMtac(true);
		d.setTaAssigned(false);

		tester1.get(2).addSection(d);
		tester1.get(2).setHasLab(false);
		tester1.get(2).getCourse().getSkills().addSkill(new Skill("601"));

		/*
		 * Course Instance 4
		 */
		tester1.add(new CourseInstance(new Course("CISC", "304", "Logic and Programming"), 2191));
		Collection<TimeInterval> hh = new ArrayList<TimeInterval>();
		TimeInterval qw = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval wq = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		hh.add(qw);
		hh.add(wq);
		Section q = new Section("Lec", "010", "Carberry", 35, 35, "SHL120", new WeeklySchedule(hh));
		q.setNumOfLA(0);
		q.setNumOfTA(1);
		q.setMtac(false);
		q.setTaAssigned(false);

		tester1.get(3).addSection(q);
		tester1.get(3).setHasLab(false);
		tester1.get(3).getCourse().getSkills().addSkill(new Skill("604"));

		/*
		 * Course Instance 5
		 */
		tester1.add(new CourseInstance(new Course("CISC", "320", "Introduction to Algorithms"), 2191));
		Collection<TimeInterval> gg = new ArrayList<TimeInterval>();
		TimeInterval gh = new TimeInterval(DayOfWeek.TUESDAY, 12, 30, 75);
		TimeInterval hg = new TimeInterval(DayOfWeek.THURSDAY, 12, 30, 75);
		gg.add(gh);
		gg.add(hg);
		Section h = new Section("Lec", "010", "Bart", 43, 45, "GOR208", new WeeklySchedule(gg));
		h.setMtac(true);
		h.setNumOfLA(0);
		h.setNumOfTA(1);
		h.setTaAssigned(false);

		tester1.get(4).addSection(q);
		tester1.get(4).setHasLab(false);
		tester1.get(4).getCourse().getSkills().addSkill(new Skill("621"));

		out.println(tester1.toString());
		assertEquals(tester1.toString(),"[CISC 210 - 020L 021L 010Lec, CISC 275 - 010Lec 011Lec, CISC 303 - 010Lec, CISC 304 - 010Lec, CISC 320 - 010Lec]");

		// Pool #2
		/*
		 * Course Instance 1
		 */
		pool2.add(new CourseInstance(new Course("CISC", "437", "Database Systems"), 2191));
		Collection<TimeInterval> asd = new ArrayList<TimeInterval>();
		TimeInterval sd = new TimeInterval(DayOfWeek.TUESDAY, 16, 0, 75);
		TimeInterval ds = new TimeInterval(DayOfWeek.THURSDAY, 16, 0, 75);
		asd.add(sd);
		asd.add(ds);
		Section aa = new Section("Lec", "010", "Gibbons", 35, 35, "GOR102", new WeeklySchedule(asd));
		aa.setMtac(true);
		aa.setNumOfLA(0);
		aa.setNumOfTA(1);
		aa.setTaAssigned(false);

		pool2.get(0).addSection(aa);
		pool2.get(0).setHasLab(false);
		pool2.get(0).getCourse().getSkills().addSkill(new Skill("637"));
		pool2.get(0).getCourse().getSkills().addSkill(new Skill("SQL"));

		/*
		 * Course Instance 2
		 */
		pool2.add(new CourseInstance(new Course("CISC", "442", "Introduction to Computer Vision"), 2191));
		Collection<TimeInterval> qew = new ArrayList<TimeInterval>();
		TimeInterval jhbb = new TimeInterval(DayOfWeek.TUESDAY, 15, 30, 75);
		TimeInterval jhb = new TimeInterval(DayOfWeek.THURSDAY, 15, 30, 75);
		qew.add(jhbb);
		qew.add(jhb);
		Section amu = new Section("Lec", "010", "Kambhamettu", 35, 35, "MEM110", new WeeklySchedule(qew));
		amu.setMtac(false);
		amu.setNumOfLA(0);
		amu.setNumOfTA(1);
		amu.setTaAssigned(false);

		pool2.get(1).addSection(amu);
		pool2.get(1).setHasLab(false);
		pool2.get(1).getCourse().getSkills().addSkill(new Skill("Python"));
		pool2.get(1).getCourse().getSkills().addSkill(new Skill("MatLab"));

		/*
		 * Course Instance 3
		 */
		pool2.add(new CourseInstance(new Course("CISC", "450", "Computer Networks I"), 2191));
		Collection<TimeInterval> r4e = new ArrayList<TimeInterval>();
		TimeInterval w22 = new TimeInterval(DayOfWeek.MONDAY, 15, 35, 75);
		TimeInterval e32 = new TimeInterval(DayOfWeek.WEDNESDAY, 15, 35, 75);
		r4e.add(w22);
		r4e.add(e32);
		Section q1 = new Section("Lec", "010", "Sethi", 35, 35, "SHL100", new WeeklySchedule(r4e));
		q1.setMtac(false);
		q1.setNumOfLA(0);
		q1.setNumOfTA(1);
		q1.setTaAssigned(false);

		pool2.get(2).addSection(q1);
		pool2.get(2).setHasLab(false);
		pool2.get(2).getCourse().getSkills().addSkill(new Skill("650"));
		
		out.println(pool2.toString());
		assertEquals(pool2.toString(), "[CISC 437 - 010Lec, CISC 442 - 010Lec, CISC 450 - 010Lec]");
	}

	@Test
	public void testGetSize() {
		ArrayList<CourseInstance> tester2 = new ArrayList<>();
		// Pool #2
		/*
		 * Course Instance 1
		 */
		tester2.add(new CourseInstance(new Course("CISC", "437", "Database Systems"), 2191));
		Collection<TimeInterval> asd = new ArrayList<TimeInterval>();
		TimeInterval sd = new TimeInterval(DayOfWeek.TUESDAY, 16, 0, 75);
		TimeInterval ds = new TimeInterval(DayOfWeek.THURSDAY, 16, 0, 75);
		asd.add(sd);
		asd.add(ds);
		Section aa = new Section("Lec", "010", "Gibbons", 35, 35, "GOR102", new WeeklySchedule(asd));
		aa.setMtac(true);
		aa.setNumOfLA(0);
		aa.setNumOfTA(1);
		aa.setTaAssigned(false);

		tester2.get(0).addSection(aa);
		tester2.get(0).setHasLab(false);
		tester2.get(0).getCourse().getSkills().addSkill(new Skill("637"));
		tester2.get(0).getCourse().getSkills().addSkill(new Skill("SQL"));

		/*
		 * Course Instance 2
		 */
		tester2.add(new CourseInstance(new Course("CISC", "442", "Introduction to Computer Vision"), 2191));
		Collection<TimeInterval> qew = new ArrayList<TimeInterval>();
		TimeInterval jhbb = new TimeInterval(DayOfWeek.TUESDAY, 15, 30, 75);
		TimeInterval jhb = new TimeInterval(DayOfWeek.THURSDAY, 15, 30, 75);
		qew.add(jhbb);
		qew.add(jhb);
		Section amu = new Section("Lec", "010", "Kambhamettu", 35, 35, "MEM110", new WeeklySchedule(qew));
		amu.setMtac(false);
		amu.setNumOfLA(0);
		amu.setNumOfTA(1);
		amu.setTaAssigned(false);

		tester2.get(1).addSection(amu);
		tester2.get(1).setHasLab(false);
		tester2.get(1).getCourse().getSkills().addSkill(new Skill("Python"));
		tester2.get(1).getCourse().getSkills().addSkill(new Skill("MatLab"));

		/*
		 * Course Instance 3
		 */
		tester2.add(new CourseInstance(new Course("CISC", "450", "Computer Networks I"), 2191));
		Collection<TimeInterval> r4e = new ArrayList<TimeInterval>();
		TimeInterval w22 = new TimeInterval(DayOfWeek.MONDAY, 15, 35, 75);
		TimeInterval e32 = new TimeInterval(DayOfWeek.WEDNESDAY, 15, 35, 75);
		r4e.add(w22);
		r4e.add(e32);
		Section q1 = new Section("Lec", "010", "Sethi", 35, 35, "SHL100", new WeeklySchedule(r4e));
		q1.setMtac(false);
		q1.setNumOfLA(0);
		q1.setNumOfTA(1);
		q1.setTaAssigned(false);

		tester2.get(2).addSection(q1);
		tester2.get(2).setHasLab(false);
		tester2.get(2).getCourse().getSkills().addSkill(new Skill("650"));

		assertEquals(tester2.size(), 3);
		out.println(tester2.size());
	}

	@Test
	public void testFindCourseInstanceSectionType() {
		ArrayList<CourseInstance> tester3 = new ArrayList<>();
		// Pool #2
		/*
		 * Course Instance 1
		 */
		tester3.add(new CourseInstance(new Course("CISC", "437", "Database Systems"), 2191));
		Collection<TimeInterval> asd = new ArrayList<TimeInterval>();
		TimeInterval sd = new TimeInterval(DayOfWeek.TUESDAY, 16, 0, 75);
		TimeInterval ds = new TimeInterval(DayOfWeek.THURSDAY, 16, 0, 75);
		asd.add(sd);
		asd.add(ds);
		Section aa = new Section("Lec", "010", "Gibbons", 35, 35, "GOR102", new WeeklySchedule(asd));
		aa.setMtac(true);
		aa.setNumOfLA(0);
		aa.setNumOfTA(1);
		aa.setTaAssigned(false);

		tester3.get(0).addSection(aa);
		tester3.get(0).setHasLab(false);
		tester3.get(0).getCourse().getSkills().addSkill(new Skill("637"));
		tester3.get(0).getCourse().getSkills().addSkill(new Skill("SQL"));

		/*
		 * Course Instance 2
		 */
		tester3.add(new CourseInstance(new Course("CISC", "442", "Introduction to Computer Vision"), 2191));
		Collection<TimeInterval> qew = new ArrayList<TimeInterval>();
		TimeInterval jhbb = new TimeInterval(DayOfWeek.TUESDAY, 15, 30, 75);
		TimeInterval jhb = new TimeInterval(DayOfWeek.THURSDAY, 15, 30, 75);
		qew.add(jhbb);
		qew.add(jhb);
		Section amu = new Section("Lec", "010", "Kambhamettu", 35, 35, "MEM110", new WeeklySchedule(qew));
		amu.setMtac(false);
		amu.setNumOfLA(0);
		amu.setNumOfTA(1);
		amu.setTaAssigned(false);

		tester3.get(1).addSection(amu);
		tester3.get(1).setHasLab(false);
		tester3.get(1).getCourse().getSkills().addSkill(new Skill("Python"));
		tester3.get(1).getCourse().getSkills().addSkill(new Skill("MatLab"));

		/*
		 * Course Instance 3
		 */
		tester3.add(new CourseInstance(new Course("CISC", "450", "Computer Networks I"), 2191));
		Collection<TimeInterval> r4e = new ArrayList<TimeInterval>();
		TimeInterval w22 = new TimeInterval(DayOfWeek.MONDAY, 15, 35, 75);
		TimeInterval e32 = new TimeInterval(DayOfWeek.WEDNESDAY, 15, 35, 75);
		r4e.add(w22);
		r4e.add(e32);
		Section q1 = new Section("Lec", "010", "Sethi", 35, 35, "SHL100", new WeeklySchedule(r4e));
		q1.setMtac(false);
		q1.setNumOfLA(0);
		q1.setNumOfTA(1);
		q1.setTaAssigned(false);

		tester3.get(2).addSection(q1);
		tester3.get(2).setHasLab(false);
		tester3.get(2).getCourse().getSkills().addSkill(new Skill("650"));
		CourseInstancePool cip1 = new CourseInstancePool(tester3);
		out.println(tester3);
		assertEquals(cip1.findCourseInstanceBySectionType("L").toString(), "[]");
		assertEquals(cip1.findCourseInstanceBySectionType("Lec").toString(), "[CISC 437 - 010Lec, CISC 442 - 010Lec, CISC 450 - 010Lec]");
		
	}

	@Test
	public void testFindCourseInstanceByInstructor() {
		ArrayList<CourseInstance> tester4 = new ArrayList<>();
		tester4.add(new CourseInstance(new Course("CISC", "675", "Software Engineering"), 2191));
		tester4.add(new CourseInstance(new Course("CISC", "642", "Intro to Computer Vision"), 2198));
		tester4.add(new CourseInstance(new Course("CISC", "681", "Artificial Intelligence"), 2191));
		tester4.get(0).addSection(new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule()));
		tester4.get(0).addSection(new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule()));
		tester4.get(1).addSection(new Section("", "010", "Kambhamettu,Chandra", 19, 20, "MEM110", new WeeklySchedule()));

		CourseInstancePool test1 = new CourseInstancePool(tester4);
		 out.println(test1.findCourseInstanceByInstructor("Siegel,Stephen"));
		 out.println(test1.findCourseInstanceByInstructor("Kambhamettu,Chandra"));
		 assertEquals(test1.findCourseInstanceByInstructor("Kambhamettu,Chandra").toString(),
		 "[CISC 642 - 010]");
	}

}
