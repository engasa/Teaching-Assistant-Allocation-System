package edu.udel.cis.taschd.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

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
 * The Database class is a component of the db module. It stores and retrieves
 * courses, course assistants, assignments by the request of the client.
 * 
 * @author Sumeet Gupta
 */
public class Database {

	/**
	 * Strings declaration and creation for use in the program
	 */
	private final String directory;

	private final String TASCHDDIR = "taschd_dir";

	private final String COURSES = "courses";

	private final String CAPOOL = "ca_pool";

	private final String TERMS = "terms";

	private final String ASSISTANTS = "assistants";

	private final String ASSIGNMENTS = "assignments";

	/**
	 * Constructor for Database
	 */
	public Database() {
		/**
		 * The name of the user's working directory when this class was loaded
		 */
		directory = System.getProperty("user.dir");
	}

	/**
	 * Checks whether taschd_dir exists.
	 * 
	 * @author - gsumeet
	 * @return {@code true} if the directory taschd_dir already exists, else
	 *         {@code false}
	 */
	private boolean taschdCheck() {

		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, TASCHDDIR);

		if (taschdDirectory.exists()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if course folder exists in taschd_dir
	 * 
	 * @author - gsumeet
	 * @return {@code true} if the 'courses' folder in directory 'taschd_dir'
	 *         already exists, else {@code false}
	 */
	private boolean taschdCourseFolderCheck() {

		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, TASCHDDIR);
		String[] taschdFolders = taschdDirectory.list();

		if (taschdFolders != null) {
			for (int i = 0; i < taschdFolders.length; i++) {
				if (taschdFolders[i].equalsIgnoreCase(COURSES)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * Checks if ca_pool folder exists in taschd_dir
	 * 
	 * @author - gsumeet
	 * @return {@code true} if 'ca_pool' folder exists in the directory
	 *         'taschd_dir' else {@code false}
	 */
	private boolean taschdCaPoolFolderCheck() {

		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, TASCHDDIR);
		String[] taschdFolders = taschdDirectory.list();

		if (taschdFolders != null) {
			for (int i = 0; i < taschdFolders.length; i++) {
				if (taschdFolders[i].equalsIgnoreCase(CAPOOL)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * Checks if terms folder exists in taschd_dir
	 * 
	 * @author - gsumeet
	 * @return {@code true} if 'terms' folder exists in the directory
	 *         'taschd_dir' else {@code false}
	 */
	private boolean taschdTermFolderCheck() {

		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, TASCHDDIR);
		String[] taschdFolders = taschdDirectory.list();

		if (taschdFolders != null) {
			for (int i = 0; i < taschdFolders.length; i++) {
				if (taschdFolders[i].equalsIgnoreCase(TERMS)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * Checks if [term] folder exists in terms folder in taschd_dir
	 * 
	 * @author - gsumeet
	 * @param term
	 *            The university identifier representing the term or semester in
	 *            which this course instance will be offered.
	 * @return {@code true} if the user specified 'term' (Ex:2188) was added
	 *         under the folder 'terms' in the directory 'taschd_dir' else
	 *         {@code false}
	 */
	private boolean termNumberFolderCheck(int term) {

		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, TASCHDDIR);
		File termsDirectory = new File(taschdDirectory, TERMS);
		String[] termsFolders = termsDirectory.list();

		if (termsFolders != null) {
			for (int i = 0; i < termsFolders.length; i++) {
				if (termsFolders[i].equalsIgnoreCase(String.valueOf(term))) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * Checks if courses folder exists in [term] folder in terms folder in
	 * taschd_dir
	 * 
	 * @author - gsumeet
	 * @param term
	 *            The university identifier representing the term or semester
	 *            which this course instance will be offered.
	 * @return {@code true} if the courses folder under user added term exists
	 *         under 'terms' folder in the directory 'taschd_dir' else
	 *         {@code false}
	 */
	private boolean termNumberCourseFolderCheck(int term) {

		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, TASCHDDIR);
		File termsDirectory = new File(taschdDirectory, TERMS);
		File termDirectory = new File(termsDirectory, String.valueOf(term));
		String[] termFolders = termDirectory.list();

		if (termFolders != null) {
			for (int i = 0; i < termFolders.length; i++) {
				if (termFolders[i].equalsIgnoreCase(COURSES)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * Checks if assistants folder exists in [term] folder in terms folder in
	 * taschd_dir
	 * 
	 * @author - gsumeet
	 * @param termForCA
	 *            The university identifier representing the term or semester
	 *            which this course instance will be offered.
	 * @return {@code true} if the 'assistants' folder exists in user added term
	 *         under 'terms' folder in the directory 'taschd_dir' else
	 *         {@code false}
	 */
	private boolean termNumberAssistantFolderCheck(int termForCA) {

		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, TASCHDDIR);
		File termsDirectory = new File(taschdDirectory, TERMS);
		File termDirectory = new File(termsDirectory, String.valueOf(termForCA));
		String[] termFolders = termDirectory.list();

		if (termFolders != null) {
			for (int i = 0; i < termFolders.length; i++) {
				if (termFolders[i].equalsIgnoreCase(ASSISTANTS)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * Checks if assignment folder exists in [term] folder in terms folder in
	 * taschd_dir
	 * 
	 * @author - gsumeet
	 * @param termToStore
	 *            The university identifier representing the term or semester
	 *            which this course instance will be offered.
	 * @return {@code true} if 'assignments' folder exists under user added term
	 *         under 'terms' folder in the directory 'taschd_dir' else
	 *         {@code false}
	 */
	private boolean termNumberAssignmentFolderCheck(int termToStore) {

		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, TASCHDDIR);
		File termsDirectory = new File(taschdDirectory, TERMS);
		File termDirectory = new File(termsDirectory, String.valueOf(termToStore));
		String[] termFolders = termDirectory.list();

		if (termFolders != null) {
			for (int i = 0; i < termFolders.length; i++) {
				if (termFolders[i].equalsIgnoreCase(ASSIGNMENTS)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}

	/**
	 * Indents json object and store it in json file.
	 * 
	 * @author - gsumeet
	 * @param value
	 *            This is the JSON Object that will be stored in the .json file
	 *            under the specified directory
	 * @param directoryToStoreIn
	 *            The directory under which the .json file has to be saved
	 * @param fileToStore
	 *            The .json file that has to be stored in the directory
	 * @throws JsonParseException
	 *             To handle error parsing JSON
	 * @throws JsonMappingException
	 *             To handle error mapping JSON
	 * @throws IOException
	 *             To handle error when reading the JSON stream
	 */
	private void storeJSON(JSONObject value, File directoryToStoreIn, String fileToStore)
			throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		Object json = mapper.readValue(value.toJSONString(), Object.class);
		// for pretty printing json in readable format
		String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		File file = new File(directoryToStoreIn, fileToStore);
		PrintWriter pw = new PrintWriter(file);

		pw.write(indented);
		pw.flush();
		pw.close();
	}

	/**
	 * Deletes a file given by {@code file}
	 * 
	 * @author - gsumeet
	 * @param file
	 *            This is the .json file to delete
	 */
	private void deleteFolder(File file) {

		File[] allContents = file.listFiles();

		if (allContents != null) {
			for (File f : allContents) {
				deleteFolder(f);
			}
		}
	}

	/**
	 * Stores course in json format for static data under the folder 'courses'
	 * in the directory 'taschd_dir'
	 * 
	 * @author - gsumeet
	 * @param c
	 *            'c' is a {@link CourseInstance}
	 * @throws IOException
	 *             To handle error when reading the JSON stream
	 * @throws JsonMappingException
	 *             To handle error mapping JSON
	 * @throws JsonParseException
	 *             To handle error parsing JSON
	 */
	@SuppressWarnings("unchecked")
	public void store(CourseInstance c) throws JsonParseException, JsonMappingException, IOException {

		String fileToStore = c.getCourse().getPrefix() + c.getCourse().getCourseCode() + ".json";
		boolean fileExists = false;

		// checks the directory structure
		if (taschdCheck()) {
			if (taschdCourseFolderCheck()) {

				File rootDir = new File(directory);
				File taschdDirectory = new File(rootDir, TASCHDDIR);
				File courseDirectory = new File(taschdDirectory, COURSES);
				String[] coursesFolder = courseDirectory.list();

				// checks if folder is empty
				if (coursesFolder != null) {
					for (int i = 0; i < coursesFolder.length; i++) {
						if (FilenameUtils.getExtension(coursesFolder[i]).equalsIgnoreCase("json")
								&& coursesFolder[i].startsWith(c.getCourse().getPrefix())
								&& coursesFolder[i].equalsIgnoreCase(fileToStore)) {
							System.out.println("Course file with name: " + fileToStore + " already exists.");
							fileExists = true;
							break;
						}
					}
				}
				if (!fileExists) {

					// creation of json object
					JSONObject value = new JSONObject();
					Skill s = null;
					Iterator<Skill> iter = c.getCourse().getSkills().getSkills().iterator();
					JsonArrayBuilder builderSkill = Json.createArrayBuilder();

					value.put("Prefix", c.getCourse().getPrefix() != null ? c.getCourse().getPrefix() : "");
					value.put("Course Code",
							c.getCourse().getCourseCode() != null ? c.getCourse().getCourseCode() : "");
					value.put("Course Name",
							c.getCourse().getCourseName() != null ? c.getCourse().getCourseName() : "");
					value.put("Has Lab", c.isHasLab());

					while (iter.hasNext()) {
						s = iter.next();
						builderSkill.add(s.toString());
					}

					JsonArray arr = builderSkill.build();
					value.put("Skills", arr);
					storeJSON(value, courseDirectory, fileToStore);

				} else {
					System.out.println("File with name " + fileToStore + " already exists.");
				}
			} else {
				System.out.println("courses directory does not exist.");
			}
		} else {
			System.out.println("taschd directory does not exist.");
		}
		fileExists = false;
	}

	/**
	 * Stores dynamic Course data under courses in the user added term under
	 * terms folder in the directory 'taschd_dir'
	 * 
	 * @author - gsumeet
	 * @param ci
	 *            'ci' is a {@link CourseInstance}
	 * @param termForCourse
	 *            The university identifier representing the term or semester
	 *            which this course instance will be offered. User entered value
	 *            under which the course data will be saved.
	 * @throws IOException
	 *             To handle error when reading the JSON stream
	 * @throws JsonMappingException
	 *             To handle error mapping JSON
	 * @throws JsonParseException
	 *             To handle error parsing JSON
	 * @throws ParseException
	 *             To handle error parsing data
	 */

	@SuppressWarnings({ "unchecked" })
	public void storeDynamic(CourseInstance ci)
			throws JsonParseException, JsonMappingException, IOException, ParseException {

		int termForCourse = ci.getTerm();
		String fileToStore = ci.getCourse().getPrefix() + ci.getCourse().getCourseCode() + ".json";
		Course c = null;
		Iterator<Skill> iterSkill = null;
		Skill sk = null;
		JSONObject value = new JSONObject();

		if (taschdCheck()) {
			if (taschdTermFolderCheck()) {
				if (termNumberFolderCheck(termForCourse)) {
					if (termNumberCourseFolderCheck(termForCourse)) {

						File rootDir = new File(directory);
						File taschdDirectory = new File(rootDir, TASCHDDIR);
						File termsDirectory = new File(taschdDirectory, TERMS);
						File termNumberDirectory = new File(termsDirectory, String.valueOf(termForCourse));
						File termNumberCourseDirectory = new File(termNumberDirectory, COURSES);
						File file = new File(termNumberCourseDirectory, fileToStore);
						String[] termNumberCourseFolder = termNumberCourseDirectory.list();

						if (termNumberCourseFolder != null) {
							for (int i = 0; i < termNumberCourseFolder.length; i++) {
								if (FilenameUtils.getExtension(termNumberCourseFolder[i]).equalsIgnoreCase("json")
										&& termNumberCourseFolder[i].startsWith(ci.getCourse().getPrefix())
										&& termNumberCourseFolder[i].equalsIgnoreCase(fileToStore)) {
									deleteFolder(file);

									c = retrieveCourse(ci.getCourse().getPrefix(), ci.getCourse().getCourseCode());

									break;
								}
							}
						}

						// tries to add static data if it exists
						if (c != null) {
							value.put("Prefix", c.getPrefix() != null ? c.getPrefix() : "");
							value.put("Course Code", c.getCourseCode() != null ? c.getCourseCode() : "");
							value.put("Course Name", c.getCourseName() != null ? c.getCourseName() : "");
							iterSkill = c.getSkills().getSkills().iterator();
						}
						// tries to add dynamic data if static does not exist
						else {
							value.put("Prefix", ci.getCourse().getPrefix() != null ? ci.getCourse().getPrefix() : "");
							value.put("Course Code",
									ci.getCourse().getCourseCode() != null ? ci.getCourse().getCourseCode() : "");
							value.put("Course Name",
									ci.getCourse().getCourseName() != null ? ci.getCourse().getCourseName() : "");
							iterSkill = ci.getCourse().getSkills().getSkills().iterator();
						}

						JsonArrayBuilder builderSkill = Json.createArrayBuilder();
						TimeInterval ti = null;
						Iterator<TimeInterval> iterTime = null;
						Iterator<Section> iter = ci.getSections().iterator();
						JsonArrayBuilder builder = Json.createArrayBuilder();
						JsonArrayBuilder builderTime = Json.createArrayBuilder();

						while (iterSkill.hasNext()) {
							sk = iterSkill.next();
							builderSkill.add(sk.toString());
						}

						JsonArray arrSkill = builderSkill.build();
						value.put("Skills", arrSkill);
						value.put("Has Lab", ci.isHasLab());

						// adding section data
						while (iter.hasNext()) {

							Section s = iter.next();
							iterTime = s.getSchedule().getSchedule().iterator();

							while (iterTime.hasNext()) {
								ti = iterTime.next();
								builderTime.add(ti.toString());
							}

							JsonArray arrTime = builderTime.build();
							builder.add(Json.createObjectBuilder()
									.add("Section Number", (s.getSectionNumber() != null ? s.getSectionNumber() : ""))
									.add("Section Type", (s.getSectionType() != null ? s.getSectionType() : ""))
									.add("Instructor name",
											(s.getInstructorName() != null ? s.getInstructorName() : ""))
									.add("Location", (s.getLocation() != null ? s.getLocation() : ""))
									.add("Current Enrollment", (String.valueOf(s.getCurrentEnrollment())))
									.add("Enrollment Cap", (String.valueOf(s.getEnrollmentCap())))
									.add("TA Assigned", (s.isTaAssigned()))
									.add("Num of TA", (String.valueOf(s.getNumOfTA())))
									.add("Num of LA", (String.valueOf(s.getNumOfLA()))).add("MTAC", (s.isMtac()))
									.add("Time Schedule", arrTime));

						}

						JsonArray arr = builder.build();
						value.put("Sections", arr);
						storeJSON(value, termNumberCourseDirectory, fileToStore);

					} else {
						System.out.println("courses folder does not exist in " + termForCourse + " folder.");
					}
				} else {
					System.out.println(termForCourse + " directory does not exist.");
				}
			} else {
				System.out.println("terms directory does not exist.");
			}
		} else {
			System.out.println("taschd directory does not exist.");
		}
	}

	/**
	 * Stores CA in json format for static data under 'ca_pool' folder in the
	 * directory 'taschd_dir'
	 * 
	 * @param ca
	 *            'ca' is an instance of {@link CourseAssistant}
	 * @throws IOException
	 *             To handle error when reading the JSON stream
	 * @throws JsonMappingException
	 *             To handle error mapping JSON
	 * @throws JsonParseException
	 *             To handle error parsing JSON
	 */
	@SuppressWarnings("unchecked")
	public void store(CourseAssistant ca) throws JsonParseException, JsonMappingException, IOException {

		String fileToStore = "SID" + ca.getId() + ".json";
		boolean fileExists = false;

		if (taschdCheck()) {
			if (taschdCaPoolFolderCheck()) {

				File rootDir = new File(directory);
				File taschdDirectory = new File(rootDir, TASCHDDIR);
				File caPoolDirectory = new File(taschdDirectory, CAPOOL);
				String[] caPoolFolder = caPoolDirectory.list();

				if (caPoolFolder != null) {
					for (int i = 0; i < caPoolFolder.length; i++) {
						if (FilenameUtils.getExtension(caPoolFolder[i]).equalsIgnoreCase("json")
								&& caPoolFolder[i].startsWith("SID") && caPoolFolder[i].equalsIgnoreCase(fileToStore)) {
							System.out.println("CA file with name: " + fileToStore + " already exists.");
							fileExists = true;
							break;
						}
					}
				}

				if (!fileExists) {

					JSONObject value = new JSONObject();
					Skill sk = null;
					Iterator<Skill> iterSkill = ca.getPossessedSkillset().getSkills().iterator();
					JsonArrayBuilder builderSkill = Json.createArrayBuilder();

					value.put("First Name", ca.getFirstName() != null ? ca.getFirstName() : "");
					value.put("Last Name", ca.getLastName() != null ? ca.getLastName() : "");
					value.put("ID", ca.getId());
					value.put("Email", ca.getEmailAddress() != null ? ca.getEmailAddress() : "");
					value.put("Graduate Student", ca.getGraduateStudent());

					while (iterSkill.hasNext()) {
						sk = iterSkill.next();
						builderSkill.add(sk.toString());
					}

					JsonArray arrSkill = builderSkill.build();
					value.put("Skills", arrSkill);
					storeJSON(value, caPoolDirectory, fileToStore);

				} else {
					System.out.println("File with name " + fileToStore + " already exists.");
				}
			} else {
				System.out.println("ca_pool directory does not exist.");
			}
		} else {
			System.out.println("taschd directory does not exist.");
		}
		fileExists = false;
	}

	/**
	 * Stores dynamic CA data under 'assistants' in the user entered 'term'
	 * under the 'terms' folder in the directory 'taschd_dir'
	 * 
	 * @param ca
	 *            'ca' is an instance of {@link CourseAssistant}
	 * @param termForCA
	 *            The university identifier representing the term or semester
	 *            which this course instance will be offered. User entered value
	 *            (Ex: 2188) under which the ca data will be stored
	 * @throws JsonParseException
	 *             To handle error parsing JSON
	 * @throws JsonMappingException
	 *             To handle error mapping JSON
	 * @throws IOException
	 *             To handle error when reading the JSON stream
	 * @throws ParseException
	 *             To handle error parsing data
	 */
	@SuppressWarnings("unchecked")
	public void storeDynamic(CourseAssistant ca, int termForCA)
			throws JsonParseException, JsonMappingException, IOException, ParseException {

		String fileToStore = "SID" + ca.getId() + ".json";
		JSONObject value = new JSONObject();
		CourseAssistant ca2 = null;
		Iterator<Skill> iterSkill = null;
		Skill sk = null;

		if (taschdCheck()) {
			if (taschdTermFolderCheck()) {
				if (termNumberFolderCheck(termForCA)) {
					if (termNumberAssistantFolderCheck(termForCA)) {

						File rootDir = new File(directory);
						File taschdDirectory = new File(rootDir, TASCHDDIR);
						File termsDirectory = new File(taschdDirectory, TERMS);
						File termNumberDirectory = new File(termsDirectory, String.valueOf(termForCA));
						File termNumberAssistantDirectory = new File(termNumberDirectory, ASSISTANTS);
						String[] termNumberAssistantFolder = termNumberAssistantDirectory.list();
						File file = new File(termNumberAssistantDirectory, fileToStore);

						if (termNumberAssistantFolder != null) {
							for (int i = 0; i < termNumberAssistantFolder.length; i++) {
								if (FilenameUtils.getExtension(termNumberAssistantFolder[i]).equalsIgnoreCase("json")
										&& termNumberAssistantFolder[i].startsWith("SID")
										&& termNumberAssistantFolder[i].equalsIgnoreCase(fileToStore)) {
									deleteFolder(file);
									ca2 = retrieveCourseAssistant(ca.getId());
									break;
								}
							}
						}

						if (ca2 != null) {

							value.put("First Name", ca2.getFirstName() != null ? ca2.getFirstName() : "");
							value.put("Last Name", ca2.getLastName() != null ? ca2.getLastName() : "");
							value.put("ID", ca2.getId());
							value.put("Email", ca2.getEmailAddress() != null ? ca2.getEmailAddress() : "");
							value.put("Graduate Student", ca2.getGraduateStudent());
							iterSkill = ca2.getPossessedSkillset().getSkills().iterator();

						} else {

							value.put("First Name", ca.getFirstName() != null ? ca.getFirstName() : "");
							value.put("Last Name", ca.getLastName() != null ? ca.getLastName() : "");
							value.put("ID", ca.getId());
							value.put("Email", ca.getEmailAddress() != null ? ca.getEmailAddress() : "");
							value.put("Graduate Student", ca.getGraduateStudent());
							iterSkill = ca.getPossessedSkillset().getSkills().iterator();

						}

						JsonArrayBuilder builderCourseEnrolled = Json.createArrayBuilder();
						CourseInstance c = null;
						Iterator<CourseInstance> iterCI = ca.getCourseEnrolled() != null
								? ca.getCourseEnrolled().iterator() : null;
						JsonArrayBuilder builderSkill = Json.createArrayBuilder();

						if (iterCI != null) {
							while (iterCI.hasNext()) {
								c = iterCI.next();
								builderCourseEnrolled.add(c.toString());
							}
							JsonArray arrCourseEnrolled = builderCourseEnrolled.build();
							value.put("Course Enrolled", arrCourseEnrolled);
						} else {
							value.put("Course Enrolled", null);
						}

						while (iterSkill.hasNext()) {
							sk = iterSkill.next();
							builderSkill.add(sk.toString());
						}

						JsonArray arrSkill = builderSkill.build();
						value.put("Skills", arrSkill);
						TimeInterval ti = null;
						Iterator<TimeInterval> iterTime = ca.getWtps().getSchedule().iterator();
						JsonArrayBuilder builderTime = Json.createArrayBuilder();

						while (iterTime.hasNext()) {
							ti = iterTime.next();
							builderTime.add(ti.toString());
						}

						JsonArray arrTime = builderTime.build();
						value.put("Time Schedule", arrTime);
						storeJSON(value, termNumberAssistantDirectory, fileToStore);

					} else {
						System.out.println("Assistants folder does not exist in " + termForCA + " folder.");
					}
				} else {
					System.out.println(termForCA + " directory does not exist.");
				}
			} else {
				System.out.println("terms directory does not exist.");
			}
		} else {
			System.out.println("taschd directory does not exist.");
		}
	}

	/**
	 * Retrieves stored CA data by the ID number
	 *
	 * @author Michael Oyefusi
	 *
	 * @param caID
	 *            This variable represents the student's id number. For example,
	 *            "702147592".
	 * @param termForCA
	 *            User entered value for term under which the CA data is
	 *            retrieved from
	 * @throws FileNotFoundException
	 *             To handle error if file not found
	 * @throws NullPointerException
	 *             Thrown when an application attempts to use null in a case
	 *             where an object is required.
	 * @throws IOException
	 *             To handle error when reading the JSON stream
	 * @throws ParseException
	 *             To handle error in parsing data
	 *
	 * @return foundca returns details of the CA stored under the specified caID
	 */

	public CourseAssistant retrieveCAById(int caID, int termForCA)
			throws FileNotFoundException, NullPointerException, IOException, ParseException {

		String fileToRetrieve = "SID" + caID + ".json";
		CourseAssistant foundca = new CourseAssistant(caID);
		boolean fileExists = false;

		if (taschdCheck()) {
			if (taschdTermFolderCheck()) {
				if (termNumberFolderCheck(termForCA)) {
					if (termNumberAssistantFolderCheck(termForCA)) {

						File rootDir = new File(directory);
						File taschdDirectory = new File(rootDir, TASCHDDIR);
						File termsDirectory = new File(taschdDirectory, TERMS);
						File termNumberDirectory = new File(termsDirectory, String.valueOf(termForCA));
						File termNumberAssistantDirectory = new File(termNumberDirectory, ASSISTANTS);

						String[] termNumberAssistantFolder = termNumberAssistantDirectory.list();



						if (termNumberAssistantFolder != null) {
							for (int i = 0; i < termNumberAssistantFolder.length; i++) {
								SkillSet ss = new SkillSet();
								Skill sk = null;
								Course c = null;
								String[] cEnroll = null;
								CourseInstance ce = null;
								String tInt = "";
								TimeInterval ti;
								WeeklySchedule ws = new WeeklySchedule();
								Set<CourseInstance> sci = new HashSet<CourseInstance>();
								
								if (FilenameUtils.getExtension(termNumberAssistantFolder[i]).equalsIgnoreCase("json")
										&& termNumberAssistantFolder[i].startsWith("SID")
										&& termNumberAssistantFolder[i].equalsIgnoreCase(fileToRetrieve)) {

									JSONParser parser = new JSONParser();
									File readFile = new File(termNumberAssistantDirectory,
											termNumberAssistantFolder[i]);
									Object ob1 = parser.parse(new FileReader(readFile));
									JSONObject jsonObj = (JSONObject) ob1;
									String firstName = (String) jsonObj.get("First Name");
									String lastName = (String) jsonObj.get("Last Name");
									JSONArray skillData = (JSONArray) jsonObj.get("Skills");
									String email = (String) jsonObj.get("Email");
									boolean grad = (boolean) jsonObj.get("Graduate Student");
									JSONArray courseEnroll = (JSONArray) jsonObj.get("Course Enrolled");
									JSONArray timeSched = (JSONArray) jsonObj.get("Time Schedule");

									for (int j = 0; j < skillData.size(); j++) {
										sk = new Skill((String) skillData.get(j));
										ss.addSkill(sk);
									}
									for (int j = 0; j < timeSched.size(); j++) {
										tInt = timeSched.get(j).toString();
										ti = new TimeInterval(tInt);
										ws.addInterval(ti);
									}
									if (courseEnroll != null) {
										for (int k = 0; k < courseEnroll.size(); k++) {
											cEnroll = courseEnroll.get(k).toString().split(" ");
											c = new Course(cEnroll[0], cEnroll[1], cEnroll[2]);
											ce = new CourseInstance(c, termForCA);
											sci.add(ce);
											cEnroll = null;
											c = null;
											ce = null;
										}
									}

									foundca.setFirstName(firstName);
									foundca.setLastName(lastName);
									foundca.setEmailAddress(email);
									foundca.setGraduateStudent(grad);
									foundca.setPossessedSkillset(ss);
									foundca.setCourseEnrolled(sci);
									foundca.setWtps(ws);

								}
							}
						} else if (!fileExists) {
							System.out.println("Course Assistant file with ID number: " + caID + " does not exist.");
						} else {
							System.out.println("Course Assistant with ID number " + caID + " does not exist.");
						}
					} else {
						System.out.println("ca_pool directory does not exist.");
					}
				} else {
					System.out.println("taschd directory does not exist.");
				}
			}
		}
		return foundca;

	}

	/**
	 * Retrieves dynamic details of stored Course Instance data by prefix and
	 * Course Code under the user specified term folder in 'terms' folder in the
	 * directory 'taschd_dir'
	 *
	 * @author Michael Oyefusi
	 *
	 * @param prefix
	 *            The university 4-character department identifier that this
	 *            Course has. For example, "CISC" stands for Computer and
	 *            Information Science. This is a String consisting of only
	 *            capital letters.
	 * @param courseCode
	 *            The university 3-digit course identifier that this Course has.
	 *            This is a String in the range [000,999]. Note that all course
	 *            codes have leading 0's. For example, 10 represents 010 and 1
	 *            represents 001.
	 * @param term
	 *            The university identifier representing the term or semester
	 *            which this course instance will be offered.
	 *
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 *
	 * @return foundcourse returns details of the course under the specified
	 *         prefix, courseCode and term
	 */
	public CourseInstance retrieveCourseByCode(String prefix, String courseCode, int term)
			throws FileNotFoundException, IOException, ParseException {

		String fileToRetrieve = prefix + courseCode + ".json";
		CourseInstance foundcourse = null;

		if (taschdCheck()) {
			if (taschdTermFolderCheck()) {
				if (termNumberFolderCheck(term)) {
					if (termNumberCourseFolderCheck(term)) {

						File rootDir = new File(directory);
						File taschdDirectory = new File(rootDir, TASCHDDIR);
						File termsDirectory = new File(taschdDirectory, TERMS);
						File termNumberDirectory = new File(termsDirectory, String.valueOf(term));
						File termNumberCourseDirectory = new File(termNumberDirectory, COURSES);

						String[] termNumberCourseFolder = termNumberCourseDirectory.list();

						if (termNumberCourseFolder != null) {
							for (int i = 0; i < termNumberCourseFolder.length; i++) {
								
								SkillSet ss = new SkillSet();
								Skill sk = null;
								Section sec = null;
								Course c = null;
								TimeInterval ti;
								WeeklySchedule ws = new WeeklySchedule();
								String tInt = "";
								
								if (FilenameUtils.getExtension(termNumberCourseFolder[i]).equalsIgnoreCase("json")
										&& termNumberCourseFolder[i].startsWith(prefix)
										&& termNumberCourseFolder[i].equalsIgnoreCase(fileToRetrieve)) {

									JSONParser parser = new JSONParser();
									File readFile = new File(termNumberCourseDirectory, termNumberCourseFolder[i]);
									Object ob1 = parser.parse(new FileReader(readFile));
									JSONObject jsonObj = (JSONObject) ob1;
									String cprefix = (String) jsonObj.get("Prefix");
									String cCode = (String) jsonObj.get("Course Code");
									String courseName = (String) jsonObj.get("Course Name");
									JSONArray skillData = (JSONArray) jsonObj.get("Skills");
									boolean hasLab = (boolean) jsonObj.get("Has Lab");
									JSONArray sectionData = (JSONArray) jsonObj.get("Sections");

									for (int j = 0; j < skillData.size(); j++) {
										sk = new Skill((String) skillData.get(j));
										ss.addSkill(sk);
									}

									c = new Course(cprefix, cCode, courseName);
									c.setSkills(ss);
									foundcourse = new CourseInstance(c, term);
									foundcourse.setHasLab(hasLab);

									for (int l = 0; l < sectionData.size(); l++) {

										JSONObject obj2 = (JSONObject) sectionData.get(l);
										String secType = (String) obj2.get("Section Type");
										String secNum = (String) obj2.get("Section Number");
										String insName = (String) obj2.get("Instructor name");
										int currEnroll = Integer.parseInt((String) obj2.get("Current Enrollment"));
										int maxCap = Integer.parseInt((String) obj2.get("Enrollment Cap"));
										String location = (String) obj2.get("Location");
										boolean mtac = (boolean) obj2.get("MTAC");
										int numTA = Integer.parseInt((String) obj2.get("Num of TA"));
										int numLA = Integer.parseInt((String) obj2.get("Num of LA"));
										boolean taAssign = (boolean) obj2.get("TA Assigned");
										JSONArray timeSched = (JSONArray) obj2.get("Time Schedule");

										if (timeSched != null) {
											for (int j = 0; j < timeSched.size(); j++) {
												tInt = timeSched.get(j).toString();
												ti = new TimeInterval(tInt);
												ws.addInterval(ti);
											}
										}

										sec = new Section(secType, secNum, insName, currEnroll, maxCap, location, ws);
										sec.setNumOfTA(numTA);
										sec.setNumOfLA(numLA);
										sec.setTaAssigned(taAssign);
										sec.setMtac(mtac);
										foundcourse.addSection(sec);

									}

								}
							}
						} else {
							System.out.println("File with name " + fileToRetrieve + " does not exist.");
						}
					} else {
						System.out.println("courses folder does not exist in " + term + " folder.");
					}
				} else {
					System.out.println(term + " directory does not exist.");
				}
			} else {
				System.out.println("terms directory does not exist.");
			}
		} else {
			System.out.println("taschd directory does not exist.");
		}

		return foundcourse;
	}

	/**
	 * Retrieves static details of the Course from the database stored under the
	 * 'courses' folder in the directory 'taschd_dir'
	 * 
	 * @author - gsumeet
	 * @param prefix
	 *            The university 4-character department identifier that this
	 *            Course has. For example, "CISC" stands for Computer and
	 *            Information Science. This is a String consisting of only
	 *            capital letters.
	 * @param courseCode
	 *            The university 3-digit course identifier that this Course has.
	 *            This is a String in the range [000,999]. Note that all course
	 *            codes have leading 0's. For example, 10 represents 010 and 1
	 *            represents 001.
	 * @return c static details of the specified course
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public Course retrieveCourse(String prefix, String courseCode)
			throws FileNotFoundException, IOException, ParseException {

		String fileToRetrieve = prefix + courseCode + ".json";
		Course c = null;

		if (taschdCheck()) {
			if (taschdCourseFolderCheck()) {

				File rootDir = new File(directory);
				File taschdDirectory = new File(rootDir, TASCHDDIR);
				File courseDirectory = new File(taschdDirectory, COURSES);
				String[] courseFolder = courseDirectory.list();
				SkillSet ss = new SkillSet();
				Skill sk = null;

				if (courseFolder != null) {
					for (int i = 0; i < courseFolder.length; i++) {
						if (FilenameUtils.getExtension(courseFolder[i]).equalsIgnoreCase("json")
								&& courseFolder[i].startsWith(prefix)
								&& courseFolder[i].equalsIgnoreCase(fileToRetrieve)) {

							// read json object into program
							JSONParser parser = new JSONParser();
							File readFile = new File(courseDirectory, courseFolder[i]);
							Object ob1 = parser.parse(new FileReader(readFile));
							JSONObject jsonObj = (JSONObject) ob1;
							prefix = (String) jsonObj.get("Prefix");
							courseCode = (String) jsonObj.get("Course Code");
							String courseName = (String) jsonObj.get("Course Name");
							JSONArray skillData = (JSONArray) jsonObj.get("Skills");
							// boolean hasLab = (boolean) jsonObj.get("Has
							// Lab");

							for (int j = 0; j < skillData.size(); j++) {
								sk = new Skill((String) skillData.get(j));
								ss.addSkill(sk);
							}

							c = new Course(prefix, courseCode, courseName);
							c.setSkills(ss);

						}
					}
				} else {
					System.out.println(COURSES + " directory is empty");
				}
			} else {
				System.out.println(COURSES + " directory does not exist.");
			}
		} else {
			System.out.println("taschd directory does not exist.");
		}
		return c;
	}

	/**
	 * Retrieves details of the course assistant from taschd_dir/ca_pool by
	 * specifying the required caID
	 * 
	 * @author - gsumeet
	 * @param caID
	 *            This variable represents the student's id number. For example,
	 *            "702147592".
	 * @return ca details of the CA by looking up the CA by caID
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public CourseAssistant retrieveCourseAssistant(int caID) throws FileNotFoundException, IOException, ParseException {

		String fileToRetrieve = "SID" + caID + ".json";
		CourseAssistant ca = null;

		if (taschdCheck()) {
			if (taschdCaPoolFolderCheck()) {

				File rootDir = new File(directory);
				File taschdDirectory = new File(rootDir, TASCHDDIR);
				File caPoolDirectory = new File(taschdDirectory, CAPOOL);
				String[] caPoolFolder = caPoolDirectory.list();
				SkillSet ss = new SkillSet();
				Skill sk = null;

				if (caPoolFolder != null) {
					for (int i = 0; i < caPoolFolder.length; i++) {
						// file check by extension, name
						if (FilenameUtils.getExtension(caPoolFolder[i]).equalsIgnoreCase("json")
								&& caPoolFolder[i].startsWith("SID")
								&& caPoolFolder[i].equalsIgnoreCase(fileToRetrieve)) {

							JSONParser parser = new JSONParser();
							File readFile = new File(caPoolDirectory, caPoolFolder[i]);
							Object ob1 = parser.parse(new FileReader(readFile));
							JSONObject jsonObj = (JSONObject) ob1;
							String firstName = (String) jsonObj.get("First Name");
							String lastName = (String) jsonObj.get("Last Name");
							int id = Integer.parseInt(String.valueOf(jsonObj.get("ID")));
							JSONArray skillData = (JSONArray) jsonObj.get("Skills");
							String email = (String) jsonObj.get("Email");
							boolean grad = (boolean) jsonObj.get("Graduate Student");

							for (int j = 0; j < skillData.size(); j++) {
								sk = new Skill((String) skillData.get(j));
								ss.addSkill(sk);
							}

							ca = new CourseAssistant(id);
							ca.setFirstName(firstName);
							ca.setLastName(lastName);
							ca.setEmailAddress(email);
							ca.setGraduateStudent(grad);
							ca.setPossessedSkillset(ss);

						}
					}
				} else {
					System.out.println(COURSES + " directory is empty");
				}
			} else {
				System.out.println(COURSES + " directory does not exist.");
			}
		} else {
			System.out.println("taschd directory does not exist.");
		}
		return ca;
	}

	/**
	 * Returns all details of CA corresponding to respective term which is
	 * stored under 'assistants' folder in the directory 'taschd_dir'
	 * 
	 * @author - gsumeet
	 * @param termForCA
	 *            The university identifier representing the term or semester
	 *            which this course instance will be offered.
	 * @return capl returns dynamic details of the all course assistants by user
	 *         specified term
	 * @throws ParseException
	 * @throws IOException
	 */
	public CourseAssistantPool retrieveCourseAssistantPool(int termForCA) throws IOException, ParseException {

		CourseAssistant ca = null;
		CourseAssistantPool capl = new CourseAssistantPool();

		if (taschdCheck()) {
			if (taschdTermFolderCheck()) {
				if (termNumberFolderCheck(termForCA)) {
					if (termNumberAssistantFolderCheck(termForCA)) {

						File rootDir = new File(directory);
						File taschdDirectory = new File(rootDir, TASCHDDIR);
						File termsDirectory = new File(taschdDirectory, TERMS);
						File termNumberDirectory = new File(termsDirectory, String.valueOf(termForCA));
						File termNumberAssistantDirectory = new File(termNumberDirectory, ASSISTANTS);
						String[] termNumberAssistantFolder = termNumberAssistantDirectory.list();



						if (termNumberAssistantFolder != null) {
							for (int i = 0; i < termNumberAssistantFolder.length; i++) {
								SkillSet ss = new SkillSet();
								
								Set<CourseInstance> sci = new HashSet<CourseInstance>();
								Course c = null;
								String[] cEnroll = null;
								CourseInstance ce = null;
								String tInt = "";
								Skill sk = null;
								TimeInterval ti = null;
								WeeklySchedule ws = new WeeklySchedule();
								
								if (FilenameUtils.getExtension(termNumberAssistantFolder[i]).equalsIgnoreCase("json")
										&& termNumberAssistantFolder[i].startsWith("SID")) {

									JSONParser parser = new JSONParser();
									File readFile = new File(termNumberAssistantDirectory,
											termNumberAssistantFolder[i]);
									Object ob1 = parser.parse(new FileReader(readFile));
									JSONObject jsonObj = (JSONObject) ob1;
									String firstName = (String) jsonObj.get("First Name");
									String lastName = (String) jsonObj.get("Last Name");
									int id = Integer.parseInt(String.valueOf(jsonObj.get("ID")));
									JSONArray skillData = (JSONArray) jsonObj.get("Skills");
									String email = (String) jsonObj.get("Email");
									boolean grad = (boolean) jsonObj.get("Graduate Student");
									JSONArray courseEnroll = (JSONArray) jsonObj.get("Course Enrolled");
									JSONArray timeSched = (JSONArray) jsonObj.get("Time Schedule");
									ca = new CourseAssistant(id);

									for (int j = 0; j < skillData.size(); j++) {
										sk = new Skill((String) skillData.get(j));
										ss.addSkill(sk);
									}
									for (int j = 0; j < timeSched.size(); j++) {
										tInt = timeSched.get(j).toString();
										ti = new TimeInterval(tInt);
										ws.addInterval(ti);
									}
									if (courseEnroll != null) {
										for (int j = 0; j < courseEnroll.size(); j++) {
											cEnroll = courseEnroll.get(j).toString().split(" ");
											c = new Course(cEnroll[0], cEnroll[1], cEnroll[2]);
											ce = new CourseInstance(c, termForCA);
											sci.add(ce);
											cEnroll = null;
											c = null;
											ce = null;
										}
									}

									ca.setFirstName(firstName);
									ca.setLastName(lastName);
									ca.setEmailAddress(email);
									ca.setGraduateStudent(grad);
									ca.setPossessedSkillset(ss);
									ca.setCourseEnrolled(sci);
									ca.setWtps(ws);
									capl.addCourseAssistant(ca);

								}
							}
						} else {
							System.out.println("Assistants folder is empty");
						}
					} else {
						System.out.println("Assistants folder does not exist in " + termForCA + " folder.");
					}
				} else {
					System.out.println(termForCA + " directory does not exist.");
				}
			} else {
				System.out.println("terms directory does not exist.");
			}
		} else {
			System.out.println("taschd directory does not exist.");
		}
		return capl;
	}

	/**
	 * Returns all details of all Courses corresponding to respective term
	 * 
	 * @author - gsumeet
	 * @param termForCourse
	 *            The university identifier representing the term or semester
	 *            which this course instance will be offered.
	 * @return cipl returns dynamic details of all courses in the 'course'
	 *         folder under user specified term in the 'terms' folder in the
	 *         directory 'taschd_dir'
	 * @throws ParseException
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public CourseInstancePool retrieveCourseInstancePool(int termForCourse)
			throws FileNotFoundException, IOException, ParseException {

		CourseInstance ci = null;
		Course c = null;
		CourseInstancePool cipl = new CourseInstancePool();

		if (taschdCheck()) {
			if (taschdTermFolderCheck()) {
				if (termNumberFolderCheck(termForCourse)) {
					if (termNumberCourseFolderCheck(termForCourse)) {

						File rootDir = new File(directory);
						File taschdDirectory = new File(rootDir, TASCHDDIR);
						File termsDirectory = new File(taschdDirectory, TERMS);
						File termNumberDirectory = new File(termsDirectory, String.valueOf(termForCourse));
						File termNumberCourseDirectory = new File(termNumberDirectory, COURSES);
						String[] termNumberCourseFolder = termNumberCourseDirectory.list();



						if (termNumberCourseFolder != null) {
							for (int i = 0; i < termNumberCourseFolder.length; i++) {
								
								SkillSet ss = new SkillSet();
								Skill sk = null;
								Section sec = null;
								
								if (FilenameUtils.getExtension(termNumberCourseFolder[i]).equalsIgnoreCase("json")
										&& termNumberCourseFolder[i].startsWith("CISC")) {

									JSONParser parser = new JSONParser();
									File readFile = new File(termNumberCourseDirectory, termNumberCourseFolder[i]);
									Object ob1 = parser.parse(new FileReader(readFile));
									JSONObject jsonObj = (JSONObject) ob1;
									String prefix = (String) jsonObj.get("Prefix");
									String courseCode = (String) jsonObj.get("Course Code");
									String courseName = (String) jsonObj.get("Course Name");
									JSONArray skillData = (JSONArray) jsonObj.get("Skills");
									boolean hasLab = (boolean) jsonObj.get("Has Lab");
									JSONArray sectionData = (JSONArray) jsonObj.get("Sections");

									if (skillData != null) {
										for (int j = 0; j < skillData.size(); j++) {
											sk = new Skill((String) skillData.get(j));
											ss.addSkill(sk);
										}
									}

									c = new Course(prefix, courseCode, courseName);
									c.setSkills(ss);
									ci = new CourseInstance(c, termForCourse);
									ci.setHasLab(hasLab);

									for (int l = 0; l < sectionData.size(); l++) {
										TimeInterval ti;
										WeeklySchedule ws = new WeeklySchedule();
										String tInt = "";

										JSONObject obj2 = (JSONObject) sectionData.get(l);
										String secType = (String) obj2.get("Section Type");
										String secNum = (String) obj2.get("Section Number");
										String insName = (String) obj2.get("Instructor name");
										int currEnroll = Integer.parseInt((String) obj2.get("Current Enrollment"));
										int maxCap = Integer.parseInt((String) obj2.get("Enrollment Cap"));
										String location = (String) obj2.get("Location");
										boolean mtac = (boolean) obj2.get("MTAC");
										int numTA = Integer.parseInt((String) obj2.get("Num of TA"));
										int numLA = Integer.parseInt((String) obj2.get("Num of LA"));
										boolean taAssign = (boolean) obj2.get("TA Assigned");
										JSONArray timeSched = (JSONArray) obj2.get("Time Schedule");

										if (timeSched != null) {
											for (int j = 0; j < timeSched.size(); j++) {
												tInt = timeSched.get(j).toString();
												ti = new TimeInterval(tInt);
												ws.addInterval(ti);
											}
										}

										sec = new Section(secType, secNum, insName, currEnroll, maxCap, location, ws);
										sec.setNumOfTA(numTA);
										sec.setNumOfLA(numLA);
										sec.setTaAssigned(taAssign);
										sec.setMtac(mtac);
										ci.addSection(sec);

									}

									cipl.addCourseInstancetoPool(ci);

								}
							}
						} else {
							System.out.println(COURSES + " folder is empty");
						}
					} else {
						System.out.println("courses folder does not exist in " + termForCourse + " folder.");
					}
				} else {
					System.out.println(termForCourse + " directory does not exist.");
				}
			} else {
				System.out.println("terms directory does not exist.");
			}
		} else {
			System.out.println("taschd directory does not exist.");
		}
		return cipl;
	}

	/**
	 * Stores assignment for respective term
	 * 
	 * @author - anksaini
	 * 
	 * @param assignResult1
	 *            results of the {@link Assignment}
	 * @param termToStore
	 *            The university identifier representing the term or semester
	 *            which this course instance will be offered. It is a user
	 *            entered value.
	 * @param filetoStore
	 *            The results of the assignments will be stored under this .json
	 *            file
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@SuppressWarnings("unchecked")
	public void store(Assignment assignResult1, int termToStore, String fileToStore)
			throws JsonParseException, JsonMappingException, IOException {

		boolean fileExists = false;
		Section s = null;
		TimeInterval ti = null;
		CourseAssistant ca = null;
		Iterator<TimeInterval> iterTime = null;
		JSONObject value = new JSONObject();
		JsonArrayBuilder builder = Json.createArrayBuilder();
		JsonArrayBuilder builderTime = Json.createArrayBuilder();
		JsonArrayBuilder builderCA = Json.createArrayBuilder();
		

		if (taschdCheck()) {
			if (taschdTermFolderCheck()) {
				if (termNumberFolderCheck(termToStore)) {
					if (termNumberAssignmentFolderCheck(termToStore)) {

						File rootDir = new File(directory);
						File taschdDirectory = new File(rootDir, TASCHDDIR);
						File termsDirectory = new File(taschdDirectory, TERMS);
						File termNumberDirectory = new File(termsDirectory, String.valueOf(termToStore));
						File termNumberAssignmentDirectory = new File(termNumberDirectory, ASSIGNMENTS);
						String[] termNumberAssignmentFolder = termNumberAssignmentDirectory.list();

						if (termNumberAssignmentFolder != null) {
							for (int i = 0; i < termNumberAssignmentFolder.length; i++) {
								if (termNumberAssignmentFolder[i].equalsIgnoreCase(fileToStore)) {
									fileExists = true;
									break;
								}
							}
						}
						if (!fileExists) {
							Iterator<Section> iterSec = assignResult1.getSectionsFromAssignment()
									.iterator();
                            
							if (iterSec != null) {
								while (iterSec.hasNext()) {
                                    
									s = iterSec.next();
									//s.display();
									iterTime = s.getSchedule().getSchedule().iterator();
									while (iterTime.hasNext()) {

										ti = iterTime.next();
										builderTime.add(ti.toString());
									}
									JsonArray arrTime = builderTime.build();
             
									Iterator<CourseAssistant> iterCA = assignResult1.getCasForSection(s).iterator();
									//Set<CourseAssistant> setCA = assignResult1.getCasForSection(s);
									//System.out.println(setCA.size());
									if (iterCA !=  null) {
										while (iterCA.hasNext()) {
											//System.out.println("Enough?????????");
											ca = iterCA.next();

											builderCA.add(Json.createObjectBuilder()
													.add("First Name",
															ca.getFirstName() != null ? ca.getFirstName() : "")
													.add("Last Name", ca.getLastName() != null ? ca.getLastName() : "")
													.add("ID", ca.getId()).add("Email",
															ca.getEmailAddress() != null ? ca.getEmailAddress() : ""));
										}
									}

									JsonArray arrCA = builderCA.build();
									builder.add(Json.createObjectBuilder()
											.add("Section Number",
													(s.getSectionNumber() != null ? s.getSectionNumber() : ""))
											.add("Section Type", (s.getSectionType() != null ? s.getSectionType() : ""))
											.add("Instructor name",
													(s.getInstructorName() != null ? s.getInstructorName() : ""))
											.add("Location", (s.getLocation() != null ? s.getLocation() : ""))
											.add("Current Enrollment", (String.valueOf(s.getCurrentEnrollment())))
											.add("Enrollment Cap", (String.valueOf(s.getEnrollmentCap())))
											.add("TA Assigned", (s.isTaAssigned()))
											.add("Num of TA", (String.valueOf(s.getNumOfTA())))
											.add("Num of LA", (String.valueOf(s.getNumOfLA())))
											.add("MTAC", (s.isMtac()))
											.add("Time Schedule", arrTime)
											.add("CA", arrCA));
								}
								JsonArray arrSec = builder.build();
								value.put("Section", arrSec);
							} else {
								value.put("Section", "No section");
								value.put("Course Assistant", "No assignment");
							}
							storeJSON(value, termNumberAssignmentDirectory, fileToStore);
						} else {
							System.out.println("File with name " + fileToStore + " already exists.");
						}
					} else {
						System.out.println("Assignments folder does not exist in " + termToStore + " folder.");
					}
				} else {
					System.out.println(termToStore + " directory does not exist.");
				}
			} else {
				System.out.println("terms directory does not exist.");
			}
		} else {
			System.out.println("taschd directory does not exist.");
		}
	}

}