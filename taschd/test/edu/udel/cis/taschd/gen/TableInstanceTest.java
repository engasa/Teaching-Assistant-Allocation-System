package edu.udel.cis.taschd.gen;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import edu.udel.cis.taschd.ca.CourseAssistant;
import edu.udel.cis.taschd.course.Course;
import edu.udel.cis.taschd.course.CourseInstance;
import edu.udel.cis.taschd.course.Section;
import edu.udel.cis.taschd.skill.Skill;
import edu.udel.cis.taschd.skill.SkillSet;
import edu.udel.cis.taschd.time.TimeInterval;
import edu.udel.cis.taschd.time.WeeklySchedule;
import static org.junit.Assert.assertEquals;


/**
 * Tests of the {@link TableInstanceTest} class.
 * 
 * @author Yi Liu
 */
public class TableInstanceTest {
	
	@Test
	public void test() {
		CourseAssistant ca1 = new CourseAssistant(111);
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
		
		
		ArrayList<CourseInstance> pool1 = new ArrayList<>();
		pool1.add(new CourseInstance(new Course("CISC", "499", "ONLY skill for UnderGilr and Danzel"), 2191));
		Collection<TimeInterval> cit6 = new ArrayList<TimeInterval>();
		TimeInterval cti61 = new TimeInterval(DayOfWeek.SUNDAY, 0, 0, 10);
		cit6.add(cti61);
		Section ci6s1 = new Section("Lec", "610", "onlyForUnderGirl", 20, 20, "SHL120", new WeeklySchedule(cit6));
		ci6s1.setNumOfLA(0);
		ci6s1.setNumOfTA(1);
		ci6s1.setMtac(true);

		pool1.get(0).addSection(ci6s1);
		pool1.get(0).getCourse().getSkills().addSkill(new Skill("only"));

		TableInstance table1 = new TableInstance(2,1, ca1, ci6s1, pool1.get(0), 1.0);
	
		assertEquals(table1.getCol(),1);
		assertEquals(table1.getRow(),2);
		assertEquals(table1.getFlag()==0.0, true);
		table1.setFlag(1.0);
		assertEquals(table1.getFlag()==1.0, true);
		assertEquals(table1.getScore() == 1.0, true);
		table1.setScore(-1.0);
		assertEquals(table1.getScore() == -1.0, true);
		assertEquals(table1.getSec(), ci6s1);
		assertEquals(table1.getCourse(), pool1.get(0));
		
	}

}
