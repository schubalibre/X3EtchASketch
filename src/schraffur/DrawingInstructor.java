package schraffur;

import sketchboard.EtchASketch;

public class DrawingInstructor {
	private static int x=0, y=0, z=0;
	
	public static String getTitle() {
		return "Example: straight line";
	}

	public static int firstX(int max) {
		x=max;
		return x;
	}

	public static int firstY(int max) {
		y=0-max;   // center of drawing panel
		return y;
	}

	public static int nextX(int max) {
		
		if(x == max+10 ){
			System.out.println("X:" + x);
			System.out.println("Y:" + y);
			y = firstY(max);
			x = max - 50*z;
			z++;
			return EtchASketch.GAP;
		}
		
		x++; 
		
		return x;// horizontal line, x increasing
		
	}

	public static int nextY(int max) {
		y++; 
		return y;  // horizontal line, y unchanged
	}
	
	public static int nextColor() {
		return EtchASketch.GREEN;
	}

}
