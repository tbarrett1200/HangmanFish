package model;
/**
 * A single word to be used in a hang-man game. 
 * Its letters are revealed after they are guessed
 * @author Thomas Barrett
 * @since February 7th 2017
 */
public class Word {

	//the source word
	private String source;
	
	//unguessed letter indices are null
	private Character[] word; 
	
	/**
	 * Constructs a Word from the given source String
	 * @param source the String to represent
	 */
	public Word(String source) {
		this.source = source;
		word = new Character[source.length()];
	}
	
	/**
	 * Reveals all instances of the letter and returns 
	 * whether or not the letter is in the word
	 * @param c the letter to guess
	 * @return true if the word contains the letter, false otherwise
	 */
	public boolean guessLetter(char c) {
		int index = -1;
		while ((index = source.indexOf(c, index+1)) != -1) word[index] = c;
		return source.indexOf(c) != -1;
	}
	
	/**
	 * Returns a Character array representing the word.
	 * All unguessed letters are replaced with null
	 * @return the Character array
	 */
	public Character[] getCharacters() {
		return word;
	}
	
	/**
	 * Checks whether or not there are unguessed letters in the word
	 * @return true if there are unguessed letters, false otherwise
	 */
	public boolean isComplete() {
		for (Character c: word) {
			if (c == '_') return false;
		}
		return true;
	}
	

	/**
	 * Returns a string representation of the word.
	 * All unguessed letters are replaced with an underscore
	 */
	@Override
	public String toString() {
		String s = "";
		for (Character c: word) {
			if (c==null) s+='_';
			else s+= c;
		}
		return s;
	}
}
