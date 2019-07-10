/**
 * 
 */
package edu.udel.cis.taschd.db;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

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
 * Tests for Database Class
 * 
 * @author sumeetgupta
 *
 */
public class DatabaseTest {

	private Database obj1 = new Database();

	private Course c1 = new Course("CISC", "675", "Advanced Software Engineering");
	private Course c2 = new Course("CISC", "375", "Software Engineering");
	private Course c3 = new Course("CISC", "642", "Introduction to Computer Vision");
	private Course c4 = new Course("CISC", "682", "Artifical Intelligence");

	private CourseInstance ci1 = new CourseInstance(c1, 2188);
	private CourseInstance ci2 = new CourseInstance(c2, 2188);
	private CourseInstance ci3 = new CourseInstance(c3, 2188);

	Collection<TimeInterval> cti1 = new ArrayList<TimeInterval>();
	TimeInterval ti1 = new TimeInterval(DayOfWeek.TUESDAY, 11, 15, 75);
	TimeInterval ti2 = new TimeInterval(DayOfWeek.THURSDAY, 11, 15, 75);
	Collection<TimeInterval> cti2 = new ArrayList<TimeInterval>();
	TimeInterval ti3 = new TimeInterval(DayOfWeek.WEDNESDAY, 16, 40, 75);

	private CourseAssistant ca1 = new CourseAssistant(1231234);
	private CourseAssistant ca2 = new CourseAssistant(222);
	private CourseAssistant ca3 = new CourseAssistant(333);
	private String directory = System.getProperty("user.dir");

	private CourseInstancePool cip = new CourseInstancePool();
	private CourseAssistantPool cap = new CourseAssistantPool();

