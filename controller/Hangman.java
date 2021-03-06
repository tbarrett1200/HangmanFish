package controller;
import java.awt.Dimension;

import javax.swing.JFrame;

import model.HangmanModel;
import model.Phrase;
import view.HangmanView;

/**
 * 
 * @author thomasbarrett
 *
 */
public class Hangman implements HangmanModelController, HangmanViewController {

    public HangmanView view = new HangmanView(this);
    public HangmanModel model = new HangmanModel(this);
    
    /**
     * Creates a Hangman Game
     */
    public Hangman() {
    	view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	view.setLocationRelativeTo(null);
    	view.setMinimumSize(new Dimension(600, 400));
    	view.setVisible(true);
    	view.displayPhrase(model.getPhrase());
    }
    
    //********** Model Events **********//
    
    @Override
    public void didGuessCorrectly(char c) {
    	view.displayPhrase(model.getPhrase());
		view.hangman.letters.guess(c);
    }
    
    @Override
    public void didGuessIncorrectly(char c) {
    	view.getHangman().drawNextPart();
		view.hangman.letters.guess(c);
    }
    
    @Override
    public void didWinGame() {
    	view.displayWinMessage();
    	view.updateWinPercentage();
    }
    
    @Override
    public void didLoseGame() {
    	view.displayLoseMessage();
    	view.revealWord(model.getWord());
    	view.updateWinPercentage();
    }
    
    @Override
    public int maximumGuesses() {
    	return view.getHangman().getMaxParts();
    }
    
    //********** View Events **********//
    
    @Override
    public void didStartGame() {
    	model.startNewGame();
    }
    
    @Override
    public void didGuessLetter(char c) {
    	model.guessLetter(c);
    }

    @Override
    public Phrase getPhrase() {
    	return model.getPhrase();
    }
    
    @Override
    public String revealWord() {
	return model.getWord();
    }

    @Override
    public double winPercentage() {
	return model.getWinPercentage();
    }
    //********************************//
    
    public static void main(String[] args) {
    	new Hangman();
    }

}
