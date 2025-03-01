package edu.udel.cis.taschd.assign;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import edu.udel.cis.taschd.ca.CourseAssistant;
import edu.udel.cis.taschd.course.Section;

/**
 * <p>
 * An {@link Assignment} is a mapping of {@link CourseAssistant}s to course
 * {@link Section}s. This specifies the sections assigned to each CA. It hides
 * the details of the internal representation of this mapping. Methods to
 * construct, modify, display, and read assignments are provided.
 * </p>
 * 
 * <p>
 * {@link Assignment} uses ca module and course module.
 * </p>
 * 
 * @author zhangjianbo
 * 
 */
public class Assignment {

	/**
	 * Maps each {@link CourseAssistant} to a set of {@link Section}s. If a
	 * {@link CourseAssistant} does not occur in this map then it means the
	 * {@link CourseAssistant} is assigned no {@link Section}s.
	 */
	private Map<CourseAssistant, Set<Section>> caToSectionMap;

	/**
	 * The inverse of the {@link #caToSectionMap}. The following invariant is
	 * maintained:
	 * 
	 * if (s,C) is in sectionToCaMap, then for all c in C, caToSectionMap.get(c)
	 * contains s.
	 * 
	 * if (c,S) is in caToSectionMap, then for all s in S, sectionToCaMap.get(s)
	 * contains c.
	 */
	private Map<Section, Set<CourseAssistant>> sectionToCaMap;

	/**
	 * Constructs new empty {@link Assignment}.
	 */
	public Assignment() {
		caToSectionMap = new HashMap<>();
		sectionToCaMap = new HashMap<>();
	}
	
	/**
	 * Gets the set of {@link CourseAssistant}s assigned to the given
	 * {@link Section}. The set returned should not be modified.
	 * 
	 * @param section
	 *                    a non-{@code null} {@link Section}
	 * 
	 * @return the {@link Set} of {@link CourseAssistant}s assigned to
	 *         {@code section} under this {@link Assignment}. This will never be
	 *         {@code null}.
	 */
	public Set<CourseAssistant> getCasForSection(Section section) {
		Set<CourseAssistant> result = sectionToCaMap.get(section);

		if (result == null)
			result = new HashSet<>();
		return result;
	}

	/**
	 * Gets the set of {@link Section}s assigned to the given
	 * {@link CourseAssistant}. The set returned will never be {@code null} and
	 * should not be modified.
	 * 
	 * @param ca
	 *               a non-{@code null} {@link CourseAssistant}
	 * 
	 * @return the {@link Set} of {@link Section}s assigned to {@code ca}
	 */
	public Set<Section> getSectionForCa(CourseAssistant ca) {
		Set<Section> result = caToSectionMap.get(ca);

		if (result == null)
			result = new HashSet<>();
		return result;
	}


	/**
	 * Adds a single ca-section assignment to this {@link Assignment}.
	 * 
	 * @param section
	 *                    a non-{@code null} {@link Section}
	 * @param ca
	 *                    a non-{@code null} {@link CourseAssistant} that is to
	 *                    be assigned to {@code section}
	 */
	public void setCaForSection(Section section, CourseAssistant ca) {
		Set<CourseAssistant> caSet = sectionToCaMap.get(section);

		if (caSet == null) {
			caSet = new HashSet<>();
			sectionToCaMap.put(section, caSet);
		}
		caSet.add(ca);

		Set<Section> sectionSet = caToSectionMap.get(ca);

		if (sectionSet == null) {
			sectionSet = new HashSet<>();
			caToSectionMap.put(ca, sectionSet);
		}
		sectionSet.add(section);
	}

	/**
	 * Prints the set of {@link Section}s assigned to the given
	 * {@link CourseAssistant}. The output is a comma-separated list on a single
	 * line, followed by one newline character. If the list is empty, "none" is
	 * printed.
	 * 
	 * 
	 * @param out
	 *                stream to which to print
	 * @param ca
	 *                a non-{code null} {@link CourseAssistant}
	 */
	public void display(PrintStream out, CourseAssistant ca) {
		Set<Section> sections = caToSectionMap.get(ca);

		if (sections == null || sections.isEmpty())
			out.println("none");
		else {
			boolean first = true;

			for (Section section : sections) {
				if (first)
					first = false;
				else
					out.print(", ");
				out.print(section);
			}
			out.println();
		}
	}

