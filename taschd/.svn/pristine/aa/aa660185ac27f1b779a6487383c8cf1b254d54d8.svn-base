package edu.udel.cis.taschd.ca;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;

/**
 * The CourseAssistantPool class is responsible for managing CourseAssistant Object 
 * like, obtaining all CourseAssistant list by using API in DB module. 
 * It hides the details on the internal representation
 * of courseAssistant objects. CoursesAssistant use time, skill and course Components.
 * 
 * @author Yi Liu
 */
public class CourseAssistantPool {
	/**
	 * The sequence of courseAssistats. They are ordered by Last Name, then first Name, 
	 * and Id number. The ordered is determined by the method{@link CourseAssistant#compareTo(CourseAssistant)}
	 * If LastName are equal, the fisrtNames are used to break the tie. If firstName are equal,
	 * the Id are used to break the tie
	 */
	private ArrayList<CourseAssistant> courseAssistantSet;
	
	/**
	 * Constructs new empty CourseAssistantSet.
	 */	
	public CourseAssistantPool(){
		courseAssistantSet = new ArrayList<>();
	}
	
	/**
	 * Constructs a new courseAssistantSet from the given collection of
	 * {@link CourseAssistant}s. The new {@link CourseAssistantPool} will not keep any
	 * reference to the given {@link Collection}, hence subsequent modifications
	 * to the collection will not affect the new CourseAssistantPool. 
	 * The new CourseAssistantPool may keep references to the member 
	 * CourseAssistants of the collection, but since
	 * {@link CourseAssistant}s are immutable, this fact should be invisible to the
	 * client. The internal representation may differ from the organization of
	 * the collection, in that courseAssistants will be ordered and duplicates removed.
	 * The given {@link Collection} will not be modified.
	 * 
	 * @param courseAssistants
	 *                      any collection of non-{@code null}
	 *                      {@link CourseAssistant}s that will be used to build the
	 *                      new CourseAssistantSet
	 */
	public CourseAssistantPool(Collection<CourseAssistant> courseAssistants) {
		this();
		for (CourseAssistant ca : courseAssistants)
			addCourseAssistant(ca);
	}
	
	/**
	 * Returns the courseAjavassistantSet as an iterable sequence of {@link CourseAssistant}.
	 * 
	 * @return the courseAssistantSet
	 */
	public Iterable<CourseAssistant> getCourseAssistantSet() {
		return courseAssistantSet;
	}	
	
	/**
	 * Adds a {@link CourseAssistant} to this courseAssistantSet. If the given
	 * {@link CourseAssistant} is already in this courseAssistantSet, this is a no-op.
	 * 
	 * 
	 * @param ca
	 *               a non-{@code null} {@link CourseAssistant} to add to this
	 *               courseAssistantSet
	 */
	public void addCourseAssistant(CourseAssistant ca) {

		ListIterator<CourseAssistant> iter = courseAssistantSet.listIterator();

		while (iter.hasNext()) {
			CourseAssistant y = iter.next();
			int c = ca.compareTo(y);

			if (c > 0) // ca goes after y
				continue;
			if (c == 0)
				return;
			// ... x y z ...
			// y is the first item in list that comes after ca. You want to
			// insert just before y.
			iter.previous();
			break;
		}
		iter.add(ca);
	}
	
	/**
	 * remove a {@link CourseAssistant} to this courseAssistantSet given 
	 * the Id of {@link CourseAssistant}
	 * 
	 * @param Id
	 *               remove a {@link CourseAssistant} to from this
	 *               courseAssistantSet with specified Id
	 */
	public void removeCourseAssistantById(int Id) { 
        
		ListIterator<CourseAssistant> iter = courseAssistantSet.listIterator();

		while (iter.hasNext()) {
			CourseAssistant y = iter.next(); //iterator next
			int c = y.getId(); 
			if (Id == c) {// if the id equals to the Id spcified remove.
				iter.remove();
			}
		}
	}
	
	/**
	 * find a {@link CourseAssistant} in this courseAssistantSet by given 
	 * the Id of {@link CourseAssistant}
	 * 
	 * @param Id
	 *               find a {@link CourseAssistant} to from this
	 *               courseAssistantSet with specified Id
	 */
	public CourseAssistant findCourseAssistantById(int Id) {
        
		ListIterator<CourseAssistant> iter = courseAssistantSet.listIterator();

		while (iter.hasNext()) {
			CourseAssistant y = iter.next(); //iterator next
			int c = y.getId(); 
			if (Id == c) {// if the id equals to the Id spcified remove.
				return y;
			}
		}
		System.out.println("No specified student with this Id in this list.");
		return null;
	}
	
	
	/**
	 * find a {@link CourseAssistant} in this courseAssistantSet by given 
	 * the first Name and last Name of {@link CourseAssistant}
	 * 
	 * @param firstName, lastName
	 *               find a {@link CourseAssistant} to from this
	 *               courseAssistantSet with specified firstName, lastName
	 */
	public CourseAssistantPool findCourseAssistantByName(String firstName, String lastName) {

		ListIterator<CourseAssistant> iter = courseAssistantSet.listIterator();
		CourseAssistantPool poolByName = new CourseAssistantPool(); 

		while (iter.hasNext()) {
			CourseAssistant y = iter.next(); //iterator next
			String fName = y.getFirstName();
			String lName = y.getLastName();
			if (fName.equals(firstName) && lName.equals(lastName)) {// if the id equals to the Id spcified remove.
				poolByName.addCourseAssistant(y);
			}
		}
		return poolByName;
	}
	
	

	
	
	/**
	 * Display an AssistantSet
	 */	
	public void displayCourseAssistants(){
		ListIterator<CourseAssistant> iter = courseAssistantSet.listIterator();
      
     	while (iter.hasNext()) {
  		    CourseAssistant y = iter.next(); //iterator next
            y.display();
  		}
  	}
	
	/**
	 * Get the size of Ta pool
	 * 
	 * @return int
	 */	
	public int getSize(){
		return courseAssistantSet.size();
	}
	
	

}

