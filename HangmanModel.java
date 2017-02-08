/*
 * File: HangmanModel.java
 * Author: Thomas Barrett
 * Created: Feb 7, 2017
 */

public class HangmanModel {

    private final Dictionary dictionary = new Dictionary("dictionary.txt");
    private final int MAX_GUESSES = 5;  
    private final HangmanController controller;
    
    private int guessesRemaining;
    private String source;
    private HangmanPhrase phrase;
    private String guessedLetters;
    
    public HangmanModel(HangmanController controller) {
    	this.controller = controller;
    	startNewGame();
    }
    
    public void startNewGame() {
    	source = dictionary.getRandomWord().toUpperCase().trim();
        guessesRemaining = MAX_GUESSES;
        phrase = new HangmanPhrase(source);
        guessedLetters = "";
    }
     
    public void guessLetter(char c) {
    	c = Character.toUpperCase(c);
    	if (isLetterAvailable(c)) {
    		guessedLetters += c;
    		
    		if (phrase.guessLetter(c)) {
    			controller.didGuessCorrectly();
    			if (didWin()) controller.didWinGame();
    		}
    		else {
    			guessesRemaining--;
    			controller.didGuessIncorrectly();
    			if (didLose()) controller.didLoseGame();
    		}
    	}
    }
    
    public boolean didLose() {
    	return guessesRemaining <= 0;
    }
    
    public boolean didWin() {
    	return phrase.isComplete();
    }
    
    public HangmanPhrase getPhrase() {
    	return phrase;
    }
    
    public int getGuesses() {
    	return guessesRemaining;
    }
    
    public boolean isLetterAvailable(char c) {
    	c = Character.toUpperCase(c);
    	return guessedLetters.indexOf(c) == -1;
    }
}
