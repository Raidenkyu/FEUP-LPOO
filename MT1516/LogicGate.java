package circuits;

public abstract class LogicGate {
	
	public abstract LogicVariable getOutput();
	
	public abstract LogicVariable[] getInputs();
	
	public abstract String getSymbol();
	
	public abstract void reCalc();
	
	public String getFormula() {
		String result = getSymbol() + "(";
		for(LogicVariable lv : getInputs()) {
			result += lv.getFormula() + ",";
		}
		result = result.substring(0, result.lastIndexOf(","));
		result += ")";
		return result;
	}
	
	public abstract boolean isInput(LogicVariable lv);

}
