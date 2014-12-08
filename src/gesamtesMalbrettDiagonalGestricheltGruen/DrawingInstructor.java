package gesamtesMalbrettDiagonalGestricheltGruen;

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
		if(x<-250) return EtchASketch.GREEN;
		
		else if(x<-245) return EtchASketch.GREEN;
		else if(x<-240) return EtchASketch.GAP;
		else if(x<-235) return EtchASketch.GREEN;
		else if(x<-230) return EtchASketch.GAP;
		else if(x<-225) return EtchASketch.GREEN;
		else if(x<-220) return EtchASketch.GAP;
		else if(x<-215) return EtchASketch.GREEN;
		else if(x<-210) return EtchASketch.GAP;
		else if(x<-205) return EtchASketch.GREEN;
		else if(x<-200) return EtchASketch.GAP;
		else if(x<-165) return EtchASketch.GREEN;
		else if(x<-160) return EtchASketch.GAP;
		else if(x<-155) return EtchASketch.GREEN;
		else return EtchASketch.GREEN;
		
	}

}
