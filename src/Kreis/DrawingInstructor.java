package Kreis;

import sketchboard.EtchASketch;

public class DrawingInstructor {
	private static int r=100, step=0, x=0, y=0;
	
	public static String getTitle() {
		return "Example: straight line";
	}

	public static int firstX(int max) {
		x=-100;
		return x;
	}

	public static int firstY(int max) {
		y=-100;   // center of drawing panel
		return y;
	}

	public static int nextX(int max) {
		if(step == 0){
			x++;
		}
		else{
			x--;
		}
		
		return x;// horizontal line, x increasing
	}

	public static int nextY(int max) {
		

		if(step == 0){
			y = (int) Math.sqrt(r*r-x*x);
		}else{
			y = (int) -(Math.sqrt(r*r-x*x));
		}
		
		if(x >= 100){ 
			step++;
		}else if (x <= -100){
			step--;
		}
		
		return y;  // horizontal line, y unchanged
	}
	
	public static int nextColor() {

		return EtchASketch.BLUE;
	}

}
