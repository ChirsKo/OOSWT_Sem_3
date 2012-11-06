package model;

import utils.IntegerWrapper;

public class Addition extends AbstractCalculation {

	private Addition(AbstractExpression left, AbstractExpression right){
		super(left,right);
	}
	
	public static Addition create(AbstractExpression left, AbstractExpression right){
		return new Addition(left, right);
	}
	@Override
	public IntegerWrapper calculateTransitively(IntegerWrapper left,
			IntegerWrapper right) {
	
		
		return IntegerWrapper.create(left.getValue() + right.getValue());
	}
	
}
