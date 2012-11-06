package utils;

public interface BufferEntryCalcVisitor {
	
	public BufferEntry visit(IntegerWrapper value);
	
	public BufferEntry visit(StopCommand stop);
	
	
	
}
