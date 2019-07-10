package edu.udel.cis.taschd.gen;

import edu.udel.cis.taschd.ca.CourseAssistant;
import edu.udel.cis.taschd.course.Section;
import edu.udel.cis.taschd.course.CourseInstance;

/**
 * TableInstance is an object for storing information for a
 * {@link HugarianSolver} Each store table will store the information of
 * {@link CourseAssistant} {@link CourseInstance} {@link Section} and rows and
 * columns in the ScoreTable By using this table, we can quick access result in
 * {@link HugarianSolver} and {@link LPSolver} for example:
 * {@link HugarianSolver} {@link LPSolver} will give a final result of indexes.
 * We can obtaining the pairing section and course assistance by using indexes
 * and tableInstance.
 * 
 * @author Yi liu
 */
public class TableInstance {
	
	/**
	 * column number of the instance in the {@link scoreTable}
	 */
	private int col; // column in the score table
	
	/**
	 * row number of the instance in the {@link scoreTable}
	 */
	private int row; // row in score table
	
	/**
	 *  the {@link CourseAssistant} in this {@link TableInstance} 
	 */
	private CourseAssistant ca; // which CourseAssistant is the column representing
	
	/**
	 *  the {@link Section} in this {@link TableInstance} 
	 */
	private Section sec; // which Section is the row representing
	
	/**
	 *  the {@link CourseInstance} in this {@link TableInstance} 
	 *  the {@link Section} is under this {@link Course}
	 *  This attribute is not necessary if there is a attribute
	 *  of corresponding{@link Course} in {@link Section}
	 *  
	 */
	private CourseInstance course; // which course is this cell representing
	
	/**
	 *  the score of {@link CourseAssistant} and {@link Section}
	 *  In {@link LPSolver} the score will be 1 or -1 if 
	 *  the {@link CourseAssistant} is qualified for the {@link Section}
	 *  the score will be 1;
	 */
	private double score; // the score of this CourseAssistant and this Section
	
	/**
	 *  the score of {@link CourseAssistant} and {@link Section}
	 *  If {@link LPSolver} decide 
	 *  to assign the {@link CourseAssistant} to the {@link Section}
	 *  the flag will be 1; or it will be 0;
	 */
	private double flag;


	/**
	 * Constructs a new {@link TableInstance} objects with given row number, column
	 * number, courseAssistant, course, score.
	 * 
	 * 
	 * @param row             a integer which representing the row number in
	 *                        {@link HugarianSolver}.
	 * @param col             a integer which representing the row number in
	 *                        {@link HugarianSolver}.
	 * 
	 * @param CourseAssistant a courseAsssistant for pairing
	 *                        {@link CourseAssistant}.
	 * @param Section         a Section for pairing {@link Section}.
	 * @param CourseInstance  the course instance of the section
	 *                        {@link CourseInstance}.
	 * @param                 double a double which is the score/cost/weight to
	 *                        assessing the section pairing with the
	 *                        courseAssisstant .
	 */
	public TableInstance(int row, int col, CourseAssistant ca, Section sec, CourseInstance course, double score) {
		this.col = col;
		this.row = row;
		this.ca = ca;
		this.sec = sec;
		this.course = course;
		this.score = score;
		this.flag = 0;

	}
	
	/**
	 * A getter to get the flag.
	 * Flag is the final decision of weather of not
	 * Assgin the ta to the section;
	 *
	 * @return flag.
	 */
	public double getFlag() {
		return flag;
	}
	
	/**
	 * This will be called in constrain solvers. 
	 * Once the constrian sovlers have determined the Ta
	 * will be assign to the section.
	 * Flag will be set to one.
	 *
	 * @param flag
	 */
	public void setFlag(double flag) {
		this.flag = flag;
	}

	/**
	 * This will be called to save the score of matching between
	 * TA and sections;
	 *
	 * @param score
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * A getter to get the course.
	 *
	 * @return course.
	 */
	public CourseInstance getCourse() {
		return course;
	}

	/**
	 * A getter to get the column.
	 *
	 * @return col.
	 */
	public int getCol() {
		return col;
	}

	/**
	 * A getter to get the row.
	 *
	 * @return row.
	 */
	public int getRow() {
		return row;
	}

	/**
	 * A getter to get the CourseAssistant.
	 *
	 * @return CourseAssistant.
	 */
	public CourseAssistant getCa() {
		return ca;
	}

	/**
	 * A getter to get the Section.
	 *
	 * @return Section.
	 */
	public Section getSec() {
		return sec;
	}

	/**
	 * A getter to get the score.
	 *
	 * @return score.
	 */
	public double getScore() {
		return score;
	}

}