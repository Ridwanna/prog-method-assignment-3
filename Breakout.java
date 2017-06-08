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
private double PADDLE_WIDHT;



/* Method: run() */
	
		
	
/** Runs the Breakout program. */
	public void run() {
		//
		//to setup x and y cordinates
		int x = 2;
		int y = BRICK_Y_OFFSET;
		
		//to set up bricks and the placement
		//creating a loop for row and nesting the loop to create column
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
			x = BRICK_SEP / 2;
		}
		
		//setup Paddle
			int i = ((getWidth() /2) - PADDLE_WIDTH);
			double k = ((getHeight() /2) - (PADDLE_HEIGHT - (1.7)));
			
			//insert paddle
			GRect paddle = new GRect (i, k, PADDLE_WIDTH, PADDLE_HEIGHT);
			paddle.setFilled(true);
			add (paddle);
		}
	
}
		
	