package controller;
import javax.swing.JFrame;

import model.HangmanModel;
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
    	view.setVisible(true);
    }
    
    //********** Model Events **********//
    
    @Override
    public void didGuessCorrectly() {
    	//updateWord(model.getPhrase)
    }
    
    @Override
    public void didGuessIncorrectly() {
    	view.getHangman().drawNextPart();
    }
    
    @Override
    public void didWinGame() {
    	
    }
    
    @Override
    public void didLoseGame() {

    }
      
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
    public boolean hasBeenGuessed(char c) {
	// TODO Auto-generated method stub
	return false;
    }
    
    //********************************//
    
    public static void main(String[] args) {
    	new Hangman();
    }

    /* (non-Javadoc)
     * @see controller.HangmanViewController#hasBeenGuessed(char)
     */

}
