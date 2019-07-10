package edu.udel.cis.taschd.skill;

/**
 * <p>
 * A {@link Skill} represents a discrete skill that a person may possess, such
 * as the ability to write Java programs, knowledge of Fortran or MPI, or having
 * obtained a grade of B or better in CISC 675. A course may require certain
 * {@link Skill}s of any teaching assistant or lab assistant.
 * </p>
 * 
 * <p>
 * For now, a {@link Skill} will simply wrap a {@link String}, it uses nothing.
 * </p>
 * 
 * @author siegel
 *
 */
public class Skill implements Comparable<Skill> {
	/**
	 * The name of the {@link Skill}.
	 */
	private String name;

	/**
	 * Constructs a new {@link Skill} by the given Strings. The {@link Skill}
	 * refers to the input argument name (String), which is the name of the 
	 * {@link Skill}.
	 * 
	 */
	public Skill(String name) {
		if (name == null)
			throw new IllegalArgumentException(
					"the name of a Skill cannot be null");
		this.name = name;
	}
	
	/**
	 * This method is a override for the {@link java.lang.Object#toString()}.
	 * 
	 * @return the name of the {@link Skill}.
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * This method is a override for the {@link java.lang.Object#hashCode()}.
	 * 
	 * @return the hash code of the name of the {@link Skill}.
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * This method is a override for the {@link java.lang.Object#equals(Object)}.
	 * 
	 * @return the boolean value, TRUE if the Object's type is {@link Skill}
	 * and the names are equal. Else return FALSE.
	 */
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Skill && name.equals(((Skill) obj).name);
	}

	/**
	 * This method is a override for the {@link java.lang.String#compareTo(String)}.
	 * 
	 * @return 0 if this.name is equal to the argument.name, -1 if this.name
	 * is less than the argument.name, +1 if this.name is greater than the argument.name.
	 */
	@Override
	public int compareTo(Skill that) {
		return name.compareTo(that.name);
	}

}
