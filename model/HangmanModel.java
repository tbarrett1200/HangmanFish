package model;

import controller.HangmanModelController;

/**
 * A hangman game model
 * @author Thomas Barrett and Serena Riback
 * @since February 7, 2017
 */
public class HangmanModel {

    //the dictionary of game words
    private final Dictionary dictionary = new Dictionary("dictionary.txt");    
    
    //the controller
    private final HangmanModelController controller;  
   
    //the amount of guesses remaining in current game
    private int guessesRemaining;    
   
    //the current game word
    private String source;  
   
    //the current state of the game word
    private Phrase phrase;
   
    //all letters that have already been guessed
    private String guessedLetters;
    
    private int numWins = 0;
    private int numGames = 0;
    
    /**
     * Constructs a new Hang-man game with the given controller
     * @param controller
     */
    public HangmanModel(HangmanModelController controller) {
    	this.controller = controller;
    	startNewGame();
    }
    
    /**
     * Starts a new game. 
     * A new words is chosen and the guess count resets
     */
    public void startNewGame() {
	
    	source = dictionary.getRandomWord().toUpperCase().trim();
        guessesRemaining = controller.maximumGuesses();
        phrase = new Phrase(source);
        guessedLetters = "";
    }
     
    /**
     * Guesses a letter and updates the game state appropriately
     * @param c the letter
     */
    public void guessLetter(char c) {
    	
    	if (hasWon() || hasLost()) return;
    	
    	c = Character.toUpperCase(c);
    	if (isLetterAvailable(c)) {
    		guessedLetters += c;
    		
    		if (phrase.guessLetter(c)) {
    			controller.didGuessCorrectly(c);
    			if (hasWon()) {
    			    numWins++;
			    numGames++;
    			    controller.didWinGame();  
    			}
    		}
    		else {
    			guessesRemaining--;
    			controller.didGuessIncorrectly(c);
    			if (hasLost()) {
    			    numGames++;
    			    controller.didLoseGame();
    			}
    		}
    	}
    }
    
    /**
     * @return the phrase, which represents the current state of the guesses
     */
    public Phrase getPhrase() {
    	return phrase;
    }
    
    /**
     * @return number of guesses remaining
     */
    public int getGuessesRemaining() {
    	return guessesRemaining;
    }
    
    public String getWord() {
	return source;
    }
    
    /**
     * Checks whether or not a letter has already been guessed
     * @param c the letter
     * @return true if not guessed, otherwise false
     */
    public boolean isLetterAvailable(char c) {
    	c = Character.toUpperCase(c);
    	return guessedLetters.indexOf(c) == -1;
    }
    
    /**
     * whether or not the game has been lost
     * @return true if lost, otherwise false
     */
    public boolean hasLost() {
    	return guessesRemaining <= 0;
    }
    
    /**
     * Returns whether or not the game has been won
     * @return true if won, otherwise false
     */
    public boolean hasWon() {
    	return phrase.isComplete();
    }

    /**
     * Returns the win percentage
     * @return
     */
    public double getWinPercentage() {
	return numGames > 0 ? (double) numWins / numGames : 0;
    }
}