	@Before
	public void setUp() throws Exception {
		taschdSetup();
		ci1.setHasLab(true);
		cti1.add(ti1);
		cti1.add(ti2);
		cti2.add(ti3);
		ci1.addSection(new Section("", "010", "Siegel,Stephen", 11, 20, "MDH216", new WeeklySchedule(cti1)));
		ci1.addSection(new Section("L", "020", "Siegel,Stephen", 11, 35, "BRL205", new WeeklySchedule(cti2)));

		ci2.setHasLab(true);
		cti1.add(ti1);
		cti1.add(ti2);
		cti2.add(ti3);
		ci1.addSection(new Section("", "010", "Siegel,Stephen", 9, 25, "MDH206", new WeeklySchedule(cti2)));
		ci1.addSection(new Section("L", "020", "Siegel,Stephen", 10, 45, "BRL215", new WeeklySchedule(cti1)));

		ci3.setHasLab(false);
		cti2.add(ti3);
		ci1.addSection(new Section("", "010", "Siegel,Stephen", 11, 25, "MDH216", new WeeklySchedule(cti2)));

		SkillSet skillSet1 = new SkillSet(new HashSet<Skill>());
		skillSet1.addSkill(new Skill("Java"));
		skillSet1.addSkill(new Skill("Python"));
		skillSet1.addSkill(new Skill("Javascript"));

		SkillSet skillSet5 = new SkillSet(new HashSet<Skill>());
		skillSet5.addSkill(new Skill("Java"));
		skillSet5.addSkill(new Skill("Python"));
		skillSet5.addSkill(new Skill("Javascript"));
		c1.setSkills(skillSet5);

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

		WeeklySchedule w1 = new WeeklySchedule(cti1);

		Set<CourseInstance> caOneCourseEnrolled = new HashSet<CourseInstance>();
		caOneCourseEnrolled.add(ci1);
		caOneCourseEnrolled.add(ci2);

		ca1.setFirstName("Michael");
		ca1.setLastName("Oyefusi");
		ca1.setEmailAddress("m@udel.edu");
		ca1.setPossessedSkillset(skillSet1);
		ca1.setWtps(w1);
		ca1.setCourseEnrolled(caOneCourseEnrolled);
		ca1.setGraduateStudent(true);

		ca2.setFirstName("Barack");
		ca2.setLastName("Obama");
		ca2.setEmailAddress("yeswecan@udel.edu");
		SkillSet skillSet9 = new SkillSet();
		skillSet1.addSkill(new Skill("SQL"));
		skillSet1.addSkill(new Skill("Swift"));
		skillSet1.addSkill(new Skill("Matlab"));
		skillSet1.addSkill(new Skill("Bash"));
		skillSet1.addSkill(new Skill(".NET"));
		skillSet1.addSkill(new Skill("C"));
		ca2.setPossessedSkillset(skillSet9);
		Collection<TimeInterval> cti2 = new ArrayList<TimeInterval>();
		TimeInterval ti1 = new TimeInterval(DayOfWeek.TUESDAY, 14, 0, 75);
		TimeInterval ti2 = new TimeInterval(DayOfWeek.THURSDAY, 14, 0, 75);
		TimeInterval ti3 = new TimeInterval(DayOfWeek.FRIDAY, 11, 0, 75);
		cti2.add(ti1);
		cti2.add(ti2);
		cti2.add(ti3);
		WeeklySchedule w5 = new WeeklySchedule(cti2);
		ca2.setWtps(w5);
		ca2.setGraduateStudent(true);

		ca3.setFirstName("Benjamin");
		ca3.setLastName("Franklin");
		ca3.setEmailAddress("bfrank@udel.edu");
		SkillSet skillSet8 = new SkillSet();
		skillSet8.addSkill(new Skill("Matlab"));
		skillSet8.addSkill(new Skill("C"));
		skillSet8.addSkill(new Skill("ASP.NET"));
		skillSet8.addSkill(new Skill("JAVA"));
		ca3.setPossessedSkillset(skillSet8);
		Collection<TimeInterval> cti5 = new ArrayList<TimeInterval>();
		TimeInterval tcnn1 = new TimeInterval(DayOfWeek.TUESDAY, 11, 0, 75);
		TimeInterval tcnn2 = new TimeInterval(DayOfWeek.THURSDAY, 11, 0, 75);
		TimeInterval tcnn3 = new TimeInterval(DayOfWeek.TUESDAY, 10, 52, 75);
		cti5.add(tcnn1);
		cti5.add(tcnn2);
		cti5.add(tcnn3);
		WeeklySchedule w6 = new WeeklySchedule(cti5);
		ca3.setWtps(w6);
		ca3.setGraduateStudent(false);

		cip.addCourseInstancetoPool(ci2);
		cip.addCourseInstancetoPool(ci3);
		cip.addCourseInstancetoPool(ci1);

		cap.addCourseAssistant(ca1);
		cap.addCourseAssistant(ca2);
		cap.addCourseAssistant(ca3);
	}

