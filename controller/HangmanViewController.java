package controller;

import model.Phrase;

/**
 * The methods needed to be implemented in order to control a hang-man game view
 * @author Thomas Barrett and Serena Riback
 * @since 7 February 2017
 */
public interface HangmanViewController {
	
	/**
	 * Called when a new game is started 
	 */
	public void didStartGame();
	 
	 /**
	  * Called when a letter is guessed
	  * @param c the guessed letter
	  */
	 public void didGuessLetter(char c);
	
	 /**
	  * @return the current hangman phrase
	  */
	 public Phrase getPhrase();

	 public String revealWord();
}
