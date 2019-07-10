package edu.udel.cis.taschd.userinterface;

import java.io.File;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import edu.udel.cis.taschd.userinterface.UserInterface;

public class UserInterfaceTest {

	private UserInterface obj1 = new UserInterface();

	// get Current directory of user
	static String directory = System.getProperty("user.dir");
	File rootDir = new File(directory);
	// file name taschd_dir in current directory
	File taschdDirectory = new File(rootDir, "taschd_dir");
	static String course = "courses";
	static String caPool = "ca_pool";
	static String term = "2188";
	static String assistants = "assistants";
	static String assignments = "assignments";
	static String termToAdd = "2188";

	@Test
	public void testInit() throws IOException {
		// call init()

		obj1.init();
		String[] rootFolder = rootDir.list();
		String[] taschdFolders = taschdDirectory.list();
		boolean taschdExists = false;
		boolean termExists = false;
		boolean courseExists = false;
		boolean caPoolExists = false;
		// check if taschd_dir is created
		if (rootFolder != null) {
			for (int i = 0; i < rootFolder.length; i++) {
				if (rootFolder[i].equalsIgnoreCase("taschd_dir")) {
					taschdExists = true;
					break;
				}
			}
		}
		// check if terms, courses, ca_pool are created
		if (taschdExists && taschdFolders != null) {
			for (int i = 0; i < taschdFolders.length; i++) {
				if (taschdFolders[i].equalsIgnoreCase(term)) {
					termExists = true;
				} else if (taschdFolders[i].equalsIgnoreCase(course)) {
					courseExists = true;
				} else if (taschdFolders[i].equalsIgnoreCase(caPool)) {
					caPoolExists = true;
				}
			}
		}
		// delete taschd_dir, courses, ca_pool, terms if all exist
		if (taschdExists && termExists && courseExists && caPoolExists) {
			deleteFolder(taschdDirectory);
			taschdExists = termExists = courseExists = caPoolExists = false;
		}
	}

	public boolean deleteFolder(File file) {
		File[] allContents = file.listFiles();
		if (allContents != null) {
			for (File f : allContents) {
				deleteFolder(f);
			}
		}
		return file.delete();
	}

	@Test
	public void testAddSem() {
		obj1.addTerm(termToAdd);
		String[] rootFolder = rootDir.list();
		String[] taschdFolders = taschdDirectory.list();
		File termsDirectory = new File(taschdDirectory, "terms");
		String[] termsFolders = termsDirectory.list();
		File addedSemDirectory = new File(termsDirectory, termToAdd);
		String[] addedSemFolders = addedSemDirectory.list();
		boolean taschdExists = false;
		boolean termExists = false;
		boolean addedTermExists = false;
		boolean courseAddExists = false;
		boolean assignmentsAddExists = false;
		boolean assistantsAddExists = false;

		// check if taschd_dir is created
		if (rootFolder != null) {
			for (int j = 0; j < rootFolder.length; j++) {
				if (rootFolder[j].equalsIgnoreCase("taschd_dir")) {
					taschdExists = true;
					break;
				}
			}
		}
		// check if terms is created
		if (taschdExists && taschdFolders != null) {
			for (int k = 0; k < taschdFolders.length; k++) {
				if (taschdFolders[k].equalsIgnoreCase(term)) {
					termExists = true;
					break;
				}
			}
		}
		// check if terms is created
		if (termExists && termsFolders != null) {
			for (int l = 0; l < termsFolders.length; l++) {
				if (termsFolders[l].equalsIgnoreCase(termToAdd)) {
					addedTermExists = true;
					break;
				}
			}
		}

		// check if terms is created
		if (addedTermExists && addedSemFolders != null) {
			for (int m = 0; m < addedSemFolders.length; m++) {
				if (addedSemFolders[m].equalsIgnoreCase(course)) {
					courseAddExists = true;
				} else if (addedSemFolders[m].equalsIgnoreCase(assignments)) {
					assignmentsAddExists = true;
				} else if (addedSemFolders[m].equalsIgnoreCase(assistants)) {
					assistantsAddExists = true;
				}
			}
		}

		// delete taschd_dir, courses, ca_pool, terms if all exist
		if (taschdExists && termExists && assistantsAddExists && assignmentsAddExists && courseAddExists) {
			deleteFolder(taschdDirectory);
			taschdExists = termExists = courseAddExists = assignmentsAddExists = assistantsAddExists = false;
		}

	}

	static String source = "Web";
	static String courseKey = "CISC675";
	static String fileToStore = courseKey + ".json";

	@Test
	public void testgetCourseFromWebRegStatic() throws JsonParseException, JsonMappingException, IOException, ParseException {
		obj1.getCourseFromWebReg(source, courseKey, term);
		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, "taschd_dir");
		File courseDirectory = new File(taschdDirectory, "courses");
		String[] coursesFolder = courseDirectory.list();
		if (coursesFolder != null) {
			for (int i = 0; i < coursesFolder.length; i++) {
				if (coursesFolder[i].equalsIgnoreCase(fileToStore)) {
					System.out.println("Store successful of static " + fileToStore + " to database");
					break;
				}
			}
		}
	}

	@Test
	public void testgetCourseFromWebRegDynamic() throws JsonParseException, JsonMappingException, IOException, ParseException {
		obj1.getCourseFromWebReg(source, courseKey, term);
		File rootDir = new File(directory);
		File taschdDirectory = new File(rootDir, "taschd_dir");
		File termsDirectory = new File(taschdDirectory, "terms");
		File termNumberDirectory = new File(termsDirectory, term);
		File termNumberCourseDirectory = new File(termNumberDirectory, "courses");
		String[] termNumberCourseFolder = termNumberCourseDirectory.list();
		if (termNumberCourseFolder != null) {
			for (int i = 0; i < termNumberCourseFolder.length; i++) {
				if (termNumberCourseFolder[i].equalsIgnoreCase(fileToStore)) {
					System.out.println("Store successful of dynamic " + fileToStore + " to database");
					break;
				}
			}
		}
	}

}