	/**
	 * does taschd directory setup for testing purposes
	 * @author sumeetgupta
	 */
	public void taschdSetup() {

		File rootDir = new File(directory);
		// file name taschd_dir in current directory
		File taschdDirectory = new File(rootDir, "taschd_dir");
		File terms = new File(taschdDirectory, "terms");
		File termDir = new File(terms, "2188");

		try {
			// folder name courses in taschd_dir
			createDirectory(new File(taschdDirectory, "courses"));
			// folder name ca_pool in taschd_dir
			createDirectory(new File(taschdDirectory, "ca_pool"));
			// folder name terms in taschd_dir
			createDirectory(new File(taschdDirectory, "terms"));
			// file name courses in taschd_dir/terms/{term}
			createDirectory(new File(termDir, "courses"));
			// file name assistants in taschd_dir/terms/{term}
			createDirectory(new File(termDir, "assistants"));
			// file name assignments in taschd_dir/terms/{term}
			createDirectory(new File(termDir, "assignments"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	/**
	 * creates directory specified by file
	 * @author sumeetgupta
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static File createDirectory(File file) throws IOException {
		// check if directory exists
		if (file.exists()) {
			return file;
		}
		// create directory if it doesn't already exist
		if (file.mkdirs()) {
			return file;
		}
		throw new IOException("Failed to create directory '" + file.getAbsolutePath() + "' for an unknown reason.");
	}

	/**
	 * checks if dynamic course directory has fileToStore
	 * @author sumeetgupta
	 * @param term
	 * @param fileToStore
	 * @return
	 */
	public boolean checkDyanmicCourseDirectory(int term, String fileToStore) {

		boolean success = false;
		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, "taschd_dir");
		File termsDirectory = new File(taschdDirectory, "terms");
		File termNumberDirectory = new File(termsDirectory, String.valueOf(term));
		File termNumberCourseDirectory = new File(termNumberDirectory, "courses");
		String[] termNumberCourseFolder = termNumberCourseDirectory.list();

		if (termNumberCourseFolder != null) {
			for (int i = 0; i < termNumberCourseFolder.length; i++) {
				if (termNumberCourseFolder[i].equalsIgnoreCase(fileToStore)) {
					success = true;
					break;
				}
			}
		}
		return success;
	}

	/**
	 * checks if static course directory has fileToStore
	 * @author sumeetgupta
	 * @param term
	 * @param fileToStore
	 * @return
	 */
	public boolean checkStaticCourseDirectory(int term, String fileToStore) {

		boolean success = false;
		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, "taschd_dir");
		File courseDirectory = new File(taschdDirectory, "courses");
		String[] coursesFolder = courseDirectory.list();

		if (coursesFolder != null) {
			for (int i = 0; i < coursesFolder.length; i++) {
				if (coursesFolder[i].equalsIgnoreCase(fileToStore)) {
					success = true;
					break;
				}
			}
		}
		return success;
	}

	/**
	 * checks if dynamic assistants directory has fileToStore
	 * @author sumeetgupta
	 * @param term
	 * @param fileToStore
	 * @return
	 */
	public boolean checkDyanmicAssistantsDirectory(int term, String fileToStore) {

		boolean success = false;
		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, "taschd_dir");
		File termsDirectory = new File(taschdDirectory, "terms");
		File termNumberDirectory = new File(termsDirectory, String.valueOf(term));
		File termNumberAssistantsDirectory = new File(termNumberDirectory, "assistants");
		String[] termNumberAssistantsFolder = termNumberAssistantsDirectory.list();

		if (termNumberAssistantsFolder != null) {
			for (int i = 0; i < termNumberAssistantsFolder.length; i++) {
				if (termNumberAssistantsFolder[i].equalsIgnoreCase(fileToStore)) {
					success = true;
					break;
				}
			}
		}
		return success;
	}

	/**
	 * checks if ca_pool directory has fileToStore
	 * @author sumeetgupta
	 * @param fileToStore
	 * @return
	 */
	public boolean checkStaticCAPoolDirectory(String fileToStore) {

		boolean success = false;
		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, "taschd_dir");
		File caPoolDirectory = new File(taschdDirectory, "ca_pool");
		String[] caPoolFolder = caPoolDirectory.list();

		if (caPoolFolder != null) {
			for (int i = 0; i < caPoolFolder.length; i++) {
				if (caPoolFolder[i].equalsIgnoreCase(fileToStore)) {
					success = true;
					break;
				}
			}
		}
		return success;
	}

	/**
	 * tests if course is stored to static course directory. Checks for file existence.
	 * @author sumeetgupta
	 * @throws IOException
	 */
	@Test
	public void testStoreCourseStatic() throws IOException {
		obj1.store(ci3);
		if (checkStaticCourseDirectory(2188, "CISC642.json")) {
			System.out.println("Successful static course data storage");
		}

	}

	/**
	 * tests if course is stored to dynamic course directory. Checks for file existence.
	 * @author sumeetgupta
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	public void testStoreCourseDynamic() throws IOException, ParseException {
		obj1.storeDynamic(ci1);
		if (checkDyanmicCourseDirectory(2188, "CISC375.json")) {
			System.out.println("Successful dyanmic course data storage");
		}
	}

	@Test
	public void testRetrieveCourseByCode() throws IOException, ParseException {
		//assertEquals(ci1, obj1.retrieveCourseByCode("CISC", "675", 2188));
		CourseInstance cRetrieve = obj1.retrieveCourseByCode("CISC", "675", 2188);
		assertEquals(ci1.getCourse().getCourseCode(), cRetrieve.getCourse().getCourseCode());
		assertEquals(ci1.getCourse().getPrefix(), cRetrieve.getCourse().getPrefix());
	}

	@Test
	public void testRetrieveCAByID() throws IOException, NullPointerException, ParseException {
		assertEquals(ca1, obj1.retrieveCAById(1231234, 2188));
	}

	/**
	 * tests if CA is stored to ca_pool directory. Checks for file existence.
	 * @author sumeetgupta
	 * @throws IOException
	 */
	@Test
	public void testStoreCAStatic() throws IOException {
		obj1.store(ca1);
		if (checkStaticCAPoolDirectory("SID1231234.json")) {
			System.out.println("Successful static CA Data storage");
		}

	}

