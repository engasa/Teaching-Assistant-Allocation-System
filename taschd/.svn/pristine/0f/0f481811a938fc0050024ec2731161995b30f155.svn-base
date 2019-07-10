package edu.udel.cis.taschd.extract;

import java.io.Console;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.stream.Collectors;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableBody;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.gargoylesoftware.htmlunit.javascript.host.event.KeyboardEvent;

import edu.udel.cis.taschd.ca.CourseAssistant;
import edu.udel.cis.taschd.course.Course;
import edu.udel.cis.taschd.course.CourseInstance;
import edu.udel.cis.taschd.course.Section;
import edu.udel.cis.taschd.time.TimeInterval;
import edu.udel.cis.taschd.time.WeeklySchedule;

/**
 * The CAScheduleExtractor class is responsible for extraction of details like
 * CA Schedule, in a specific semester, CAID and
 * {@link CourseInstance}/{@link Section} details are returned. It hides the
 * details of extraction and assigns extracted values to {@link CourseAssistant}
 * and {@link CourseInstance} objects. It also uses {@link WeeklySchedule} class
 * variables.
 * 
 * @author Narasimha Srikumar Akella
 */

public class CAScheduleExtractor {
	private List<Map<String, String>> caScheduleSource = new ArrayList<Map<String, String>>();
	private ArrayList<CourseAssistant> caSchedules;
	boolean twoFactorAuth = false;

