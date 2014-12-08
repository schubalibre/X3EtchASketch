package Graph2;

import sketchboard.EtchASketch;

public class DrawingInstructor {
	private static int gap=0,x=0, y=0, step=0;
	
	public static String getTitle() {
		return "Example: straight line";
	}

	public static int firstX(int max) {
		x=0;
		return x;
	}

	public static int firstY(int max) {
		y=-max;
		return y;
	}

	public static int nextX(int max) {
		
		// wir malen ein Koordinatensystem
		if(step == 0){
			// hier machen wir nichts, da wir nur eine Linie nach oben wollen.
		}else if(step == 1){
			// hier setzen wir unseren X Startpunkt neu
			x = -max;
		}else if(step == 2){
			// bis wir rechts angekommen sind malen wir
			
			// wenn wir rechts angekommen sind gehen wir einen schritt weiter
			if(x >= max){
				step++; // step 3
			}else{
				x++;
			}	
		}else if(step == 3){
			// Wichtig! Den sprung zum neuen Startpunkt wollen wir nicht zeigen"  
			gap = 1;
			// hier setzen wir unseren X Startpunkt neu
			x = -max;
			// und gehen einen schritt weiter
			step++;// step 4
	    }else{
	    	x++;
		}

		return x;// horizontal line, x increasing
	}

	public static int nextY(int max) {

		if(step == 0){
			// bis wir oben angekommen sind malen wir
			
			if(y >= max){// wenn wir oben angekommen sind gehen wir einen schritt weiter
				step++;// stepp 1
			}else{
				y++;
			}
		}else if(step == 1){
			// Wichtig! Den sprung zum neuen Startpunkt wollen wir nicht zeigen
			gap = 1;
			// hier setzen wir unseren Y Startpunkt neu
			y = 0;
			// und gehen einen schritt weiter
			step++; // Step 2
	    }else if(step == 2){
	    	
	    }else if(step == 3){
	    	// Wichtig! Den sprung zum neuen Startpunkt wollen wir nicht zeigen
	    	gap = 1;
	    	// hier wird wieder ein neuer Startpunkt gesetzt
	    	y= 0;	    	
	    }else{
	    	
		
			/* 
			 * f(x) = a * sin(b * x + c) + d
			 * 
			 * a = Amplitude - Ausschlag nach oben und unten ((y Hochpunkt - y Tiefpunkt) / 2)
			 * b = 2* PI / Periode - (Periode = (y Hochpunkt - y Tiefpunkt) * 2)
			 * c = (x Hochpunkt + x Tiefpunkt) / 2 -> Verschiebung nach + links oder - rechts 
			 * d = (y Hochpunkt + y Tiefpunkt) / 2 -> Verschiebung des Graphen nach oben oder unten
			 * 
			 * */
			
			int a = 100;
			int b = 50;
			int c = 250;
			int d = 0;
	        
			y = (int) ((int) a * java.lang.Math.sin(Math.PI/b * (x+c) ) + d);
		}

		return y;  // horizontal line, y unchanged
	}
	
	public static int nextColor(){
		// unsere GAP Kontrolle 
		if(gap == 1){
			gap = 0;// da er ausgeführt wurde können wir ihn hier wieder ausschalten
			return EtchASketch.GAP;
		}
		
		// Abhängig von step ändern wir hier die Farbe 
		if(step == 0){
			return EtchASketch.BLUE;
	    }else if(step == 2){
	    	return EtchASketch.BLUE;
	    }else{
	    	return EtchASketch.GREEN;
	    }
	
	}
}
