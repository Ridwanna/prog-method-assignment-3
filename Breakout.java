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

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;



/* Method: run() */
	
		
	
/** Runs the Breakout program. */
	public void run() {
		//
		
		double x = 0.5;
		double y = (BRICK_Y_OFFSET);
		
		
		 for (int row = 0; row < NBRICK_ROWS; row++ ){
			 	getRow(x, y, (NBRICK_ROWS));
			 	y += NBRICKS_PER_ROW + BRICK_SEP;
			 	
		 	}
	}
		
	
	
	
		private void getRow(double x, double y, int bricks) {
			for (int i = 0; i < bricks; i++) {
				getBrick((x + i * BRICK_WIDTH), y);
				x += NBRICKS_PER_ROW + BRICK_SEP;
				
			}
	}



		//
		private void getBrick(double d, double y) {
			GRect rect = new GRect(WIDTH, y, BRICK_WIDTH, BRICK_HEIGHT);
			rect.setFilled (false);;
			add (rect);
			// TODO Auto-generated method stub
			
		}




			
	

	
}
		
	
	
	
			
	


