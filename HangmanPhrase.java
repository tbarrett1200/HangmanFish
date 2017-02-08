
public class HangmanPhrase {

	private String source;
	private HangmanWord[] words;
	
	public HangmanPhrase(String source) {
		this.source = source;
		String[] splitSource = source.split(" ");
		words = new HangmanWord[splitSource.length];
		for(int i=0; i< words.length; i++) {
			words[i] = new HangmanWord(splitSource[i]);
		}
	}
	
	public boolean guessLetter(char c) {
		for (HangmanWord word: words) word.guessLetter(c);
		return source.indexOf(c) != -1;
	}
	
	public HangmanWord[] getWords() {
		return words;
	}
	
	public boolean isComplete() {
		for (HangmanWord word: words) {
			if (!word.isComplete()) return false;
		}
		return true;

	}
	
	@Override
	public String toString() {
		String s = "";
		for (HangmanWord w: words) s+=w+" ";
		return s.trim();
	}
}
