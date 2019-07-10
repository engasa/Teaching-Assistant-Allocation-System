package edu.udel.cis.taschd.gen;

import java.util.ArrayList;

import edu.udel.cis.taschd.assign.Assignment;
import edu.udel.cis.taschd.ca.CourseAssistant;
import edu.udel.cis.taschd.ca.CourseAssistantPool;
import edu.udel.cis.taschd.course.Course;
import edu.udel.cis.taschd.course.CourseInstance;
import edu.udel.cis.taschd.course.CourseInstancePool;
import edu.udel.cis.taschd.course.Section;
import edu.udel.cis.taschd.skill.SkillSet;
import edu.udel.cis.taschd.time.WeeklySchedule;

/**
 * Represents a generator tool for a {@link CourseAssistantPool} and a set of
 * {@link CourseInstancePool}s. A course assistant pool is a set of course
 * assistants available for a given term. A course instancePool is a set of
 * courseInstancePool. The assignment result will stored as indexes. The final
 * assignment can be find by search tableMapping using the indexes stored.
 * 
 * @author yiliu
 * 
 */
public class HugarianSolver {
	private CourseAssistantPool cap;
	private CourseInstancePool cip; // course instance pool
	// private CourseAssistantPool leftOver; // courseAssistant who didn't reach to
	// maximum work load;
	// private ArrayList<Section> noCa; //Sections with no ca after first iteration.
	// Because ca is in shortage.

	private ArrayList<ArrayList<Double>> scoreTable;
	private ArrayList<ArrayList<TableInstance>> tableMaping;
	private double[][] tableForHungarian; // double table, it can be used in hungarian method
	private Hungarian hunOpt;
	private int[] result;
	private Assignment assignment;
	int capSize = 0;
	int cipSize = 0;

	/**
	 * Constructs a new {@link HugarianSolver} with given
	 * {@link CourseAssistantPool} and {@link CourseInstancePool};
	 *
	 * @param CourseInstancePool, CourseAssistantPool This score table will obtain
	 *        result of assignment. which is stored in field of result. It is an
	 *        array, the index of the array representing course. and the value of
	 *        that index representing ca.
	 * 
	 *        THIS METHOD CAN ONLY ASSIGN ONE TA TO ONE SECTION. IT CAN NOT ASSIGN
	 *        ONE TA TO MULTIPUL SECTION FOR NOW. MORE CONSTRAIN WILL BE ADDED IN
	 *        THE FUTURE TO ACHEIVE ONE TO MANY ASSGINMENT.
	 */
	public HugarianSolver(CourseAssistantPool cap, CourseInstancePool cip) {
		this.cap = cap;
		this.cip = cip;
		this.capSize = cap.getSize();
		this.cipSize = cip.getSize();
		this.scoreTable = new ArrayList<ArrayList<Double>>();
		this.tableMaping = new ArrayList<ArrayList<TableInstance>>();
		this.tableForHungarian = null;
		this.hunOpt = null;
		this.result = null;
		this.assignment = new Assignment();

	}

