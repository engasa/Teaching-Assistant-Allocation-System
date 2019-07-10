package edu.udel.cis.taschd.skill;


import java.text.DecimalFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 * The {@link SkillSet} is a unordered set of {@link Skill}s representing a collection of
 * abilities. Examples include the skill set of a {@link edu.udel.cis.taschd.ca.CourseAssistant},
 * which corresponds to the classes which a {@link edu.udel.cis.taschd.ca.CourseAssistant}
 *  can be assigned, or the skill set of a {@link edu.udel.cis.taschd.course.CourseInstance},
 *  which corresponds to the mandatory set of skills required for a 
 *  {@link edu.udel.cis.taschd.course.Course}.
 *</p>
 * 
 * <p>
 * {@link SkillSet} is a {@link Set} of {@link Skill}s.
 * </p>
 * 
 * @author gnikhil
 * @author matthew
 */
public class SkillSet {
    /**
     * The set of {@link Skill}s. They are unordered. Therefore, as long as a {@link Skill} exists,
     * it is considered as a member of the overall skill set. There are no duplicate {@link Skill}s
     * in the {@link SkillSet}.
     */
    private Set<Skill> skills;

    /**
     * Constructs new empty {@link SkillSet}.
     */
    public SkillSet() {
        skills = new HashSet<>();
    }

    /**
     * Constructs a new {@link SkillSet} from the given collection of
     * strings. The new {@link SkillSet} will not keep any
     * reference to the given {@link Skill} (String), hence subsequent modifications
     * to the collection will not affect the new {@link SkillSet}. The new {@link SkillSet} 
     * may keep references to the member skills of the collection, but since
     * {@link Skill}s (Strings) are immutable, this fact should be invisible to the
     * client. The internal representation may differ from the organization of
     * the collection, in that {@link Skill}s will be unordered and duplicates removed.
     * The given {@link Collection} will not be modified.
     *
     * @param skillSet 
     *                    a collection of non-{@code null}
     *                    {@link Skill}s that will be used to build the
     *                    new {@link SkillSet}.
     */
    public SkillSet(Collection<Skill> skillSet) {
        this();
        for (Skill skill : skillSet)
            addSkill(skill);
    }

    /**
     * Returns the schedule as an iterable set of {@link Skill}s.
     *
     * @return the skill set in an iterable set.
     */
    public Iterable<Skill> getSkills() {
        return skills;
    }

    /**
     * Adds a {@link Skill} to this skill set. If the given
     * {@link Skill} is already in this set, this is a no-op.
     *
     * @param skill 
     *                  a non-{@code null} {@link Skill} to add to this skill set.
     */
    public void addSkill(Skill skill) {
        if (!skills.contains(skill)) {
            skills.add(skill);
        }
        
    }

    /**
     * Constructs a short human-readable representation of this skill set,
     * as a comma and semicolon-separated list, i.e.,
     *<pre>
     *"Java, Python, C#".
     *</pre>
     *
     * @return a string representation of the schedule
     */
    public String toString() {
        StringBuffer result = new StringBuffer();
        boolean first = true;

        for (Skill skill : skills) {
            if (first)
                first = false;
            else
                result.append(", ");
            result.append(skill.toString());
        }
        return result.toString();
    }
    
    /**
     * Compare the intersection between two {@link SkillSet}s and 
     * return a calculated score, which is used as partial input arguments
     * of Hungarian algorithm in {@link edu.udel.cis.taschd.gen.Generator}
     * to get the optimum assignment.
     *
     * @param skill 
     *                    a non-{@code null} {@link SkillSet} that will 
     *                    be used to compute the score.
     *           
     * @return a double value for computed score.
     */
    public double skillScore(SkillSet skill) {
    	
    	Set<Skill> skillset1 = this.skills;
    	Set<Skill> skillset2 = skill.skills;
    	
    	double reqiuredSkills = (double)skillset1.size();
    	
    	Set<Skill> intersection = new HashSet<Skill>(skillset1); 
        intersection.retainAll(skillset2); 
      
        double intersectSkills = (double)intersection.size();
     
        double score = intersectSkills/reqiuredSkills;
        
        DecimalFormat df = new DecimalFormat("#.#");
        
		return Double.parseDouble(df.format(score));
		
    	
    }
    
    /**
     * This method is a override for the {@link java.lang.Object#equals(Object)}.
     * 
     * @return the boolean value, TRUE if the Object's type is {@link SkillSet}
	 * and their sizes are equal and the {@link #skillScore(SkillSet)}s are equal.
	 * Else return FALSE.
     */
    @Override
	public boolean equals(Object that) {
    	
    	return (that instanceof SkillSet && this.skills.size()==((SkillSet)that).skills.size() && this.skillScore(((SkillSet)that))==1.0);
    		
    		
	}
 
}
