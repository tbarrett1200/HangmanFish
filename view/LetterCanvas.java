package view;

import acm.graphics.GCanvas;

@SuppressWarnings("serial")
public class LetterCanvas extends GCanvas {

	public GuessedLetters letters;
	
	public LetterCanvas(int width, int height) {
		letters = new GuessedLetters(width, height);
		add(letters);
	}
	
	public void doLayout() {
		double x = getWidth() / 2 - letters.getWidth() / 2;
		double y = getHeight() / 2 - letters.getHeight() / 2;
		letters.setLocation(x, y);
	}
	
	
}