	/**
	 * Create a method for filling in the empty "table"
	 * 
	 * @param cou Course object in {@link Course}
	 * @param sec Section object in {@link Section}
	 * @param ca  CourseAssistant object in {@link CourseAssistant}
	 * @return double double arrayList with computed scores for each CA to each
	 *         course
	 * @return it will also return arrayList<ArrayList<TableInstance>> which can
	 *         mapping the score table and store all the information of
	 *         courseAssistant and sections, and course in each table instance;
	 */
	private void fillTable() {

		int i = 0;
		int j = 0;
		double finalScore = 0;
		double skillScore, wtpsScore;
		// double[] temp = new double[capSize];
		ArrayList<ArrayList<Double>> table = new ArrayList<ArrayList<Double>>();
		SkillSet courseSkills;
		WeeklySchedule sectionSchedule;

		for (CourseInstance ci : cip.getCourseInstanceSet()) {

			courseSkills = ci.getCourse().getSkills();

			// int load = 0;
			for (Section sec : ci.getSections()) {
				ArrayList<Double> secCa = new ArrayList<Double>();
				ArrayList<TableInstance> rowTable = new ArrayList<TableInstance>();

				sectionSchedule = sec.getSchedule();
				for (CourseAssistant ca : cap.getCourseAssistantSet()) {
					// System.out.println("-------------matching:");
					// System.out.println("skill");
					// System.out.println(courseSkills.toString());
					// sec.display();
					// System.out.println("-------");
					// ca.display();

					skillScore = courseSkills.skillScore(ca.getPossessedSkillset());

					// System.out.println("sk score:" + skillScore);

					wtpsScore = sectionSchedule.wtpsScore(ca.getWtps());

					// System.out.println("time score:" + wtpsScore);

					if (!sec.isMtac())
						wtpsScore = 1.0; // I think this should be included in wtps score, but deal with it later

					int graduateWeight = 0;
					if (!ca.getGraduateStudent()) {
						int courseCode = Integer.parseInt(ci.getCourse().getCourseCode());
						if (courseCode >= 600) {
							graduateWeight = 10;
						}
					}

					finalScore = 2 - skillScore * wtpsScore + graduateWeight;

					secCa.add(finalScore);

					TableInstance oneEntry = new TableInstance(i, j, ca, sec, ci, finalScore);
					rowTable.add(oneEntry);
					//// The following is a temporary solution
					// when the number of sections is more than courseAssistants.
					// we will double the courseAssisants. which means one courseAssisant will be
					//// assigned to
					// at most 2 more sections
					if (capSize < cipSize) {
						secCa.add(finalScore);
						rowTable.add(oneEntry);
					}
					i++;

					// System.out.println(finalScore);
					// System.out.println("________End Matching___________");

				}

			//	System.out.println(secCa.toString());
				for (int k = 0; k < sec.getNumOfTA(); k++) { /// this can be a problem in the future.
					table.add(secCa);
					tableMaping.add(rowTable);
				}

				i = 0;
				// System.out.println("---------------------------");
			}

		}
		// System.out.println(table.toString());
		int row = table.size();
	
		int col = 0;
		if (row != 0 ) {
			col = table.get(0).size();
		}

		if (row < col) {
			for (int ii = 0; ii < col - row; ii++) {
				ArrayList<Double> ghostSection = new ArrayList<Double>();
				ArrayList<TableInstance> rowTable = new ArrayList<TableInstance>();
				for (int jj = 0; jj < col; jj++) {
					ghostSection.add(0.0);

					TableInstance oneEntry = new TableInstance(0, 0, null, null, null, 0.0);
					rowTable.add(oneEntry);
				}
				table.add(ghostSection);
				tableMaping.add(rowTable);
			}
		}

		if (row > col) {
			for (int ii = 0; ii < row; ii++) {
				for (int jj = 0; jj < row - col; jj++) {
					table.get(ii).add(99999.9);

					TableInstance oneEntry = new TableInstance(0, 0, null, tableMaping.get(ii).get(0).getSec(), null,
							99999.9);
					tableMaping.get(ii).add(oneEntry);
				}
			}

		}
		i++;

		this.scoreTable = table;

	}

//	/**
//	 * Create a method for display the final result This method will take the
//	 * result, and tableMaping. By look into the index stored in result. it will
//	 * print out the final assignment result.
//	 */
//	public void display() {
//		//int count = 1;
//		for (int i = 0; i < result.length; i++) {
//			//CourseInstance courseOne = tableMaping.get(i).get(result[i]).getCourse();
//			Section secOne = tableMaping.get(i).get(result[i]).getSec();
//			CourseAssistant caOne = tableMaping.get(i).get(result[i]).getCa();
//			if (secOne != null && caOne != null) {
//				//System.out.println("Pairing: " + count);
//				// System.out.println("Course:");
//				//courseOne.display();
//				//System.out.println("------------");
//				//System.out.println("Section: ");
//				//secOne.display();
//				// System.out.println("CourseAssistant：");
//				//caOne.display();
//				//System.out.println("---------------");
//				//System.out.println("\n");
//				count++;
//
//			}
//		}
//	}

	/**
	 * public void assign(Section secOne, CourseAssistant caOne) {
	 * assignment.put(secOne, caOne); }
	 * 
	 * A getter to get the score table.
	 *
	 * @return scoreTable.
	 */
	public ArrayList<ArrayList<Double>> getTable() {
		return scoreTable;
	}

