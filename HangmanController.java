import javax.swing.JFrame;

/*
 * File: HangmanController.java
 * Author: Thomas Barrett
 * Created: Feb 7, 2017
 */

public class HangmanController {

    public HangmanView view = new HangmanView(this);
    public HangmanModel model = new HangmanModel(this);
    
    public HangmanController() {
    	view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	view.setLocationRelativeTo(null);
    	view.setVisible(true);
    }
    
    //******** Model Events *******//
    
    public void didGuessCorrectly() {
    	
    }
    
    public void didGuessIncorrectly() {

    }
    
    public void didWinGame() {
    	
    }
    
    public void didLoseGame() {

    }
      
    //******* View Events *******//
    
    
    public static void main(String[] args) {
    	new HangmanController();
    }
}
