package controller;
/**
 * The methods needed to be implemented in order to control a hang-man game model
 * @author Thomas Barrett
 * @since February 8th, 2017
 */
public interface HangmanModelController {

	/**
	 * Called when a correct guess is made.
	 * View should be updated in this method
	 */
	public void didGuessCorrectly(char c);  
	
	/**
	 * Called when a incorrect guess is made.
	 * View should be updated in this method
	 */
	public void didGuessIncorrectly(char c);
	
	/**
	 * Called when the hang-man game is won.
	 * View should be updated in this method
	 */
	public void didWinGame();
	
	/**
	 * Called when the hang-man game is lost.
	 * View should be updated in this method
	 */
	public void didLoseGame();
	
	public int maximumGuesses();
}
