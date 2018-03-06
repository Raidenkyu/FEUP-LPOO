package circuits;

import java.util.HashSet;

public class CombinatorialCircuit {
	private HashSet<LogicVariable> variables = new HashSet<>();
	
	public boolean addVariable(LogicVariable lv) {
		return this.variables.add(lv);
	}
	
	public LogicVariable getVariableByName(String name) {
		if(name == null) {
			return null;
		}
		for(LogicVariable lv : this.variables) {
			if(lv.getName() == name) {
				return lv;
			}
		}
		return null;
	}

}
