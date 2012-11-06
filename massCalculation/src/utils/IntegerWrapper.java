package utils;

public class IntegerWrapper implements BufferEntry {

	private final Integer value;

	private IntegerWrapper(Integer value) {
		this.value = value;
	}
	
	public static IntegerWrapper create(Integer value) {
		return new IntegerWrapper(value);
	}
	
	public Integer getValue() {
		return this.value;
	}
	
	@Override
	public BufferEntry accept(BufferEntryCalcVisitor v) {
		return v.visit(this);
	}
	
	@Override
	public boolean accept(BufferEntryStopVisitor v) {
		return v.visit(this);
	}
}
