package recipes;


import java.util.Objects;

public abstract class Ingredient implements Comparable<Ingredient> {
	private String name;
	
	public Ingredient(String name) throws IllegalArgumentException {
		if(name == null) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
        return  Objects.equals(((Ingredient) obj).getName(), this.name);
	}
	 @Override
	 public int hashCode() {
		 return name.hashCode();
	} 
	 @Override
	 public int compareTo(Ingredient ing) {
	     return this.name.compareTo(ing.name);
	}
	 @Override
	 public String toString() {
	        return this.name;
	 }
	 
}
