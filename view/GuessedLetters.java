package view;

import acm.graphics.GCompound;

/**
 * A graphics object which displays all the letters in the alphabet, 
 * and whether or not they have been guessed
 * @author Serena Riback
 * @since February 8th, 2017
 */
@SuppressWarnings("serial")
public class GuessedLetters extends GCompound{

	Letter[] letters = new Letter[26];
	
	/**
	 * Creates the GuessedLetters with the given width
	 * @param width the width in pixels
	 */
	public GuessedLetters(int width, int height){
		int spacingWidth = width / 26;
		int x = 0, y = 0;
		for(int i = 0; i < 26; i++){
			char c = (char) ('A' + i);
			letters[i] = new Letter(20,20,c);
			add(letters[i]);
		}
		resize(width);
	}
	
	/**
	 * Sets a bubble with the given letter to be grayed out or not
	 * @param c	the letter the set
	 * @param gray	whether or not the bubble should be grey
	 */
	public void setGrayedOut(char c, boolean gray){
		letters[c-'A'].setGrayedOut(gray);
	}
	
	public void resize(double width) {
	    double letterRatio = 0.75;
	    double letterSize = width * letterRatio;
	    double individualLetter = letterSize/13;
	    double letterGap = (width - letterSize)/15;
	    
	    for(int i = 0; i < 13; i++){
		double x = i*letterGap + i*individualLetter;
		double y = 0;
		letters[i].setLocation(x, y);
	    }
	    for(int i = 0; i < 13; i++){
		double x = i*letterGap + i*individualLetter;
		double y = letterGap + individualLetter;
		letters[i+13].setLocation(x, y);
	    }
	}
	
	public void reset(){
		for(Letter l: letters){
			l.setGrayedOut(false);
		}
	}
	
}
