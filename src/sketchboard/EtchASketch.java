package sketchboard;
 
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Kreis.DrawingInstructor;

/**A frame for imitating the game Etch-A-Sketch.
 * @author Ilse schmiedecke
 * @author Christoph Knabe
 * @version 2014-11-07
 */
@SuppressWarnings("serial")
public class EtchASketch extends JFrame {
	
	/**Use GAP as color code if you want to move the pen without drawing.*/
	public static final int GAP = 99999;
	
	/**Color codes for drawing.*/
	public static final int BLACK = 0,
					  		BLUE = 1,
					  		RED = 2,
					  		GREEN = 3,
					  		YELLOW = 4, 
					  		WHITE = 5;
	
	/**Use transparent color for gaps. Knabe 2014-11-06*/
	private static final Color _transparent = new Color(0, 0, 0, 0);
	
	/**The graphics context into which we draw*/
	private final Graphics graphics;
	
	/**The last sketchboard coordinates, where our pen stopped.*/
	int lastX = translateX(0), lastY = translateY(0);
	
	public EtchASketch() {
		this.setTitle("Etch A Sketch: "+DrawingInstructor.getTitle());
		this.setSize(500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		graphics = this.getGraphics();
	}

	private void setColor(final int colorCode) {
		final Color color;
		switch (colorCode) {
			case BLACK: color = Color.BLACK; break;
			case BLUE: 	color = Color.BLUE; break;
			case RED:	color = Color.RED; break;
			case GREEN:	color = Color.GREEN; break;
			case YELLOW:color = Color.YELLOW; break;
			case WHITE:	color = Color.WHITE; break;
			case GAP:	color = _transparent; break;
			default:	color = Color.GRAY;
		}
		graphics.setColor(color);
	}
	
	private void setStartingPoint() {
		final int firstX = DrawingInstructor.firstX(this.getWidth()/2);
		final int firstY = DrawingInstructor.firstY(this.getHeight()/2);
		lastX = translateX(firstX);
		lastY = translateY(firstY);
	}
	
	/** Get next x and y coordinates and color; then draw line up to them using the color, unless GAP */
	private void drawLine() {
		final int x = DrawingInstructor.nextX(this.getWidth()/2);
		final int y = DrawingInstructor.nextY(this.getHeight()/2);
		setColor(DrawingInstructor.nextColor());
		final int sketchboardX = translateX(x);
		final int sketchboardY = translateY(y);
		if(DrawingInstructor.nextColor() == GAP){
			System.out.println("MainX: " + x);
			System.out.println("MainY: " + y);
		}
		if (isVisible(sketchboardX, sketchboardY)) {	
			graphics.drawLine(lastX, lastY, sketchboardX, sketchboardY);  // draw to here
		}
		lastX = sketchboardX;       // next line starts here
		lastY = sketchboardY;		
	}
	
	/** translate pixel coordinates into sketchboard coordinates */	
	private int translateX(int coordinate) {
		return this.getWidth()/2 + coordinate;
	}
	/** translate pixel coordinates into sketchboard coordinates */
	private int translateY(int coordinate) {
		return this.getHeight()/2 - coordinate;
	}
	
	/** find out whether point is within sketchboard. */
	private boolean isVisible(int x, int y){
		return !(x<0 || y<0 || x>this.getWidth() || y>this.getHeight());
	}	
	
	/**Starting method of the program*/
	public static void main(String[] args) throws InterruptedException {
		final EtchASketch board = new EtchASketch();
		board.setStartingPoint();
		while (true){	
			board.drawLine();
		    Thread.sleep(5);
		}
	}

}
