package Graph;

import sketchboard.EtchASketch;

public class DrawingInstructor {
	private static int i=0, x=0, y=0;
	
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
		// nach Aufgabentext soll nur Y verändert werden,
		// damit ein Graph entsteht müssen wir Y also 'schneller' steigen lassen 
		// und damit es auch schön aussieht nehmen wir den Modulo damit der Graph nicht zu spitz steigt :) 
		// Wir lieben Modulo.... 
		if(x % 5 ==0)// alle 5 pixel mach y einen Sprung nach vorne (immer i + 1)
			i++;// cooler Zähler 
		y += i;// hier wird er Y übergeben... Achtung er verändert Y nur alle % 5 male!
		return y;
	}
	
	public static int nextColor() {
		return EtchASketch.BLUE;
	}

}
