package recipes;

import java.util.Map;
import java.util.TreeMap;



public class RecipeStep  extends Ingredient{
	private String action;
	private Map<Ingredient,Float> ingredients = new TreeMap<>();
	
	public RecipeStep(String name, String action) throws IllegalArgumentException {
		super(name);
		if(name == null || action == null) {
			throw new IllegalArgumentException();
		}
		this.action = action;
	}
	
	public String getAction() {
		return this.action;
	}
	
	public Map<Ingredient, Float> getIngredients(){
		return this.ingredients;
	}
	
	public void addIngredient(Ingredient ingredient, float quantity) {
		if(this.ingredients.containsKey(ingredient)) {
			if(this.ingredients.get(ingredient) >= quantity) {
				return;
			}
		}
		this.ingredients.put(ingredient, quantity);
	}
	
	
	public float getQuantity(Ingredient ingredient) {
		for(Map.Entry<Ingredient, Float> ing: this.ingredients.entrySet()) {
			
			if(ing.getKey().equals(ingredient)) {
				return ing.getValue();
			}
			
			
			if(ing.getKey() instanceof RecipeStep) {
				
				for(Map.Entry<Ingredient, Float> ing2: ((RecipeStep) ing.getKey()).ingredients.entrySet()) {
					if(ing2.getKey().equals(ingredient)) {
						return ing2.getValue() * ing.getValue();
				}
				}
			}
		}
		return 0;
	}
	
	public int getIngredientCount() {
		return this.ingredients.size();
	}
	
	@Override
	public String toString() {
		String res = "to make " + this.getName() + ", " + this.getAction() + " ";
		for(Map.Entry<Ingredient, Float> ing: this.ingredients.entrySet()) {
			res += ing.getValue() + " " + ing.getKey().getName() + ", ";
		}
		return res.substring(0, res.lastIndexOf(","));
	  }
}
