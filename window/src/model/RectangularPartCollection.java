package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class RectangularPartCollection {
	
	private Collection<RectangularPart> parts;

	public RectangularPartCollection(){
		this.setParts(new Vector<RectangularPart>());
	}

	public Collection<RectangularPart> getParts() {
		return parts;
	}

	public void setParts(Collection<RectangularPart> parts) {
		this.parts = parts;
	}

	public void add(RectangularPartCollection partCollection) {
		//TODO (1) it shall be checked that two parts in the same collection do not overlap
		
		Iterator<RectangularPart> i = partCollection.getParts().iterator();
		while(i.hasNext()){
			RectangularPart current = i.next();
			if(current.overlaps(null)){
				// TODO!!!!
			}
			
		}
		
		
		
		
		
		this.getParts().addAll(partCollection.parts);
		
		
	}
 
	public Vector toVector() {
		return (Vector) this.parts;
	}

	public void add(RectangularPart part) {
		this.getParts().add(part);
	}
}
