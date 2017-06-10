/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

import com.sun.org.apache.xml.internal.security.Init;

public class Breakout extends GraphicsProgram {

	/** Width and height of application window in pixels */
    public static final int APPLICATION_WIDTH = 400;
    public static final int APPLICATION_HEIGHT = 600;
 
/** Dimensions of game board (usually the same) */
    private static final int WIDTH = APPLICATION_WIDTH;
    private static final int HEIGHT = APPLICATION_HEIGHT;
 
/** Dimensions of the paddle */
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;
 
/** Offset of the paddle up from the bottom */
    private static final int PADDLE_Y_OFFSET = 30;
 
/** Number of bricks per row */
    private static final int NBRICKS_PER_ROW = 10;
 
/** Number of rows of bricks */
    private static final int NBRICK_ROWS = 10;
     
/** Total number of bricks */
    private static final int TOTAL_BRICKS = NBRICK_ROWS * NBRICKS_PER_ROW;
 
/** Separation between bricks */
    private static final int BRICK_SEP = 4;
 
/** Width of a brick */
    private static final int BRICK_WIDTH =
      (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;
 
/** Height of a brick */
    private static final int BRICK_HEIGHT = 8;
 
/** Radius of the ball in pixels */
    private static final int BALL_RADIUS = 10;
 
/** Offset of the top brick row from the top */
    private static final int BRICK_Y_OFFSET = 70;
 
/** Number of turns */
    private static final int NTURNS = 3;
 
/**create an instance variable gobj */
    private static GObject gobj;
    
    /**create an instance variable gobj */
    private static GPoint last;
    
/** Create a GRect instance */  
    private GRect PADDLE;
 

/* Method: run() */
	
		
	
/** Runs the Breakout program. */
	public void run() {
		createBricks();
		getPaddle();
		
}

 


		private void createBricks() {
		
			//the following program creates bricks
			
			//to setup x and y cordinates
			int x = 2;
			int y = BRICK_Y_OFFSET;
			
			/*to set up bricks and the placement
			*creating a loop for row and nesting the loop to create column
			*/
			
			for (int row = 0; row < NBRICK_ROWS; row++) 	{
				//create another loop for column
				for (int column = 0; column < NBRICKS_PER_ROW; column++)	{
					//add bricks
					GRect bricks = new GRect (BRICK_WIDTH, BRICK_HEIGHT);
					bricks.setFilled(true);
					//set brickc colors
					if (row < 2){
						bricks.setColor(Color.RED);
					} else if (row < 4)	{
						bricks.setColor(Color.ORANGE);
					} else if (row < 6) 	{
						bricks.setColor(Color.YELLOW);
					} else if (row < 8)	{
						bricks.setColor(Color.GREEN);
					} else if (row < 10)	{
						bricks.setColor(Color.CYAN);
					}
					add (bricks, x, y);
					
					//state the width of brick and distance between individual brick to the other along the x-axis
					x += BRICK_WIDTH + BRICK_SEP;
				}
				/*state the height of brick and distance 
				*between individual brick to the other along the x-axis 
				*and also returning to the first loop
				*/
				y += BRICK_HEIGHT + BRICK_SEP;
				x = 2;
	}	
	
	
}



		/*to create paddle
		 * as a private method 
		 * and to also add mouse function
		 */
		public Init getPaddle() {
			double i = (getWidth() / 2- PADDLE_WIDTH/2);
			double k = (getHeight() - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
			
			//insert paddle
			PADDLE = new GRect (PADDLE_WIDTH, PADDLE_HEIGHT);
			PADDLE.setFilled(true);
			add (PADDLE, i, k);
			addMouseListeners();
			return null;
			}

		
		// makes paddle move
	    public void mouseClicked(MouseEvent e) {
	    	last = new GPoint(e.getPoint());
	    	gobj = getElementAt(last);
	    	//
	    	if (gobj == PADDLE){
	    		PADDLE.move((getWidth() - getX()) /2, (getHeight() - getY()) / 2);
	    }
	}
}
		

































