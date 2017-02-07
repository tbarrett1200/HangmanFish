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
	view.setSize(600, 400);
	view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	view.setLocationRelativeTo(null);
	view.setVisible(true);
    }
    
    public static void main(String[] args) {
	new HangmanController();
    }
}
