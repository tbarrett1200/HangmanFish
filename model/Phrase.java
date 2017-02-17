package model;
/**
 * A single phrase, consisting of one ore more words, to be used in a hang-man game. 
 * Its letters are revealed after they are guessed
 * @author Thomas Barrett and Serena Riback
 * @since February 7th 2017
 */
public class Phrase {

	//the source string
	private String source;
	
	//the component words
	private Word[] words;
	
	/**
	 * Constructs a phrase from the given source string
	 * @param source the source string to represent
	 */
	public Phrase(String source) {
		this.source = source;
		String[] splitSource = source.split(" ");
		words = new Word[splitSource.length];
		for(int i=0; i< words.length; i++) {
			words[i] = new Word(splitSource[i]);
		}
	}
	
	/**
	 * Reveals all instances of the letter and returns 
	 * whether or not the letter is in the phrase
	 * @param c the letter to guess
	 * @return true if the phrase contains the letter, false otherwise
	 */
	public boolean guessLetter(char c) {
		for (Word word: words) word.guessLetter(c);
		return source.indexOf(c) != -1;
	}
	
	/**
	 * Returns all of the words in the phrase
	 * @return the words in the phrase
	 */
	public Word[] getWords() {
		return words;
	}
	
	
	/**
	 * Checks whether or not there are unguessed letters in the phrase
	 * @return true if there are unguessed letters, false otherwise
	 */
	public boolean isComplete() {
		for (Word word: words) {
			if (!word.isComplete()) return false;
		}
		return true;
	}
	
	/**
	 * Returns a string representation of the phrase.
	 * All unguessed letters are replaced with an underscore
	 */
	@Override
	public String toString() {
		String s = "";
		for (Word w: words) s+=w+" ";
		return s.trim();
	}
}
