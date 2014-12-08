package GestricheltZweifarbig;

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
		// Problem: Wie kommen wir auch in den Minus-Bereich?
		
		int b = x + 99999;
		
		if(b % 20 < 10)
		{
			return EtchASketch.RED;
		}
		else
		{
			return EtchASketch.GREEN;
		}
		
	}

}