	/**
	 * Prints the set of {@link CourseAssistant}s assigned to the given
	 * {@link Section}. The output is a comma-separated list on a single
	 * line, followed by one newline character. If the list is empty, "none" is
	 * printed.
	 * 
	 * @param out
	 * 				stream to which to print
	 * @param section
	 * 				a non-{code null} {@link Section}
	 */
	public void display(PrintStream out, Section section) {
		Set<CourseAssistant> courseAssistants = sectionToCaMap.get(section);
		
		if (courseAssistants == null || courseAssistants.isEmpty()) {
			out.println("none");
		}
		else {
			boolean first = true;
			
			for (CourseAssistant ca: courseAssistants) {
				if (first) {
					first = false;
				}
				else {
					out.print(", ");
				}
				out.print(ca);
			}
			out.println();
		}	
	}
	
	/**
	 * Prints the entire {@link Assignment}s.The output is a table with a list of
	 * {@link Section}s, followed by a comma-separated list on a single line of
	 * {@link CourseAssistant}s. If the list of {@link CourseAssistant}s. is empty,
	 * "has no course assistant!" is printed. If the list if {@link Section} is 
	 * empty, "none" is printed.
	 * 
	 * @param out
	 *              stream to which to print
	 */
	public void displayAll(PrintStream out) {
		if (sectionToCaMap == null || sectionToCaMap.isEmpty()) {
			out.println("none");
		}
		
		for (Section section: sectionToCaMap.keySet()) {
			if (sectionToCaMap.get(section).isEmpty()) {
				out.println(section + "has no course assistant!");
			}
			else {
				out.print(section + ": ");
				for (CourseAssistant ca: sectionToCaMap.get(section)) {
					out.print(ca);
					out.print(", ");
				}
				out.println();
			}
		}
	}
	
	/**
	 * This method is to get the keys of this {@link Assignment}, which
	 * here are the {@link Section}s in the {@link HashMap} that storing the
	 * real {@link Assignment}.
	 * 
	 * @param as
	 *               a non-{{@code null} {@link Assignment}.
	 *               
	 * @return a {@link Set} of all the {@link Section}s in this {@link Assignment}.
	 */
    public Set<Section> getSectionsFromAssignment(){
    	Set<Section> ssc = sectionToCaMap.keySet();
    	return ssc;
    }
    
    /**
     * This method is to get the keys of this {@link Assignment}, which
	 * here are the {@link CourseAssistant}s in the {@link HashMap} that 
	 * storing the real {@link Assignment}.
	 * 
     * @param as
     *                a non-{{@code null} {@link Assignment}.
     *                
     * @return a {@link Set} of all the {@link CourseAssistant}s in this {@link Assignment}.
     */
    public Set<CourseAssistant> getCAsFromAssignment(Assignment as){
    	Set<CourseAssistant> sca = as.caToSectionMap.keySet();
    	return sca;
    }
    
    /**
     * This method is to get the caToSectionMap relation in the {@link Assignment}.
     * 
     * @param as
     *               a non-{{@code null} {@link Assignment}.
     *               
     * @return a {@link Map} relation from {@link CourseAssistant} to {@link Section}.
     */
    @SuppressWarnings("rawtypes")
	public Map getCaToSectionMap(Assignment as){
    	Map<CourseAssistant, Set<Section>> c2sMap = as.caToSectionMap;
    	return c2sMap;
    }
    
    /**
     * This method is to get the sectionToCaMap relation in the {@link Assignment}.
     * 
     * @param as
     *               a non-{{@code null} {@link Assignment}.
     *               
     * @return a {@link Map} relation from {@link Section} to {@link CourseAssistant}.
     */
    @SuppressWarnings("rawtypes")
	public Map getSectionToCaMap(Assignment as){
    	Map<Section, Set<CourseAssistant>> s2cMap = as.sectionToCaMap;
    	return s2cMap;
    }
}





