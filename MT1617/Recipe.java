package recipes;

import java.util.Set;
import java.util.HashSet;

public class Recipe {
	private String name;
	private Set<RecipeStep> steps = new HashSet<>();
	
	public Recipe(String name){
		this.name = name;
	}
	
	public int getStepCount() {
		return this.steps.size();
	}
	
	public String getName() {
		return name;
	}
	
	public void addStep(RecipeStep rs) {
		this.steps.add(rs);
	}
	
}
