package circuits;

public class GateAnd extends LogicGate {
	private LogicVariable in[] = new LogicVariable[2];
	private LogicVariable out;
	
	public GateAnd(LogicVariable out, LogicVariable i1, LogicVariable i2) {
		this.in[0] = i1;
		this.in[1] = i2;
		this.out = out;
		this.out.setValue(i1.getValue() && i2.getValue());
	}
	
	public LogicVariable[] getInputs() {
		return this.in;
	}
	
	public LogicVariable getOutput() {
		return this.out;
	}
	
	
	public String getSymbol() {
		return "AND";
	}

}
