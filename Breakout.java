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
double x = 0.5;
		
		double y = (BRICK_Y_OFFSET);
		
		for (int row = 0; row <NBRICK_ROWS; row++) {
			Color color = null;
			if(row<2){
				color = Color.RED;
			} else if (row <=3) {
				color = Color.ORANGE;
			} else if (row<=5){
				color = Color.YELLOW;
			} else if (row<=7){
				color = Color.GREEN;
			} else {
				color = Color.CYAN;
			}
			getRow(x, y, (NBRICK_ROWS ), color);
			y += BRICK_HEIGHT + BRICK_SEP;
			
		}
			
	}
	
	private void getRow(double x, double y, int bricks, Color color) {
		for (int i = 0; i < bricks; i++) {
			getBrick((x + i * BRICK_WIDTH), y, color);
			x += BRICK_SEP;
			
		}
		
	}
	
	private void getBrick(double x, double y, Color color) {
		GRect rect = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
		rect.setFilled(true);
		rect.setColor(color);
		add(rect);
	
		
	}
	
	public void init() {
		addMouseListeners();
		double x = ((getWidth() /2)-PADDLE_WIDTH);
		double y = ((getHeight() /2)-PADDLE_HEIGHT * (-23));
		GRect mousePaddle = new GRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
		mousePaddle.setFillColor(Color.GRAY);
		mousePaddle.setFilled(true);
		add(mousePaddle);
		
		
	}
	
	public void mousePressed (MouseEvent e) {
		last = new GPoint(e.getPoint());
		gobj = getElementAt(last);
	}
		
	public void mouseDragged (MouseEvent e) {
		if (e.getX() <= (getWidth() - PADDLE_WIDTH)){
			if (gobj != null) {
				gobj.move(e.getX() - last.getX(), 0);
				last = new GPoint(e.getPoint());
			}
		}
	
	}
	private GObject gobj;
	private GPoint last;
	private RandomGenerator rgen = RandomGenerator.getInstance();
}
		
	
	
	
			
	


