package disco;

import java.awt.Color;

import sketchboard.EtchASketch;

public class DrawingInstructor {
	private static int x=0, y=0;
	
	public static String getTitle() {
		return "Example: straight line";
	}

	public static int firstX(int max) {
		x=0-max;
		return x;
	}

	public static int firstY(int max) {
		y=0-max;   // center of drawing panel
		return y;
	}

	public static int nextX(int max) {
		x++; 
		return x;// horizontal line, x increasing
		
	}

	public static int nextY(int max) {
		y++;
		return y;  // horizontal line, y unchanged
	}
		
	public static int nextColor() {
		
		int farbenzaehler = (x+999999) % 70;

		switch((int) farbenzaehler/10){
			case 0: return EtchASketch.BLACK; 
			case 1: return EtchASketch.RED;
			case 2:	return EtchASketch.WHITE;
			case 3:	return EtchASketch.GREEN;
			case 4: return EtchASketch.YELLOW;
			case 5:	return EtchASketch.BLUE;
			case 6: case 7:return EtchASketch.GAP;
		}
		return EtchASketch.BLUE;
	}

}
