package model;

public class RectangularPart extends RectangularArea {

	RectangularArea parent;
	
	protected RectangularPart(Point position, int width, int height) {
		super(position, width, height);
	}
	public String toString(){
		return super.toString() + " { PARENT: " + this.getParent().toString() + " }";
	}
	private RectangularArea getParent() {
		return this.parent;
	}
	void setParent(RectangularArea parent) throws HierarchyException {
		//TODO (1) it shall be checked that the parent contains "this"
		
		
		if (parent.isIn(this)) throw new HierarchyException();
		this.parent = parent;
	}
	boolean isInTransitively(RectangularPart part) {
		if (this.getParent() == null) return false;
		return this.getParent().isInTransitively(part);
	}
	
	public boolean overlaps(RectangularPart part){	
		boolean overlapX = false;		
		boolean overlapY = false;
		boolean overlap = false;
		if(!(this.getParent().equals(part.getParent()))){
			if(this.getLeftUpperCorner().getX() < part.getLeftUpperCorner().getX()){
				part.getLeftUpperCorner().setX(part.getLeftUpperCorner().getX() - this.getLeftUpperCorner().getX());
				this.getLeftUpperCorner().setX(0);
				if(this.getWidth() > part.getLeftUpperCorner().getX()){
					overlapX = true;
				}			
			}else{
				this.getLeftUpperCorner().setX(this.getLeftUpperCorner().getX() - part.getLeftUpperCorner().getX());
				part.getLeftUpperCorner().setX(0);
				if(part.getWidth() > this.getLeftUpperCorner().getX()){
					overlapX = true;
				}
				
			}
			
			if(this.getLeftUpperCorner().getY() < part.getLeftUpperCorner().getY()){
				part.getLeftUpperCorner().setY(part.getLeftUpperCorner().getY() - this.getLeftUpperCorner().getY());
				this.getLeftUpperCorner().setY(0);
				if(this.getHeight() > part.getLeftUpperCorner().getY()){
					overlapY = true;
				}
			}else{
				this.getLeftUpperCorner().setY(this.getLeftUpperCorner().getY() - part.getLeftUpperCorner().getY());
				part.getLeftUpperCorner().setY(0);
				if(part.getHeight() > this.getLeftUpperCorner().getY()){
					overlapY = true;
				}
			}
			
			if(overlapX == true && overlapY == true){
				overlap = true;
			}
		}
		return overlap;
	}
}
@SuppressWarnings("serial")
class HierarchyException extends Exception {
	public HierarchyException() {
		super("No cycles!!!");
	}
}
