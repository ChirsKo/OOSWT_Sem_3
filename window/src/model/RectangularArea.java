package model;

abstract public class RectangularArea {
	
	private Point leftUpperCorner;
	private int width;
	private int height;
	
	protected RectangularArea(Point position, int width, int height) {
		this.setLeftUpperCorner(position);
		this.setWidth(width < 0 ? 0 :width);
		this.setHeight(height < 0 ? 0 : height);
	}
	int getHeight() {
		return height;
	}
	private void setHeight(int height) {
		this.height = height;
	}
	Point getLeftUpperCorner() {
		return leftUpperCorner;
	}
	private void setLeftUpperCorner(Point leftUpperCorner) {
		this.leftUpperCorner = leftUpperCorner;
	}
	int getWidth() {
		return width;
	}
	private void setWidth(int width) {
		this.width = width;
	}
	public void move(int deltaX, int deltaY){
		this.getLeftUpperCorner().move(deltaX, deltaY);
	}
	public void resize(int width, int height) throws NegativeLengthException{
		if (width <= 0) throw new NegativeLengthException();
		if (height <= 0) throw new NegativeLengthException();
		this.setHeight(height);
		this.setWidth(width);
	}
	public String toString(){
		return  "(WIDTH: " + this.getWidth() + ", HEIGHT: " + this.getHeight() + ") at " + this.getLeftUpperCorner();
	}
	public boolean isIn(RectangularPart part) {
		if (this.equals(part)) return true;
		return this.isInTransitively(part);
	}
	abstract boolean isInTransitively(RectangularPart part);
	
	
	
	
	
	
	public boolean overlaps(RectangularPart part){	
			
			RectangularPart boundedRectangle = this.getBoundRectangle(part);
			
			boolean overlaps;
			
			if(  boundedRectangle.getWidth() < this.getWidth() + part.getWidth() && boundedRectangle.getHeight() < this.getHeight() + part.getHeight()){
				overlaps = true;
			} else {
				overlaps = false;
			}
			
		return  overlaps;
		
		
	}
	
	private RectangularPart getBoundRectangle(RectangularPart part) {
		
		
		Point position = this.getPointOfBoundRectangle(part);
		int height = this.getHeightOfBoundRectangle(part);
		int width = this.getWidthOfBoundRectangle(part);

		RectangularPart boundRectangle = new RectangularPart(position, width, height);
				
		return  boundRectangle ;
	
	}
	private Point getPointOfBoundRectangle(RectangularPart part){
		
		int x;
		int y;
		
		if(this.leftUpperCorner.getX() < part.getLeftUpperCorner().getX()){
			x = this.getLeftUpperCorner().getX();
		} else {
			x = part.getLeftUpperCorner().getX();
		}
		if(this.leftUpperCorner.getY() < part.getLeftUpperCorner().getY()){
			y = this.getLeftUpperCorner().getY();
		} else {
			y = part.getLeftUpperCorner().getY();
		}
		
		Point point = new Point(x, y);
		
		return point;
	}	
	
	private int getHeightOfBoundRectangle(RectangularPart part){
		
		int height;
		
		if(this.getLeftUpperCorner().getY() + this.getHeight() < part.getLeftUpperCorner().getY() + part.getHeight()){
			height = part.getLeftUpperCorner().getY() + part.getHeight();			
		}else{
			height = this.getLeftUpperCorner().getY() + this.getHeight();
		}
		
		return height;
	}
	
	private int getWidthOfBoundRectangle(RectangularPart part){
		
		int width;
		
		if(this.getLeftUpperCorner().getX() + this.getHeight() < part.getLeftUpperCorner().getX() + part.getHeight()){
			width = part.getLeftUpperCorner().getX() + part.getHeight();			
		}else{
			width = this.getLeftUpperCorner().getX() + this.getHeight();
		}
		return width;
	}
	
	
	
	
	
}
