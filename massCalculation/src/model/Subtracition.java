package model;

import utils.IntegerWrapper;

public class Subtraction extends AbstractCalculation{

	private Subtraction(AbstractExpression left, AbstractExpression right){
		super(left,right);
	}
	
	public static Subtraction create(AbstractExpression left, AbstractExpression right){
		return new Subtraction(left, right);
	}
	
	public IntegerWrapper calculateTransitively(IntegerWrapper left,
			IntegerWrapper right) {
	
		
		return IntegerWrapper.create(left.getValue() - right.getValue());
	}
}
