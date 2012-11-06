package utils;

public class ConcreteBufferEntryCalcVisitor implements BufferEntryCalcVisitor {

	private ConcreteBufferEntryCalcVisitor() {
	
	}
	
	public static ConcreteBufferEntryCalcVisitor create() {
	return new ConcreteBufferEntryCalcVisitor();
	}
	
	@Override
	public BufferEntry visit(StopCommand stop) {
	
		return null;
	}
	
	@Override
	public BufferEntry visit(IntegerWrapper value) {
		return value;
	}

}
