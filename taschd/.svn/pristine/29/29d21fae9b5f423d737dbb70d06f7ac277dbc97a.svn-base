package edu.udel.cis.taschd.gen;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import edu.udel.cis.taschd.assign.Assignment;
import edu.udel.cis.taschd.ca.CourseAssistant;
import edu.udel.cis.taschd.ca.CourseAssistantPool;
import edu.udel.cis.taschd.course.CourseInstancePool;
import edu.udel.cis.taschd.course.Section;
import edu.udel.cis.taschd.course.Course;
import edu.udel.cis.taschd.course.CourseInstance;

/**
 * <p>
 * This {@link CompleteAssign} provides a method to complete the partial
 * {@link Assignment} which contains part of the assignment but not for all
 * {@link Course}s.
 * </p>
 * 
 * <p>
 * {@link CompleteAssign} is a part of {@link GenerateAssignment}'s methods.
 * </p>
 * 
 * @author jinbo
 *
 */
public class CompleteAssign {
	/**
	 * This method is responsible for complete all the {@link Assignment} when given
	 * a partial {@link Assignment} which contains some given mapping relations
	 * between {@link CourseInstance} and {@link CourseAssistant}.
	 * 
	 * @param partialAssign a {@link Assignment} with some mapping relations
	 *                      already.
	 */
	public Assignment completeAssign(Assignment partialAssign) {

		Iterable<Section> sC = (Iterable<Section>) partialAssign.getSectionsFromAssignment();
		Collection<CourseAssistant> caSet;
		CourseAssistantPool newCAPool = new CourseAssistantPool(); // new ca pool
		CourseInstancePool newCiPool = new CourseInstancePool(); // new course pool
		Assignment finalAs = null; // final assignment
		// Assignment pAssignHashMap = null; // partial assignment

		if (sC == null) {
			throw new NullPointerException("This partial assignment does not contain any assignment!");
		}

		else {

			for (Section s1 : sC) {
				// assigned CAs
				caSet = partialAssign.getCasForSection(s1);

				// assigned sections
				// partialAssign.getSectionForCa(ca1);

				for (CourseAssistant ca : caSet) {

					int id = ca.getId();

					// partialAssign.getCAsFromAssignment(partialAssign);

					Set<CourseAssistant> caPool = partialAssign.getCAsFromAssignment(partialAssign);
					for (CourseAssistant i : caPool) {
						newCAPool.addCourseAssistant(i);
					}

					newCAPool.removeCourseAssistantById(id);

					Set<Section> ciPool = partialAssign.getSectionsFromAssignment();
					for (Section j : ciPool) {
						Course c = null;
						int t = 0;
						CourseInstance cou = new CourseInstance(c, t);
						cou.addSection(j);

						newCiPool.addCourseInstancetoPool(cou);
					}
					newCiPool.removeCourseInstanceBySection(s1);

					// commented by gsumeet
					GenerateAssignment ga = new GenerateAssignment(newCAPool, newCiPool);
					// commented by gsumeet
					Assignment newAs = ga.assign();

					// (HashMap<Section, Set<CourseAssistant>>)
					// commented by gsumeet
					// HashMap<Section, Set<CourseAssistant>> newAsSet;

					// pAssignHashMap.put(s1, caSet);
					// commented by gsumeet
					// mapCopy(newAs, partialAssign);
					mapCopy2(newAs, partialAssign);

					finalAs = partialAssign;

				}

			}
			return finalAs;
		}
	}

	/**
	 * This method is to copy the key and value of one {@link Assignment} into
	 * another {@link Assignment}.
	 * 
	 * @param iniMap    the source {@link Assignment} which the key and value comes
	 *                  from.
	 * @param targetMap the target {@link Assignment} which copies the key and value
	 *                  of the source {@link Assignment}.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void mapCopy2(Assignment iniMap, Assignment targetMap) {
		if (targetMap == null)
			targetMap = new Assignment();
		if (iniMap == null)
			return;

		Iterator it = iniMap.getSectionToCaMap(iniMap).entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			targetMap.getSectionToCaMap(targetMap).put(key,
					targetMap.getSectionToCaMap(targetMap).get(key) != null
							? targetMap.getSectionToCaMap(targetMap).get(key)
							: "");
		}

		Iterator it2 = iniMap.getSectionToCaMap(iniMap).entrySet().iterator();
		while (it2.hasNext()) {
			Map.Entry entry2 = (Map.Entry) it.next();
			Object key2 = entry2.getKey();
			targetMap.getSectionToCaMap(targetMap).put(key2,
					targetMap.getSectionToCaMap(targetMap).get(key2) != null
							? targetMap.getSectionToCaMap(targetMap).get(key2)
							: "");
		}

	}

	/**
	 * This method is to copy the key and value of one {@link Map} into another
	 * {@link Map}.
	 * 
	 * @param iniMap    the source {@link Map} which the key and value comes from.
	 * @param targetMap the target {@link Map} which copies the key and value of the
	 *                  source {@link Map}.
	 */
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	@Deprecated
	private void mapCopy(Map iniMap, Map targetMap) {
		if (targetMap == null)
			targetMap = new HashMap();
		if (iniMap == null)
			return;

		Iterator it = iniMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			Object key = entry.getKey();
			targetMap.put(key, targetMap.get(key) != null ? targetMap.get(key) : "");

		}
	}

}
