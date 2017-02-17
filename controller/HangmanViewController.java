package controller;

import model.Phrase;

public interface HangmanViewController {
	 public void didStartGame();
	 public void didGuessLetter(char c);
	 public Phrase getPhrase();

}
