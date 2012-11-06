package model;

import utils.IntegerWrapper;

public class Division extends AbstractCalculation {
	
	private Division(AbstractExpression left, AbstractExpression right){
		super(left,right);
	}
	
	public static Division create(AbstractExpression left, AbstractExpression right){
		return new Division(left, right);
	}
	
	public IntegerWrapper calculateTransitively(IntegerWrapper left,
			IntegerWrapper right) {
		if(right.getValue() == 0){
			throw new Exception("Division durch 0");
		}else return IntegerWrapper.create(left.getValue() / right.getValue());
	}
	
}
