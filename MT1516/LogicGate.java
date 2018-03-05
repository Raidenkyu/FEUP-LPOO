package circuits;

public abstract class LogicGate {
	
	public abstract LogicVariable getOutput();
	
	public abstract LogicVariable[] getInputs();
	
	public abstract String getSymbol();

}
