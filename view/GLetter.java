package view;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GOval;

/**
 * A bubbled letter on the screen that represents 
 * whether or not it has already been guessed
 * @author Thomas Barrett and Serena Riback
 * @since February 8th, 2017
 */
@SuppressWarnings("serial")
public class GLetter extends GCompound {

	private GOval bubble;
	private GLabel letter;
	
	/**
	 * Creates a Letter object
	 * @param width	the width in pixels
	 * @param height the height in pixels
	 * @param l	the letter
	 */
	public GLetter(int width, int height, char l){
		
		bubble = new GOval(width, height);
		bubble.setColor(Color.BLACK);
		bubble.setFillColor(Color.WHITE);
		bubble.setFilled(true);
		add(bubble);
		
		letter = new GLabel(Character.toString(l));
		letter.setColor(Color.BLACK);
		letter.setFont(new Font("font", Font.BOLD, 14));
		letter.setLocation(bubble.getWidth()/4, bubble.getHeight()-bubble.getHeight()/4);
		add(letter);
	}
	
	/**
	 * Sets whether or not the bubble is greyed out
	 * @param gray whether or not the letter has been guessed
	 */
	public void setGrayedOut(boolean gray){
		if (gray) {
			bubble.setFillColor(Color.LIGHT_GRAY);
		} else {
			bubble.setFillColor(Color.WHITE);
		}
	}
	
}