	/**
	 * tests if CA is stored to dynamic assistants directory. Checks for file existence.
	 * @author sumeetgupta
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	public void testStoreCADynamic() throws IOException, ParseException {
		obj1.storeDynamic(ca1, 2188);
		if (checkDyanmicAssistantsDirectory(2188, "SID1231234.json")) {
			System.out.println("Successful dynamic CA Data storage");
		}
	}

	/**
	 * checks if prefix and course code retrieved match with original object's prefix and course code.
	 * @author sumeetgupta
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	public void testRetrieveCourse() throws IOException, ParseException {
		Course cRetrieve = obj1.retrieveCourse("CISC", "642");
		assertEquals(c3.getCourseCode(), cRetrieve.getCourseCode());
		assertEquals(c3.getPrefix(), cRetrieve.getPrefix());
	}

	/**
	 * checks if CA ID retrieved matches with original CA's ID.
	 * @author sumeetgupta
	 * @throws IOException
	 * @throws NullPointerException
	 * @throws ParseException
	 */
	@Test
	public void testRetrieveCourseAssistant() throws IOException, NullPointerException, ParseException {
		obj1.store(ca1);
		CourseAssistant caRetrieve = obj1.retrieveCourseAssistant(1231234);
		if(ca1.getId() == caRetrieve.getId()){
			System.out.println("Correct CA retrieved");
		}
	}

	/**
	 * checks if prefix and course code retrieved match with original pool's every course's prefix and course code.
	 * @author sumeetgupta
	 * @throws IOException
	 * @throws ParseException
	 */
	@Test
	public void testRetrieveCourseInstancePool() throws IOException, ParseException {
		obj1.storeDynamic(ci1);
		obj1.storeDynamic(ci2);
		obj1.storeDynamic(ci3);
		CourseInstancePool cip5 = obj1.retrieveCourseInstancePool(2188);
		Iterator<CourseInstance> ici1 = cip5.getCourseInstanceSet().iterator();
		Iterator<CourseInstance> ici2 = cip.getCourseInstanceSet().iterator();
		int counter = 0;
		while (ici1.hasNext()) {
			CourseInstance c8 = ici1.next();
			CourseInstance c9 = ici2.next();
			if (c8.getCourse().getPrefix().compareToIgnoreCase(c9.getCourse().getPrefix()) == 0) {
				if(c8.getCourse().getCourseCode().compareToIgnoreCase(c9.getCourse().getCourseCode()) == 0){
					counter++;
				}
			}
		}
		if(counter == 3){
			System.out.println("Successful course instance pool retrieval");
		}
	}

	/**
	 * checks if ID retrieved matches with original pool's every CA's ID.
	 * @author sumeetgupta
	 * @throws IOException
	 * @throws NullPointerException
	 * @throws ParseException
	 */
	@Test
	public void testRetrieveCourseAssistantPool() throws IOException, NullPointerException, ParseException {
		obj1.storeDynamic(ca1, 2188);
		obj1.storeDynamic(ca2, 2188);
		obj1.storeDynamic(ca3, 2188);
		CourseAssistantPool cap7 = obj1.retrieveCourseAssistantPool(2188);
		Iterator<CourseAssistant> ica1 = cap7.getCourseAssistantSet().iterator();
		Iterator<CourseAssistant> ica2 = cap.getCourseAssistantSet().iterator();
		int counter = 0;
		while (ica1.hasNext()) {
			CourseAssistant ca8 = ica1.next();
			CourseAssistant ca9 = ica2.next();
			if (ca8.getId() == ca9.getId()) {
				counter++;
			}
		}
		if(counter == 3){
			System.out.println("Successful ca pool retrieval");
		}
	}

}
