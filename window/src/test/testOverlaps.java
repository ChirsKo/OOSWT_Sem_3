package test;

import model.*;
import org.junit.*;
import junit.*;
import junit.framework.TestCase;


public class testOverlaps  extends TestCase {
	
	RectangularPart partA = new RectangularPart(new Point(3,3),2,2);
	
	RectangularPart partB = new RectangularPart(new Point(4,4),2,2);
	
	public void testOverlapsAnB(){
		
		
		assertEquals(true,partA.overlaps(partB));
		
	}

	
	
}