	/**
	 * @param source
	 *            Source of extraction (eg. Web)
	 * @param credentials
	 *            User's credentials
	 * @param CAIDs
	 *            CA's student ID
	 * @param term
	 *            Current CA term (eg. 2188, 2193)
	 */
	public CAScheduleExtractor(String source, String[] credentials, int[] CAIDs, String term) {
		java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
		try {
			if (source.equalsIgnoreCase("Web")) {
				if (credentials.length != 2) {
					System.out.println("User Credentials provided is empty");
				} else if (CAIDs.length == 0) {
					System.out.println("CA IDs provided is empty");
				} else if (term.isEmpty()) {
					System.out.println("Term value provided is empty");
				} else {
					ArrayList<CourseAssistant> caSchedule = new ArrayList<CourseAssistant>();
					for (int caIndex = 0; caIndex < CAIDs.length; caIndex++) {
						CourseAssistant caObject = new CourseAssistant(CAIDs[caIndex]);
						caScheduleSource = getCAScheduleWeb(source, credentials, CAIDs[caIndex], term,
								caScheduleSource);
						if (!caScheduleSource.isEmpty()) {
							caSchedule.add(parseAndSetCADetails(caScheduleSource, caObject, Integer.parseInt(term)));
						} else {
							System.out.println("No CA Schedule details extracted for given CA ID Key");
						}
					}
					this.caSchedules = caSchedule;
				}
			} else {
				System.out.println("Source should be Web, only Web extraction is implemented in this phase");
			}
		} catch (FailingHttpStatusCodeException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * The returnCASchedules return the caSchedules as a list of CourseAssistant
	 * Objects
	 * 
	 * @return caSchedules : ArrayList of CourseAssistant Object
	 */
	public ArrayList<CourseAssistant> returnCASchedules() {
		if (caSchedules != null)
			return caSchedules;
		else
			return null;
	}

	/**
	 * The parseAndSetCADetails method takes the list<Map> of caSource extracted
	 * from webreg, parses it and places the values in CourseAssistant class
	 * variables.
	 * 
	 * @param caSource
	 *            : ArrayList of CA details extracted from webreg
	 * @param caObject
	 *            : CourseAssistant Object to which Schedules are added
	 * @param term
	 *            : Current CA term (ex: for Fall 2018, term = 2188)
	 * @return CourseAssistant : CourseAssistant Object with Schedules filled
	 */
	private CourseAssistant parseAndSetCADetails(List<Map<String, String>> caSource, CourseAssistant caObject,
			int term) {
		String currCourse = caSource.get(0).get("courseCode");
		String prevCourse = caSource.get(0).get("courseCode");
		DateFormat dateformat = new SimpleDateFormat("hh:mm a");
		ArrayList<Section> sectionsObject = new ArrayList<Section>();
		Set<CourseInstance> crsEnrolled = new HashSet<CourseInstance>();
		int crsIndex = 0;
		int secIndex = 0;

		for (Iterator<Map<String, String>> iter = caSource.iterator(); iter.hasNext();) {
			String departmentID = caSource.get(crsIndex).get("departmentID");
			String courseCode = caSource.get(crsIndex).get("courseCode");
			String courseName = caSource.get(crsIndex).get("courseName");
			Course crs = new Course(departmentID, courseCode, courseName);

			CourseInstance ci = new CourseInstance(crs, term);

			while (currCourse.equals(prevCourse)) {
				String sectionNumber = caSource.get(secIndex).get("sectionNumber");
				String location = caSource.get(secIndex).get("location");
				String sectionType = caSource.get(secIndex).get("sectionType");
				String instructorName = caSource.get(secIndex).get("instructorName");
				if (sectionType.equals("LAB"))
					ci.setHasLab(true);
				WeeklySchedule weeklySchedule = new WeeklySchedule();
				Set<String> daysSet = caSource.get(secIndex).keySet().stream().filter(s -> s.startsWith("WeekDay"))
						.collect(Collectors.toSet());
				String[] daysArr = daysSet.toArray(new String[daysSet.size()]);

				for (int wtpsIndex = 1; wtpsIndex <= daysArr.length; wtpsIndex++) {
					String tempDayKey = "WeekDay" + wtpsIndex;
					DayOfWeek weekDay = getDayofWeek(caSource.get(secIndex).get(tempDayKey));
					String[] timeInterval = caSource.get(secIndex).get("startTime").split(":");
					int startHour = 0;
					if ((timeInterval[1].contains("AM")) || (Integer.parseInt(timeInterval[0].trim())) == 12) {
						timeInterval[1] = timeInterval[1].replace("AM", "");
						timeInterval[1] = timeInterval[1].replace("PM", "");
						startHour = Integer.parseInt(timeInterval[0].trim());
					} else if ((timeInterval[1].contains("PM")) && (Integer.parseInt(timeInterval[0].trim())) < 12) {
						timeInterval[1] = timeInterval[1].replace("PM", "");
						startHour = Integer.parseInt(timeInterval[0].trim()) + 12;
					}
					int startMin = Integer.parseInt(timeInterval[1].trim());
					Date sTime = null;
					Date eTime = null;
					try {
						String txtsTime = caSource.get(secIndex).get("startTime");
						// .replace("AM", " AM").replace("PM"," PM");
						String txteTime = caSource.get(secIndex).get("endTime");
						// .replace("AM", " AM").replace("PM"," PM");
						sTime = dateformat.parse(txtsTime);
						eTime = dateformat.parse(txteTime);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					int duration = ((int) (eTime.getTime() - sTime.getTime())) / 60000;
					weeklySchedule.addInterval(new TimeInterval(weekDay, startHour, startMin, duration));
				}
				Section section = new Section(sectionType, sectionNumber, instructorName, 0, 0, location,
						weeklySchedule);
				sectionsObject.add(section);
				prevCourse = currCourse;
				iter.next();
				secIndex++;
				crsIndex++;
				ci.addSection(section);
				if (crsIndex < caSource.size()) {
					currCourse = caSource.get(crsIndex).get("courseCode");
				} else
					break;
			}
			crsEnrolled.add(ci);
			prevCourse = currCourse;
			caObject.setCourseEnrolled(crsEnrolled);
		}
		return caObject;
	}

	/**
	 * The getCAScheduleWeb method takes the credentials, term and CAIDs as
	 * arguments and extracts CA schedule from webreg, into a list of maps.
	 * 
	 * @param source
	 *            : Source of Extraction, "Web" for Phase1
	 * @param credentials
	 *            : Credentials as an Array {userName, Password}
	 * @param caID
	 *            : CourseAssistant ID whose Schedule need to be retrieved
	 * @param term
	 *            : Current CA term (ex: for Fall 2018, term = 2188)
	 * @param caScheduleSource
	 *            : Array list of maps with the ca Schedule
	 * @return caScheduleSource : Array list of maps with the ca Schedule
	 */
	private List<Map<String, String>> getCAScheduleWeb(String source, String[] credentials, int CAID, String term,
			List<Map<String, String>> caScheduleSource) {

		try {
			java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
			String userName = credentials[0];
			String Password = credentials[1];
			WebClient webClient = new WebClient();
			HtmlPage page = webClient.getPage("http://www.udel.edu/webreg");
			webClient.getOptions().setJavaScriptEnabled(true);

			HtmlForm loginForm = page.getHtmlElementById("fm1");

			HtmlTextInput userNameInput = loginForm.getInputByName("udelnetid");
			HtmlPasswordInput passwordInput = loginForm.getInputByName("pword");
			HtmlButton loginButton = loginForm.getButtonByName("action");

			userNameInput.type(userName);
			passwordInput.type(Password);

			if (twoFactorAuth == true) {
				HtmlPage targetpage = loginButton.click();
				HtmlForm twoFactorLoginForm = targetpage.getHtmlElementById("fm2");
				HtmlTextInput twoFactorPasscode = twoFactorLoginForm.getInputByName("oathKey");
				HtmlButton twoFactorLogin = twoFactorLoginForm.getButtonByName("action");
				String passcode = "341899";
				twoFactorPasscode.type(passcode);
				HtmlPage studentSchedulePage = twoFactorLogin.click();
				caScheduleSource = getCASchedulefromPage(webClient, studentSchedulePage, term, CAID, caScheduleSource);
				webClient.close();
			} else {
				HtmlPage studentSchedulePage = loginButton.click();
				webClient.waitForBackgroundJavaScript(20000);
				caScheduleSource = getCASchedulefromPage(webClient, studentSchedulePage, term, CAID, caScheduleSource);
				webClient.close();
			}
		} catch (FailingHttpStatusCodeException | IOException e) {
			System.out.println(e.getMessage());
		}
		return caScheduleSource;
	}

	/**
	 * getCASchedulefromPage method extracts the CA Schedule from page after login
	 * 
	 * @param page
	 *            : HtmlPage to extract the CA Schedule from
	 * @param term
	 *            : Current CA term (ex: for Fall 2018, term = 2188)
	 * @param caScheduleSource
	 *            : Array list of maps with the CA Schedule
	 * @return caScheduleSource : Array list of maps with the CA details
	 */
	private List<Map<String, String>> getCASchedulefromPage(WebClient webClient, HtmlPage studentSchedulePage,
			String term, int CAID, List<Map<String, String>> caScheduleSource) {
		try {
			if (twoFactorAuth != true) {
				HtmlTextInput studentIDInput = studentSchedulePage.getElementByName("student");
				studentIDInput.type(CAID);
				// Hit Enter on entering Student ID
				studentIDInput.type(KeyboardEvent.DOM_VK_RETURN);
				webClient.waitForBackgroundJavaScript(3000);

				HtmlSelect termSelect = studentSchedulePage.getElementByName("term");
				termSelect.getOptionByValue(term).setSelected(true);
				termSelect.type(KeyboardEvent.DOM_VK_TAB);
				HtmlButton studentSearchButton = (HtmlButton) studentSchedulePage.getElementById("viewBtn");
				studentSearchButton.click();
				webClient.waitForBackgroundJavaScript(20000);
			} else {
				HtmlSelect termSelect = studentSchedulePage.getElementByName("term");
				termSelect.getOptionByValue(term).setSelected(true);
				termSelect.type(KeyboardEvent.DOM_VK_RETURN);
				termSelect.type(KeyboardEvent.DOM_VK_TAB);
				try {
					TimeUnit.SECONDS.sleep(20);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			HtmlTable studenScheduleTable = studentSchedulePage.getHtmlElementById("footable_schedule");
			int rowIndex, colIndex;

			for (final HtmlTableBody body : studenScheduleTable.getBodies()) {
				final List<HtmlTableRow> rows = body.getRows();
				rowIndex = 0;
				for (final HtmlTableRow row : rows) {
					if (rowIndex != 1) {
						colIndex = 0;
						Map<String, String> temp = new HashMap<String, String>();

						for (final HtmlTableCell cell : row.getCells()) {
							switch (colIndex) {
							case 0:
								String[] sectionDt = cell.asText().trim().split("\\r?\\n");
								String deptID = sectionDt[0].trim().substring(0, 4);
								String courseCode = sectionDt[0].trim().substring(4, 7);
								String sectionNumber = sectionDt[0].trim().substring(7, 10);
								String courseName = sectionDt[1].trim();
								temp.put("departmentID", deptID);
								temp.put("courseCode", courseCode);
								temp.put("courseName", courseName);
								temp.put("sectionNumber", sectionNumber);
								break;
							case 3:
								String tempInst = cell.asText().trim();
								temp.put("instructorName", tempInst);
								break;
							case 4:
								String[] tempSectdt = cell.asText().trim().split("\\r?\\n");
								String[] tempSect = tempSectdt[0].trim().split(" ");
								int numDays = tempSect.length - 7;
								String sectionType = tempSect[0].trim();
								for (int k = 0; k < numDays; k++) {
									String tempDay = tempSect[k + 2].toString().trim();
									temp.put("WeekDay" + (k + 1), tempDay);
								}
								String startTime = tempSect[numDays + 2].trim() + " " + tempSect[numDays + 3].trim();
								String endTime = tempSect[numDays + 5].trim() + " " + tempSect[numDays + 6].trim();
								temp.put("sectionType", sectionType);
								temp.put("startTime", startTime);
								temp.put("endTime", endTime);
								break;
							case 5:
								String location = cell.asText().trim();
								temp.put("location", location);
							default:
								break;
							}
							colIndex++;
						}
						caScheduleSource.add(temp);
					}
					rowIndex++;
				}
			}

		} catch (FailingHttpStatusCodeException | IOException e) {
			System.out.println(e.getMessage());
		}
		return caScheduleSource;
	}

	/**
	 * The getDayofWeek method takes the weekday as Single letter and returns the
	 * corresponding DayofWeek for the letter
	 * 
	 * @param weekDay
	 *            : Single Character representation of week day (eg. M)
	 * @return DayOfWeek : Day of Week enumerator
	 */
	private static DayOfWeek getDayofWeek(String weekday) {
		DayOfWeek weekDay;
		switch (weekday) {
		case "M":
			weekDay = DayOfWeek.valueOf("MONDAY");
			break;
		case "T":
			weekDay = DayOfWeek.valueOf("TUESDAY");
			break;
		case "W":
			weekDay = DayOfWeek.valueOf("WEDNESDAY");
			break;
		case "R":
			weekDay = DayOfWeek.valueOf("THURSDAY");
			break;
		case "F":
			weekDay = DayOfWeek.valueOf("FRIDAY");
			break;
		default:
			weekDay = null;
			break;
		}
		return weekDay;
	}

	/**
	 * This is a driver constructor added to test the class partially, as the full
	 * class can only be tested with Prof.'s credentials. It is used to access some
	 * internal methods to test the class. This can be deleted in production.
	 */
	public CAScheduleExtractor(List<Map<String, String>> caScheduleSource, int CAID, String term) {
		ArrayList<CourseAssistant> caSchedule = new ArrayList<CourseAssistant>();
		CourseAssistant caObject = new CourseAssistant(CAID);
		caSchedule.add(parseAndSetCADetails(caScheduleSource, caObject, Integer.parseInt(term)));
		this.caSchedules = caSchedule;
	}
	
	/*** Main Method written to Test the constructor taking the User password from Console,
	 *  extract and printing the CA Schedule to Console. This can be deleted in production
	 */

	public static void main(String[] args)
			throws FailingHttpStatusCodeException, MalformedURLException, IOException, InterruptedException {

		String source = "Web";
		String[] credentials = new String[2];
		int[] CAIDs = { 702425216 };
		String term = "2193";
		credentials[0] = "srikumar@udel.edu";

		Console console = System.console();
		if (console == null) {
			System.out.println("Couldn't get Console instance");
			System.exit(0);
		}

		char passwordArray[] = console.readPassword("Enter your udel password: ");
		credentials[1] = new String(passwordArray);

		ArrayList<CourseAssistant> caSchedules = new ArrayList<CourseAssistant>();
		CAScheduleExtractor caSchEx = new CAScheduleExtractor(source, credentials, CAIDs, term);
		caSchedules = caSchEx.returnCASchedules();
		if (caSchedules != null) {
			System.out.println(caSchedules.get(0).getId() + " enrolled for "
					+ caSchedules.get(0).getCourseEnrolled().size() + " Courses, below are CourseInstance Objects");
			for (CourseInstance ci : caSchedules.get(0).getCourseEnrolled()) {
				System.out.print(ci.getCourse());
				for (Section se : ci.getSections()) {
					System.out.println(se.getSectionNumber());
					System.out.println(se.getSchedule());
				}
			}
		}
	}
}