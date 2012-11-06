package utils;

public class StopCommand implements BufferEntry{

	private StopCommand() {

	}
	
	public static StopCommand create() {
	return new StopCommand();
	}

	@Override
	public BufferEntry accept(BufferEntryCalcVisitor c) {
		return c.visit(this);
	}

	@Override
	public boolean accept(BufferEntryStopVisitor c) {
		// TODO Auto-generated method stub
		return c.visit(this);
	}

}
