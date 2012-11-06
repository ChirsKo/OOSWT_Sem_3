package utils;

public interface BufferEntryStopVisitor {

	public boolean visit(IntegerWrapper value);
	
	public boolean visit(StopCommand stop);
	
}
