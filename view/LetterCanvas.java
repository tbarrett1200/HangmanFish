package view;

import acm.graphics.GCanvas;

/**
 * A GCanvas 
 * @author Thomas Barrett and Serena Riback
 * @since 17 February 2017
 */
@SuppressWarnings("serial")
public class LetterCanvas extends GCanvas {

	private GGuessedLetters letters;
	
	/**
	 * Constructs a GCanvas with the given width and height
	 * displaying already guessed letters
	 * @param width the width of the canvas
	 * @param height the height of the canvas
	 */
	public LetterCanvas(int width, int height) {
		letters = new GGuessedLetters(width, height);
		add(letters);
	}
	
	@Override
	public void doLayout() {
		double x = getWidth() / 2 - letters.getWidth() / 2;
		double y = getHeight() / 2 - letters.getHeight() / 2;
		letters.setLocation(x, y);
	}
	
	/**
	 * Resets the GuessedLetter object setting all letters to white 
	 */
	public void reset() {
		letters.reset();
	}
	
	/**
	 * Grays out the given guessed letter
	 * @param c the letter to gray out
	 */
	public void guess(char c) {
		letters.setGrayedOut(c, true);
	}
}