	/**
	 * change the type of scoreTable, From Double to double stored in
	 * tableForHungarian
	 */
	private void tableTo2DArray() {
		int a = scoreTable.size();
		double[][] arrayTable = new double[a][a];
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < a; j++) {
				arrayTable[i][j] = scoreTable.get(i).get(j);
			}
		}
		tableForHungarian = arrayTable;
	}

	/**
	 * using tableForHungarian to create a new Hungarian object and save in hunOpt.
	 */
	private void setUpHungarian() {
		this.hunOpt = new Hungarian(tableForHungarian);
	}

	/**
	 * Execute hungarian method on hunOpt object. and store the output in result
	 * field.
	 */
	private void calculateResult() {
		this.result = hunOpt.execute();
	}

	/**
	 * A getter to get the Result.
	 *
	 * @return result.
	 */
	public int[] getResult() {
		return result;
	}

	/**
	 * A getter to get the tableForHungarian.
	 *
	 * @return tableForHungarian.
	 */
	public double[][] getTableForHungarian() {
		return tableForHungarian;
	}

	/**
	 * A getter to get the hunOpt.
	 *
	 * @return hunOpt.
	 */
	public Hungarian getHunOpt() {
		return hunOpt;
	}

	/**
	 * A getter to get the cap.
	 *
	 * @return cap.
	 */
	public CourseAssistantPool getCap() {
		return cap;
	}

	/**
	 * A getter to get the Cip.
	 *
	 * @return Cip.
	 */
	public CourseInstancePool getCip() {
		return cip;
	}

	/**
	 * A getter to get the ScoreTable.
	 *
	 * @return ScoreTable.
	 */
	public ArrayList<ArrayList<Double>> getScoreTable() {
		return scoreTable;
	}

	/**
	 * A getter to get the TableMaping.
	 *
	 * @return TableMaping.
	 */
	public ArrayList<ArrayList<TableInstance>> getTableMaping() {
		return tableMaping;
	}

	/**
	 * A getter to get the capSize.
	 *
	 * @return capSize.
	 */
	public int getCapSize() {
		return capSize;
	}

	/**
	 * A getter to get the cipSize.
	 *
	 * @return cipSize.
	 */
	public int getCipSize() {
		return cipSize;
	}

	/**
	 * This method will store the final assignment as a hashMap in assignment.
	 */
	private void tempAssign() {
		// int count = 1;
		for (int i = 0; i < result.length; i++) {
			// CourseInstance courseOne = tableMaping.get(i).get(result[i]).getCourse();
			Section secOne = tableMaping.get(i).get(result[i]).getSec();
			CourseAssistant caOne = tableMaping.get(i).get(result[i]).getCa();
			CourseInstance c = tableMaping.get(i).get(result[i]).getCourse();
			if (secOne != null && caOne != null) {

				
				////I know it is not efficient. but time is limited, Improve it in the 
				// future --12.16
				    for (CourseInstance tmpci : cip.getCourseInstanceSet()) {
				    	
				    		for (Section tmpSec : tmpci.getSections()) {
				    			if (secOne.getSectionNumber() == tmpSec.getSectionNumber() && (c.getCourse().getCourseCode() == tmpci.getCourse().getCourseCode()) ) {
				    				for (CourseAssistant tmpca : cap.getCourseAssistantSet()) {
				    					if (tmpca.getId() == caOne.getId()) {
				    						tmpSec.addAssignedCourseAssistant(tmpca);
				    						tmpSec.setTaAssigned(true);
				    						//assignment.setCaForSection(tmpSec, tmpca);
				    					}
				    				}
				    			}
				    		}
				    }
			}
		}
	}

	/**
	 * This method will get the assignment;
	 */
	public Assignment getAssignment() {
		return assignment;
	}
	
	/**
	 * This method is responsible for returning the assignment based on the
	 * {@link #setUpHungarian()} method, which model the problem into 
	 * Linear programming solution.
	 * For each {@link Section} in each {@link CourseInstance}, it will give the assignment.
	 * Finally, it returns a {@link Assignment} as the assignment.
	 * 
	 * @return a {@link Assignment} representing the final assignment.
	 */
	public Assignment assign() {
		// this.leftOver = null;

		this.fillTable(); // fille the score table.
		this.tableTo2DArray(); // turn the score table to 2D array with double type.
								// set up the value of tableForHungarian.
		if (scoreTable.size()!= 0) {
			this.setUpHungarian(); // set up hunOpt
			this.calculateResult(); // set up the result.
			this.tempAssign();
		
			for (CourseInstance ci : this.cip.getCourseInstanceSet()) {

				for (Section sec : ci.getSections()) {

					if (sec.isTaAssigned()) {

						for (CourseAssistant ca : sec.getAssignedCourseAssistants())
							assignment.setCaForSection(sec, ca);
					}
				}
			}
		}

		return assignment;
	}
}

//////////////////////////	
//	public void manualAssign(CourseAssistant ca, Section sec) {

//	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
//	public void keepAssign() {		
//		int count = 1;
//		for (int i =0; i <= result.length; i++) {
//			CourseInstance courseOne = tableMaping.get(i).get(result[i]).getCourse();
//			Section secOne = tableMaping.get(i).get(result[i]).getSec();
//			CourseAssistant caOne = tableMaping.get(i).get(result[i]).getCa();
//			if (secOne != null && caOne != null) {
//				secOne.addAssignedCourseAssistant(caOne);
//				int currLoad = caOne.getCourseLoad();
//				currLoad =+ secOne.getEnrollmentCap();
//				                                       //this should be fix in the future, because the courseLoad changes 
//                                                       // for different courses
//				if (currLoad < caOne.getCourseLoad()) {
//					leftOver.addCourseAssistant(caOne);	
//				}
//				System.out.println("Pairing: " + count);
//				//System.out.println("Course:");
//				courseOne.display();
//				System.out.println("------------");
//				System.out.println("Section: ");
//				secOne.display();
//				//System.out.println("CourseAssistant：");
//				caOne.display();
//				System.out.println("---------------");
//				System.out.println("\n");
//				count ++;			
//			}
//		    if (SecOne != null) {
//			
//		}
//	}
