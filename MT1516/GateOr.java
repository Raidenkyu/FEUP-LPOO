package circuits;

public class GateOr extends LogicGate {
	private LogicVariable in[] = new LogicVariable[2];
	private LogicVariable out;
	
	public GateOr(LogicVariable out, LogicVariable i1, LogicVariable i2) throws CycleException, ColisionException {
		

		
		this.in[0] = i1;
		this.in[1] = i2;
		this.out = out;
		this.out.setValue(i1.getValue() || i2.getValue());
		
		
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
		return "OR";
	}
	
	public void reCalc() {
		this.out.setValue(in[0].getValue() || in[1].getValue());
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
