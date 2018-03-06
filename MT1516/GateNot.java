package circuits;

public class GateNot extends LogicGate {
	private LogicVariable in[] = new LogicVariable[1];
	private LogicVariable out;
	
	public GateNot(LogicVariable out, LogicVariable in) throws CycleException, ColisionException {


		
		this.in[0] = in;
		this.out = out;
		this.out.setValue(!in.getValue());
		
		
		if(this.out.getCalculatedBy() != null) {
			throw new ColisionException();
		}
		
		this.out.setCalculatedBy(this);
		
		for(LogicVariable lv: this.in) {
			if((lv.getCalculatedBy() != null) && lv.getCalculatedBy().isInput(out)) {
				throw new CycleException();
			}
		}
	}
	
	public LogicVariable[] getInputs() {
		return this.in;
	}
	
	public LogicVariable getOutput() {
		return this.out;
	}
	
	public String getSymbol() {
		return "NOT";
	}
	
	public void reCalc() {
		this.out.setValue(!in[0].getValue());
	}
	
	public boolean isInput(LogicVariable lv) {
		for(LogicVariable aux: this.in) {
			if(aux.equals(lv)) {
				return true;
			}
		}
		return false;
	}

}
