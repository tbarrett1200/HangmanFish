/*
 * File: HangmanModel.java
 * Author: Thomas Barrett
 * Created: Feb 7, 2017
 */

public class HangmanModel {

    private Dictionary dictionary = new Dictionary("dictionary.txt");
    private String word = dictionary.getRandomWord();
    
    public HangmanModel(HangmanController controller) {
	System.out.println(word);
    }
}
