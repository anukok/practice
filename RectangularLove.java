package interviewcake;

import java.awt.Rectangle;

public class RectangularLove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r1 = new Rectangle (0, 0, 20, 10);
		Rectangle r2 = new Rectangle (15, 15, 10, 10);
		
		Rectangle overlap = rectangleOverlap(r1, r2);
		System.out.println(overlap);

	}	
	// r1 and r2 are straight rectangles
	public static Rectangle rectangleOverlap(Rectangle r1, Rectangle r2) {
		// co ords are (a,b) (a+w, b) (a, b+h) (a+w, b+h)
		// lines are x=a, x=a+w, y=b, y=b+h 
		
		// overlap vertically?
		int y1 = r1.y;
		int y2 = r1.y + r1.height;
		int y3 = r2.y;
		int y4 = r2.y + r2.height;
		int y5, y6;
		if ( y3 >= y1 && y3 < y2) {
			y5 = y3;
			y6 = Math.min(y2,y4);
		} else if (y1 >=y3 && y1 < y4){
			y5 = y1;
			y6 = Math.min(y2, y4);
		} else {
			return null;
		}
		
		// overlap horizontally?
		
		int x1= r1.x; int x2 = r1.x + r1.width;
		int x3 = r2.x; int x4 = r2.x + r2.width;
		int x5, x6;
		
		if (x3 >=x1 && x3 < x2) {
			x5 = x3;
			x6 = Math.min(x2, x4);
		} else if (x1 >=x3 && x1 < x4){
			x5 = x1;
			x6 = Math.min(x2, x4);
		} else {
			return null;
		}
		
		return new Rectangle(x5, y5, x6-x5, y6-y5);
	}

}
