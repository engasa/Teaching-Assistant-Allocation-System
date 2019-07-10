package edu.udel.cis.taschd.course;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

import edu.udel.cis.taschd.ca.CourseAssistant;


/**
 * <p>
 * The {@link CourseInstancePool} class is responsible for managing {@link CourseInstance} Objects
 * e.g., obtaining all {@link CourseInstance}s as a list. It hides the details on the internal
 * representation of course instance objects.
 * </p>
 * 
 * <p>
 * {@link CourseInstancePool} is a {@link Collection} of {@link CourseInstance}s.
 * </p>
 * 
 * @author matthew
 */
public class CourseInstancePool {
	/**
	 * The sequence of {@link CourseInstance}s. They are ordered by prefix, course code, 
	 * and course number. The ordered is determined by the method {@link CourseInstance#compareTo(CourseInstance)}
	 * If prefix's are equal, the course codes are used to break the tie. If course code's are equal,
	 * the course numbers are used to break the tie.
	 */
	private ArrayList<CourseInstance> courseInstancePool;
	
	/**
	 * Constructs a new {@link CourseInstancePool} from the given collection of
	 * {@link CourseInstance}s. The new {@link CourseInstancePool} will not keep any
	 * reference to the given {@link Collection}, hence subsequent modifications
	 * to the collection will not affect the new {@link CourseInstancePool}. 
	 * The new {@link CourseInstancePool} may keep references to the member 
	 * {@link CourseInstance}s of the collection, but since
	 * {@link CourseInstance}s are immutable, this fact should be invisible to the
	 * client. The internal representation may differ from the organization of
	 * the collection, in that {@link CourseInstance}s will be ordered and duplicates removed.
	 * The given {@link Collection} will not be modified.
	 * 
	 * @param courseInstancePool
	 *                      any {@link Collection} of non-{@code null}
	 *                      {@link CourseAssistant}s that will be used to build the
	 *                      new CourseAssistantSet.
	 */
	public CourseInstancePool(Collection<CourseInstance> courseInstancePool) {
		this.courseInstancePool = new ArrayList<>();
		for (CourseInstance ci : courseInstancePool)
			addCourseInstancetoPool(ci);
	}
	
	public CourseInstancePool() {
		this.courseInstancePool = new ArrayList<>();
	}
	
	/**
	 * Returns the {@link CourseInstancePool} as an object sequence of {@link CourseInstance}s.
	 * 
	 * @return the {@link CourseInstancePool}.
	 */
	public Iterable<CourseInstance> getCourseInstanceSet() {
		return courseInstancePool;
	}
	
	/**
	 * Adds a {@link CourseInstance} to this {@link CourseInstancePool}. If the given
	 * {@link CourseInstance} is already in this {@link CourseInstancePool}, this is a no-op.
	 * 
	 * 
	 * @param ci
	 *               a non-{@code null} {@link CourseInstance} to add to this
	 *               {@link CourseInstancePool}.
	 */
	public void addCourseInstancetoPool(CourseInstance ci) {

		this.courseInstancePool.add(ci);
	}
	
	/**
	 * Finds a {@link CourseInstance} in this {@link CourseInstancePool} by a given 
	 * instructor's name.
	 * 
	 * @param instructorName
	 *               an instructor's name, represented as a String.
	 */
	public Iterable<CourseInstance> findCourseInstanceByInstructor(String instructorName) {

		ArrayList<CourseInstance> poolByInstructorName = new ArrayList<>();
		
		for (CourseInstance c: this.courseInstancePool) {
			Iterable<Section> iter2 = c.getSections();
			for (Section s: iter2) {
				if (instructorName == s.getInstructorName()) {
					poolByInstructorName.add(c);
				}
			}
		}
	
		return poolByInstructorName;
	}
	
	/**
	 * Finds a {@link CourseInstance} in this {@link CourseInstancePool} by a given 
	 * section type.
	 * 
	 * @param sectionType
	 *               a section type, represented as a String.
	 */
	public Iterable<CourseInstance> findCourseInstanceBySectionType(String sectionType) {

		ArrayList<CourseInstance> poolBySectionType = new ArrayList<>();
		
		for (CourseInstance c: this.courseInstancePool) {
			Iterable<Section> iter2 = c.getSections();
			for (Section s: iter2) {
				if (sectionType == s.getSectionType()) {
					poolBySectionType.add(c);
				}
			}
		}
	
		return poolBySectionType;
	}
	
	/**
	 * This method is for getting the size of {@link CourseInstancePool}.
	 * 
	 * @return the size of {@link CourseInstancePool}.
	 */
	public int getSize(){
		return courseInstancePool.size();
	}
	
	/**
	 * remove a {@link CourseInstance} from this {@link CourseInstancePool} given 
	 * the {@link Section} of {@link Course}.
	 * 
	 * @param sc
	 *               remove a {@link CourseInstancePool} to from this
	 *               {@link CourseInstancePool} with specified {@link Section}.
	 */
	public void removeCourseInstanceBySection(Section sc) {
        
		ListIterator<CourseInstance> iter = courseInstancePool.listIterator();

		while (iter.hasNext()) {
			CourseInstance y = iter.next(); //iterator next
			Iterable<Section> c = y.getSections(); 
			
			for(Section sec : c) {
				if (sc == sec) {// if the section equals to the specified section, remove.
					iter.remove();
			}

			}
		}
	}
}
