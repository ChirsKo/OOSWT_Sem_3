package model;

import utils.BufferEntry;
import utils.IntegerWrapper;

public class Constant extends AbstractExpression{

	private final int constant;
	
	public Constant(int constant){
		this.constant = constant;
	}

	public static Constant create(Integer value) {
		return new Constant(value);
	}
	
	public int getConstant() {
		return this.constant;
	}

	@Override
	public BufferEntry calculate() {
		return IntegerWrapper.create(this.getConstant());
	}
	
}
