package circuits;

public class LogicVariable {
	private String name;
	private boolean value;
	private LogicGate calculatedBy;
	
	public LogicVariable(String name, boolean value) {
		this.name = name;
		this.value = value;
		this.calculatedBy = null;
	}
	public LogicVariable(String name) {
		this.name = name;
		this.value = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean getValue() {
		if(this.getCalculatedBy() != null) {
			this.getCalculatedBy().reCalc();
		}
		return this.value;
	}
	
	public void setValue(boolean value) {
		this.value = value;
	}
	
	public void setCalculatedBy(LogicGate lg) {
		this.calculatedBy = lg;
	}
	
	public LogicGate getCalculatedBy() {
		return this.calculatedBy;
	}
	

	public String getFormula() {
		if (calculatedBy == null) {	
			return name;
		}
		else {
			return calculatedBy.getFormula();
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof LogicVariable)) {
			return false;
		}
		LogicVariable obj2 = (LogicVariable) obj;
		if(!this.name.equals(obj2.name)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

}
