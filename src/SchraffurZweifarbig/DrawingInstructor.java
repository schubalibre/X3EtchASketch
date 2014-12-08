package SchraffurZweifarbig;

import java.awt.Color;

import sketchboard.EtchASketch;

public class DrawingInstructor {
	private static int x=0, y=0, z=0;
	
	public static String getTitle() {
		return "Example: straight line";
	}

	public static int firstX(int max) {
		// Wir setzen x=max, damit unsere Schraffur rechts unten beginnt.
		x = max;
		return x;
	}

	public static int firstY(int max) {
		y = 0 - max;
		return y;
	}

	public static int nextX(int max) {
		// 
		if(x >= max){
			// reset
			x = x - (20*z);
			z++;
			y = -max;

			return EtchASketch.GAP;
		}
		else
		{
			x++;
		}
		return x;// horizontal line, x increasing
		
	}

	public static int nextY(int max) {
		y++;
		return y;  // horizontal line, y unchanged
	}
	
	public static int nextColor() {
		if(z % 2 == 0){
			return EtchASketch.BLUE;
		}else{
			return EtchASketch.GREEN;
		}

	}

}
