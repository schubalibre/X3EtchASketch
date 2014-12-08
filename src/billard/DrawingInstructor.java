package billard;

import sketchboard.EtchASketch;

public class DrawingInstructor {
	// wir brauchen für unser Grid ein paar neue Variablen minX=0, minY=0, a=0, b=0 und z=0
	private static int minX=0, minY=0, a=0, b=0, x=0, y=0, z=0;
	
	public static String getTitle() {
		return "Example: straight line";
	}

	public static int firstX(int max) {
		x=-max;
		// hier definieren wir das Minimum unserer Welt, also den äußersten unteren Rand für X
		minX -= max;  
		return x;
	}

	public static int firstY(int max) {
		y=-max;
		// hier definieren wir das Minimum unserer Welt, also den äußersten unteren Rand für Y
		minY -= max; 
		return y;
	}

	public static int nextX(int max) {
		// Der Umschalter: Er zeigt uns an wenn wir das Min oder Max (RAND) von X erreicht haben
		if(x > max || x < minX){
			/*
			 * Kurzschreibweise für 
			 * if(a == 0){
			 * 	a = 1;
			 * }else{
			 *  a = 0;
			 * }
			 * 
			 * Wenn a Null ist dann zählen wir positiv
			 * und wenn er Eins ist dann negativ
			 * 
			 * */
			a = (a == 0) ? 1 : 0;
			
			// unser bekannter Zähler, damit wir unsere Farben wechseln können wenn wir an eine Rand stoßen
			z++; 
		}

		// And here is where the magic happens ... 
		// Wenn der "Schalter" aus ist (0) zählen wir immer eins weiter ++ 
		if(a == 0){
			x++;
		}
		// Aber wenn der "Schalter" eingeschaltet ist (1), dann zählen wir wieder zurück -- 
		else{
			x--;	
		}
		// Hier kannst du es beobachten wie X immer wieder vor und zurück zählt :)
		System.out.println("X:" + x);
		return x;
		
	}

	public static int nextY(int max) {
		// Der Umschalter: Er zeigt uns an wenn wir das Min oder Max (RAND) von Y erreicht haben
		if(y > max || y < minY){
			/*
			 * Kurzschreibweise für 
			 * if(b == 0){
			 * 	b = 1;
			 * }else{
			 *  b = 0;
			 * }
			 * 
			 * Wenn b Null ist dann zählen wir positiv
			 * und wenn er Eins ist dann negativ
			 * 
			 * */
			b = (b == 0) ? 1 : 0;
			// unser bekannter Zähler, damit wir unsere Farben wechseln können wenn wir an eine Rand stoßen
			z++; 
		}
		// Magic....
		// Hier passiert das gleiche nur halt für die Y
		if(b == 0){
			// Damit wir nicht immer im Rechteck hüpfen füge ich hier 
			// den z % 6 ein um ein bisschen zu variieren. So wird immer 
			// etwas zu y dazugerechnet und der Winkel geändert...
			// Eine Billardkugel rollt ja auch nicht immer den gleichen Weg :)
			// du kannst es gerne mal wie oben mit y++ und y-- probieren damit du den Unterschied siehst
			y += 1 + (z % 6);
		}else{
			y -= 1 + (z % 6);
			
		}
		// Hier kannst du es beobachten wie Y immer wieder vor und zurück zählt :)
		System.out.println("Y:" + y);
		return y;
	}
	
	public static int nextColor() {

		switch(z % 6){
			case 0 : return EtchASketch.GREEN;
			case 1 : return EtchASketch.BLACK;
			case 2 : return EtchASketch.RED;
			case 3 : return EtchASketch.WHITE;
			case 4 : return EtchASketch.YELLOW;
			case 5 : return EtchASketch.BLUE;
			default : return EtchASketch.BLUE;
		}
		
		
	}

}
