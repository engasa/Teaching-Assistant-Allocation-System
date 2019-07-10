package edu.udel.cis.taschd.ca;

import java.util.Objects;
import java.util.Set;

import edu.udel.cis.taschd.course.CourseInstance;
import edu.udel.cis.taschd.skill.SkillSet;
import edu.udel.cis.taschd.time.WeeklySchedule;

/**
 * <p>
 * An {@link CourseAssistant} class is responsible for the representation of
 * {@link CourseAssitant} and attributes of {@link CourseAssistant}. It hides
 * the details on the internal representation of courseAssistant objects.
 * Methods to construct course assistants, get and compare detailed properties
 * of {@link CourseAssistant}.
 * 
 * </p>
 * 
 * 
 * 
 * <p>
 * {@link CoursesAssistant} uses modules time and skill.
 * </p>
 * 
 * @author Yi Liu
 */
public class CourseAssistant implements Comparable<CourseAssistant> {
	/**
	 * This variable represents the student's first name. For example, "David".
	 */
	private String firstName;

	/**
	 * This variable represents the student's first name. For example, "Young".
	 */
	private String lastName;

	/**
	 * This variable represents the student's id number. For example,
	 * "702147592" which is a 9-digit value.
	 */
	private int id;

	/**
	 * This variable represents the student's email address. For example,
	 * "dYoung@udel.edu".
	 */
	private String emailAddress;

	/**
	 * This variable represents the skills that the student has. For example,
	 * "Java, Python, C#, assembly language".
	 */
	private SkillSet possessedSkillset;

	/**
	 * This variable represents the student's enrolled courses. For example,
	 * "CISC 675 Software Engineering".
	 */
	private Set<CourseInstance> courseEnrolled;

	/**
	 * This variable represents Whether a student is a graduate student or not.
	 * TRUE if the student is a graduate student.
	 */
	private boolean graduateStudent;

	/**
	 * This variable represents the student's schedule. For example, "MWF
	 * 9:00-9:45".
	 */
	private WeeklySchedule wtps;

	/**
	 * This variable represents the student's course load. It should be the
	 * maximum number of workload that a student can take.
	 */
	private int courseLoad;

	/**
	 * Constructs a new {@link CourseAssistant} objects with a given {@code ID}.
	 * 
	 * @param id
	 *            a non-{@code null} ID of a {@link CourseAssitant}.
	 */
	public CourseAssistant(int id) {
		this.firstName = null;
		this.lastName = null;
		this.id = id;
		this.emailAddress = null;
		this.possessedSkillset = new SkillSet();
		this.graduateStudent = true;
		this.wtps = new WeeklySchedule();
		this.courseEnrolled = null;
		this.courseLoad = 0;
	}

	/**
	 * A getter to get the {@link Course}s that the student enrolled.
	 * 
	 * @return an array of {@link Course}s that the student enrolled.
	 */
	public Set<CourseInstance> getCourseEnrolled() {
		
		return courseEnrolled;
	}

	/**
	 * A setter to make enrolled courses in {@link #getCourseEnrolled()}
	 * initialized.
	 * 
	 * @param sectionEnrooled
	 *            An array of non-{@code null} {@link Course}s that the student
	 *            enrolled.
	 */
	public void setCourseEnrolled(Set<CourseInstance> courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}

	/**
	 * A getter to get the {@link CourseAssistant}'s first name.
	 * 
	 * @return a {@link CourseAssistant}'s first name.
	 */
	public String getFirstName() {
		
		return firstName;
	}

	/**
	 * A setter to get the {@link CourseAssistant}'s first name initialized.
	 * 
	 * @param firstName
	 *            a non-{@code null} {@link CourseAssistant}'s firstName.
	 */
	public void setFirstName(String firstName) {
		
		this.firstName = firstName;
	}

	/**
	 * A getter to get the {@link CourseAssistant}'s last name.
	 * 
	 * @return a {@link CourseAssistant}'s last name.
	 */
	public String getLastName() {
		
		return lastName;
	}

	/**
	 * A setter to get the {@link CourseAssistant}'s last name initialized.
	 * 
	 * @param lastName
	 *            a non-{@code null} {@link CourseAssistant}'s last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * A getter to get the {@link CourseAssistant}'s ID.
	 * 
	 * @return a {@link CourseAssistant}'s ID.
	 */
	public int getId() {
		return id;
	}

	/**
	 * A getter to get the {@link CourseAssistant}'s email address.
	 * 
	 * @return a {@link CourseAssistant}'s email address.
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * A setter to get the {@link CourseAssistant}'s email address initialized.
	 * 
	 * @param emailAddress
	 *            a non-{@code null} {@link CourseAssistant}'s email address.
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * A getter to get the {@link CourseAssistant}'s skill {@link Set}.
	 * 
	 * @return a set of skills possessed by a {@link CourseAssistant}.
	 */
	public SkillSet getPossessedSkillset() {
		return possessedSkillset;
	}

	/**
	 * A setter to set the {@link CourseAssistant}'s skill {@link Set}
	 * initialized.
	 * 
	 * @param possessedSkillset
	 *            a {@link Set} of skills possessed by a non-{@code null}
	 *            {@link CourseAssistant}.
	 */
	public void setPossessedSkillset(SkillSet possessedSkillset) {
		this.possessedSkillset = possessedSkillset;
	}

	/**
	 * A getter to get whether a {@link CourseAssistant} is a graduate student
	 * or not.
	 * 
	 * @return a {@link CourseAssisstant} is a graduate or not.
	 */
	public boolean getGraduateStudent() {
		return this.graduateStudent;
	}

