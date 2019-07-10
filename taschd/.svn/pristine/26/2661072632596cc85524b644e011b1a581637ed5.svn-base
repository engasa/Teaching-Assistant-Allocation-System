package edu.udel.cis.taschd.course;

import edu.udel.cis.taschd.skill.Skill;
import edu.udel.cis.taschd.skill.SkillSet;

import java.util.Objects;

/**
 * <p>
 * The {@link Course} represents static attributes of a {@link Course}. 
 * It specifies the attributes belongs to a {@link Course}. 
 * It hides the details on the internal representation of {@link Course} objects 
 * including offerings in a specific semester.
 * </p>
 * 
 * <p>
 * {@link Course} uses module time and skill.
 * </p>
 *
 * @author matthew
 */
public class Course implements Comparable<Course> {

    /**
     * The university 4-character department identifier that this Course has.
     * For example, "CISC" stands for Computer and Information Science. This is a String
     * consisting of only capital letters.
     */
    private String prefix;

    /**
     * The university 3-digit course identifier that this Course has. This is a String
     * in the range [000,999]. Note that all course codes have leading 0's. For example,
     * 10 represents 010 and 1 represents 001.
     */
    private String courseCode;

    /**
     * The university title identifier that this {@link Course} has. This is an unrestricted
     * proper-case String with no formal naming conventions.
     */
    private String courseName;

    /**
     * The mandatory set of {@link Skill}s that are required in order to assign to {@link Course}.
     */
    private SkillSet skills;

    /**
     * Constructs a new {@link Course} with given prefix, course code, and course name.
     *
     * @param prefix
     *                   the university 4-character department identifier,
     *                   a String consisting of only capital letters.
     * @param courseCode
     *                   the university 3-digit course identifier,
     *                   a String consisting of only digits with leading zeros (0).
     * @param courseName
     *                   the university title identifier,
     *                   a unrestricted proper-case String.
     */
    public Course(String prefix, String courseCode, String courseName) {
        if (prefix.length() != 4 || prefix.matches("[A-Z]"))
            throw new IllegalArgumentException(
                    "the prefix must be a 4-character upper-case String");
        this.prefix = prefix;

        if (courseCode.length() != 3 || courseCode.matches("[0-9]"))
            throw new IllegalArgumentException(
                    "the course code must be a 3-digit String");
        this.courseCode = courseCode;

        this.courseName = courseName;
        this.skills = new SkillSet();
    }

    /**
     * A getter to get the university prefix, represented as a 4-character String.
     *
     * @return the prefix.
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * A getter to get the university course code, represented as a 3-digit String.
     *
     * @return the course code.
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * A getter to get the university course name, represented as a String.
     *
     * @return the course name.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * A getter to get the set of skills required for this course, represented 
     * as a {@link java.util.Set} of {@link Skill}s where each entry is a String.
     *
     * @return skills the Set of required skills.
     */
    public SkillSet getSkills() {
        return skills;
    }

    /**
     * A setter to get the set of {@link Skill}s required for this {@link Course} 
     * initialized, represented as a {@link java.util.Set} of {@link Skill}s 
     * where each entry is a String.
     *
     * @param skills
     *               a set representation of skills as Strings.
     */
    public void setSkills(SkillSet skills) {
        this.skills = skills;
    }

    /**
     * Compares the prefix of this {@link Course} with that one. 
     * Returns -1, 0, or 1 depending on Alphabetical order of the prefix.
     *
     * @param that
     *             another non-{@code null} {@link Course}
     * @return -1 if alphabetical order of prefix at this ahead of prefix of another;
     *         0 if the end prefix are the same;
     *         +1 the other one's prefix is ahead of this one's prefix.
     */
    public int comparePrefix(Course that) {

        int diff = this.getPrefix().compareTo(that.getPrefix());
        if (diff < 0)
            return -1;
        else if (diff == 0)
            return 0;
        else
            return 1;
    }

    /**
     * Compares the course code of this {@link Course} with that one. 
     * Returns -1, 0, or 1 depending on Alphabetical order of the course code.
     *
     * @param that
     *             another non-{@code null} {@link Course}
     * @return -1 if alphabetical order of course code at this ahead of course code of another;
     *         0 if the courseCode are the same;
     *         +1 the other one's courseCode is ahead of this one's course code.
     */
    public int compareCourseCode(Course that) {
        int diff = this.getCourseCode().compareTo(that.getCourseCode());
        if (diff < 0)
            return -1;
        else if (diff == 0)
            return 0;
        else
            return 1;
    }

    /**
     * Compares the course name number of this {@link Course} with that one. 
     * Returns -1, 0, or 1 depending on Alphabetical order of the course name.
     *
     * @param that
     *             another non-{@code null} {@link Course}
     * @return -1 if Id number of this is larger than course name number of that object;
     *         0 if the course name number are the same;
     *         +1 the course name number of this is smaller than course name number of that object.
     */
    public int compareCourseName(Course that) {
        int diff = this.getCourseName().compareTo(that.getCourseName());

        if (diff < 0)
            return -1;
        else if (diff == 0)
            return 0;
        else
            return 1;
    }

    /**
     * Prints the information of this {@link Course} represented as
     * "Prefix CourseCode CourseName Skills".
     */
    public void display() {
    	String prefix = getPrefix(), courseCode = getCourseCode(),
                courseName = getCourseName(), skills = getSkills().toString();
        String result = "------\nCourse Information:\n" + prefix + " " + courseCode + " " + 
                courseName + "\nSkills Required - " + skills;
        
        System.out.println(result);
    }

    /**
     * This method is a override for {@link java.lang.Object#toString()}.
     *
     * @return the formatted "Prefix CourseCode CourseName" String
     */
    @Override
	public String toString() {
    	String prefix = getPrefix(), courseCode = getCourseCode();
        String result = prefix + " " + courseCode;

        return result;
    }

    /**
     * This method is a override for {@link java.lang.Object#equals(Object)}.
     * 
     * @return a boolean value, TRUE if these two objects are equal or in the 
     * second if statement their course coude are the same. FALSE if this object
     * is not Course type or in the second if statement their course codes are 
     * not the same.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof Course) {
            Course that = (Course) obj;

            return this.courseCode == that.courseCode;
        }
        return false;
    }

    /**
     * This method is a override for {@link java.lang.Object#hashCode()}.
     * 
     * @return the hash code of the {@link Course}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getPrefix(), this.getCourseCode(), this.getCourseName(), this.getSkills());
    }

    /**
     * {@inheritDoc}
     *
     * <p>
     * The order is determined by first comparing prefix. If prefix are equal,
     * courseCode is compared to break the tie. If courseCode is equal, courseName
     * is compared to break the tie. If courseName is equal, both course objects are equal.
     * </p>
     */
    @Override
	public int compareTo(Course that) {
        int c = comparePrefix(that);

        if (c != 0) {
            return c;
        }

        c = compareCourseCode(that);

        if (c != 0)
            return c;
        return compareCourseName(that);

    }
}
