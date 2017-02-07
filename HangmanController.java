/*
 * File: HangmanController.java
 * Author: Thomas Barrett
 * Created: Feb 7, 2017
 */

public class HangmanController {

    public HangmanView view = new HangmanView(this);
    public HangmanModel model = new HangmanModel(this);
    
    public HangmanController() {
	
    }
    
    public static void main(String[] args) {
	new HangmanController();
    }
}
