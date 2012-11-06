package utils;

public interface BufferEntry {
	
	public BufferEntry accept(BufferEntryCalcVisitor c);
	
	public boolean accept(BufferEntryStopVisitor c);

}
