package zickzack;

import sketchboard.EtchASketch;

public class DrawingInstructor {
	private static int x=0, y=0, z=0;
	
	public static String getTitle() {
		return "Example: straight line";
	}

	public static int firstX(int max) {
		x=-max;
		return x;
	}

	public static int firstY(int max) {
		// damit die Zickzacklinie von Links außen nach rechts geht und immer horizontal mittig läuft setzen wir y = 0;
		y=0;
		return y;
	}

	public static int nextX(int max) {
		// hier soll er normal zählen und nach rechts gehen
		x++;
		return x;	
	}

	public static int nextY(int max) {
		// damit unsere Linie auch nach zwanzig Schritten wieder abwechselnd in die untere oder obere Richtung geht 
		// müssen wir wieder ein Zähler einfügen, der die Schritte zählt!  
		
		/*  
		 * 
		 * Also: wir fagen ja bei y = 0 ( firstY() ) an .....
		 * 
		 * 0 % 40 = 0 -> y++
		 * 1 % 40 = 1 -> y++
		 * 2 % 40 = 2 -> y++
		 * 3 % 40 = 3 -> y++
		 * .
		 * .
		 * .
		 * 20 % 40 = 20 -> ohhh wir sind ja schon bei Zwanzig... wieder runter y--
		 * 21 % 40 = 21 -> y--
		 * 22 % 40 = 22 -> y-- 
		 * 23 % 40 = 23 -> y-- 
		 * .
		 * .
		 * .
		 * .
		 * 40 % 40 = 0 -> ohhhh es geht wieder hoch y-- (der Kreis schließt sich)
		 * 
		 * 
		 * */ 
		
		// hier sagen wir der y Koordinate das sie hoch zählen soll 
		// wenn der Modulo kleiner ist als 20!
		if(z % 40 < 20)
		{
			y++;
		}
		else  // und hier geht's wieder runter
		{ 
			y--;
		}
		
		// der Zähler soll immer zählen, bei jedem Schritt
		z++;
		return y;
	}
	
	public static int nextColor() {
		return EtchASketch.BLUE;
	}

}
