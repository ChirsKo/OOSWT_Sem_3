package model;

import utils.IntegerWrapper;

public abstract class AbstractCalculation implements AbstractExpression  {

	private AbstractExpression left;
	private AbstractExpression right;
	
	public AbstractCalculation(AbstractExpression left, AbstractExpression right){
		
		this.left = left;
		this.right = right;
		
	}
	
	public BufferEntry calculate(){
		
		BufferEntry first = this.getLeft();
		BufferEntry second = this.getRight();
		
		IntegerWrapper result = (IntegerWrapper) this.calculateTransitively(left, right);
		
		return result;
	}
	
	public AbstractExpression getLeft() {
		return left;
	}

	public void setLeft(AbstractExpression left) {
		this.left = left;
	}
	
	public AbstractExpression getRight() {
		return right;
	}
	
	public void setRight(AbstractExpression right) {
		this.right = right;
	}
	
	public abstract IntegerWrapper calculateTransitively(IntegerWrapper left, IntegerWrapper right);

}
