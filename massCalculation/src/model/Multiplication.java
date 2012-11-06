package model;

import utils.IntegerWrapper;

public class Multiplication extends AbstractCalculation {


	private Multiplication(AbstractExpression left, AbstractExpression right){
		super(left,right);
	}
	
	public static Multiplication create(AbstractExpression left, AbstractExpression right){
		return new Multiplication(left, right);
	}
	
	public IntegerWrapper calculateTransitively(IntegerWrapper left,
			IntegerWrapper right) {
	
		
		return IntegerWrapper.create(left.getValue() * right.getValue());
	}
}