	/**
	 * A setter to get the {@link CourseAssistant}'s education level
	 * initialized.
	 * 
	 * @param graduateStudent
	 *            a non-{@code null} {@link CourseAssistant} is a graduate
	 *            student or not.
	 */
	public void setGraduateStudent(boolean graduateStudent) {
		this.graduateStudent = graduateStudent;
	}

	/**
	 * A getter to get the {@link CourseAssistant}'s weekly time schedule.
	 * 
	 * @return a {@link CourseAssistant}'s time schedule.
	 */
	public WeeklySchedule getWtps() {
		return wtps;
	}

	/**
	 * A setter to get the {@link CourseAssistant}'s weekly time schedule
	 * initialized.
	 * 
	 * @param wtps
	 *            a non-{@code null} {@link CourseAssistant}'s time schedule.
	 */
	public void setWtps(WeeklySchedule wtps) {
		this.wtps = wtps;
	}

	/**
	 * A getter to get the {@link CourseAssistant}'s courseLoad.
	 * 
	 * @return a {@link CourseAssistant}'s courseLoad.
	 */
	public int getCourseLoad() {
		return courseLoad;
	}

	/**
	 * A setter to set the {@link CourseAssistant}'s courseLoad.
	 * 
	 * @return a {@link CourseAssistant}'s courseLoad.
	 */
	public void setCourseLoad(int courseLoad) {
		this.courseLoad = courseLoad;
	}

	/**
	 * Compares the last name of this {@link CourseAssistant} with that one.
	 * Returns -1, 0, or 1 depending on Alphabetical order of the last name.
	 * 
	 * @param that
	 *            another non-{@code null} {@link CourseAssistant}.
	 * 
	 * @return -1 if alphabetical order of last name at this ahead of last name
	 *         of another; 0 if the end last name are the same; +1 the other
	 *         one's lastName is ahead of this one's last name.
	 */
	public int compareLastName(CourseAssistant that) {
		int diff = this.getLastName().compareTo(that.getLastName());
		if (diff < 0)
			return -1;
		else if (diff == 0)
			return 0;
		else
			return 1;
	}

	/**
	 * Compares the first name of this {@link CourseAssistant} with that one.
	 * Returns -1, 0, or 1 depending on Alphabetical order of the first name.
	 * 
	 * @param that
	 *            another non-{@code null} {@link CourseAssistant}.
	 * 
	 * @return -1 if alphabetical order of first name at this ahead of first
	 *         name of another; 0 if the first name are the same; +1 the other
	 *         one's first name is ahead of this one's first name.
	 */
	public int compareFirstName(CourseAssistant that) {
		int diff = this.getFirstName().compareTo(that.getFirstName());
		if (diff < 0)
			return -1;
		else if (diff == 0)
			return 0;
		else
			return 1;
	}

	/**
	 * Compares the Id number of this {@link CourseAssistant} with that one.
	 * Returns -1, 0, or 1 depending on the Id.
	 * 
	 * @param that
	 *            another non-{@code null} {@link CourseAssistant}.
	 * 
	 * @return -1 if Id number of this is larger than Id number of that object;
	 *         0 if the Id number are the same; +1 the Id number of this is
	 *         smaller than Id number of that object.
	 */
	public int compareId(CourseAssistant that) {
		int diff = this.getId() - that.getId();

		if (diff < 0)
			return -1;
		else if (diff == 0)
			return 0;
		else
			return 1;
	}

	/**
	 * Provides a human-readable representation of this {@link CourseAssistant},
	 * in the form of "FirstName, LastName, Id, emailAddress".
	 * 
	 * @return a {@link String} representing a {@link CourseAssistant}.
	 */
	public String toString() {
		String firstName = getFirstName(), lastName = getLastName();
		int id = getId();
		String result = lastName + ", ";

		result += firstName + " (" + id + ")";
		return result;
	}

	/**
	 * Prints the information of this {@link CourseAssistant}, in the form of
	 * "FirstName, LastName, Id, emailAddress".
	 */
	public void display() {
		String firstName = getFirstName(), lastName = getLastName(), skills = getPossessedSkillset().toString(),
				schedule = getWtps().toString(), email = getEmailAddress().toString();

		int load = getCourseLoad(), id = getId();
		
		String line1 = "Name: ", line2 = "\nID #: ", line3 = "\nEmail:", line4 = "\nSchedule: ",
				line5 = "\nSkills: ", line6 = "\nLoad: ";

		System.out.printf("------\n%-10s" + firstName + " " + lastName + "%-11s" + id + "%-11s" + email + "%-11s" + schedule
				+ "%-11s" + skills + "%-11s" + load + "\n", line1, line2, line3, line4, line5, line6);

	}

	/**
	 * This method is a override for {@link java.lang.Object#equals(Object)}.
	 * 
	 * @return a boolean value, TRUE if these two objects are equal or in the
	 *         second if statement their IDs are the same, FALSE if this object
	 *         is not CourseAssistant type or their IDs are not the same.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof CourseAssistant) {
			CourseAssistant that = (CourseAssistant) obj;

			return this.id == that.id;
		}
		return false;
	}

	/**
	 * This method is a override for {@link java.lang.Object#hashCode()}.
	 * 
	 * @return an int value for the id's hash code.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * <p>
	 * The order is determined by first comparing lastName. If LastName are
	 * equal, the fisrtNames are used to break the tie. If firstName are equal,
	 * the Id are used to break the tie.
	 * </p>
	 */
	@Override
	public int compareTo(CourseAssistant that) {
		int c = compareLastName(that);
		if (c != 0) {
			return c;
		} else {
			c = compareFirstName(that);
		}
		if (c != 0)
			return c;
		return compareId(that);

	}

	@Deprecated
	public void setCourseEnrolled(CourseInstance[] crsEnrolled) {
		// TODO Auto-generated method stub

	}

}
