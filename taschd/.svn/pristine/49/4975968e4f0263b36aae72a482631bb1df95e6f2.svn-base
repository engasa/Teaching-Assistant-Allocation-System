package edu.udel.cis.taschd.course;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * <p>
 * The {@link CourseInstance} represents an instance of a {@link Course} within
 * a given term or semester. A {@link Course} does not keep same for every term.
 * Given that, {@link CourseInstance}s instantiate when a given course is being
 * offered. Examples include Fall 2018 CISC 675 which is a
 * {@link CourseInstance} of the CISC 675 {@link Course}.
 * </p>
 * 
 * <p>
 * {@link CourseInstance} is an instance of a {@link Course}, which contains all
 * courses in the university.
 * </p>
 * 
 * @author matthew
 */
public class CourseInstance {

	/**
	 * The {@link Course} object that this {@link CourseInstance} references. For
	 * example, CISC 675 Software Engineering. This is a Course object consisting of
	 * prefix, courseCode, courseName, and skills attributes.
	 */
	private Course course;

	/**
	 * The identifier that this {@link CourseInstance} requires a lab section. This
	 * is a boolean where TRUE indicates that the {@link CourseInstance} does have a
	 * lab section and FALSE indicates that the {@link CourseInstance} does not have
	 * a lab section.
	 */
	private boolean hasLab;

	/**
	 * The sequence of sections. They are unordered. The ordering is predetermined
	 * by the university. It is predefined such that course information is gathered
	 * from the course registration website (WebReg) and within that information,
	 * the university defines the location and teachers for each
	 * {@link CourseInstance}'s sections such that there is never any overlap.
	 *
	 */
	private ArrayList<Section> sections;

	/**
	 * The university identifier representing the term or semester which this course
	 * instance will be offered. This is an integer with an unbounded range.
	 */
	private int term;

	/**
	 * Constructs a new {@link CourseInstance} with given {@link Course} and term.
	 *
	 * @param course the {@link Course} at which this {@link CourseInstance}
	 *               references.
	 * @param term   the term (semester) at which this {@link CourseInstance} is
	 *               offered, identified as an integer with an unbounded range.
	 */
	public CourseInstance(Course course, int term) {
		this.course = course;
		this.hasLab = false;
		this.sections = new ArrayList<>();
		this.term = term;
	}

	/**
	 * Gets the {@link Course}, represented as Course object consisting of prefix,
	 * courseCode, courseName, and skills attributes.
	 *
	 * @return the course corresponding with this {@link CourseInstance}.
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * A getter to get the hasLab attribute initialized, represented as a boolean
	 * value where TRUE indicates that the {@link CourseInstance} does have a lab
	 * section and FALSE indicates that the {@link CourseInstance} does not have a
	 * lab section.
	 *
	 * @return True if {@link CourseInstance} has lab, False if
	 *         {@link CourseInstance} does not have lab.
	 */
	public boolean isHasLab() {
		return hasLab;
	}

	/**
	 * A setter to get the hasLab attribute for this {@link CourseInstance}
	 * initialized, represented as a boolean.
	 *
	 * @param hasLab a boolean represented as TRUE if the {@link CourseInstance} has
	 *               Lab.
	 */
	public void setHasLab(boolean hasLab) {
		this.hasLab = hasLab;
	}

	/**
	 * A getter to get the term initialized, represented as an integer of unbounded
	 * range.
	 *
	 * @return the term.
	 */
	public int getTerm() {
		return term;
	}

	/**
	 * Gets the sections as an iterable sequence of {@link Section}s.
	 *
	 * @return the sections associated with this course instance.
	 */
	public Iterable<Section> getSections() {
		return sections;
	}

	/**
	 * Adds a {@link Section} to this {@link CourseInstance}. If the given
	 * {@link Section} is already in this {@link CourseInstance}, this is a no-op.
	 *
	 * @param sec a non-{@code null} {@link Section} to add to this
	 *            {@link CourseInstance}.
	 */
	public void addSection(Section sec) {
		// A simple linear-time insertion.
		// These lists are expected to be very small, therefore it is
		// a feasible solution.
		ListIterator<Section> iter = sections.listIterator();

		while (iter.hasNext()) {
			Section y = iter.next();
			int c = sec.compareTo(y);

			if (c > 0) // ti goes after y
				continue;
			if (c == 0)
				return;
			// ... x y z ...
			// y is the first item in list that comes after sec. You want to
			// insert just before y.
			iter.previous();
			break;
		}
		iter.add(sec);
	}

	/**
	 * Returns a human-readable representation of this {@link CourseInstance}, in
	 * the form "Prefix CourseCode CourseName".
	 *
	 * @return the formatted "Prefix CourseCode CourseName Sections" String
	 */
	@Override
	public String toString() {
		String course = getCourse().toString(), section = "";
		for (Section s : sections) {
			section += " " + s.getSectionNumber() + s.getSectionType();
		}
		String result = course + " -" + section;

		return result;
	}

	/**
	 * Displays all the {@link Section}s information in this term.
	 */
	public void display() {
		getCourse().display();
		System.out.println("\nSection Information (Term " + getTerm() + "):");
		for (Section s : getSections())
			s.display();
	}

}
