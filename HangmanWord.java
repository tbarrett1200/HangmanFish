
public class HangmanWord {

	private String source;
	private Character[] word;
	
	public HangmanWord(String source) {
		this.source = source;
		word = new Character[source.length()];
	}
	
	public boolean guessLetter(char c) {
		int index = -1;
		while ((index = source.indexOf(c, index+1)) != -1) word[index] = c;
		return source.indexOf(c) != -1;
	}
	
	public Character[] getCharacters() {
		return word;
	}
	
	public boolean isComplete() {
		for (Character c: word) {
			if (c == '_') return false;
		}
		return true;
	}
	
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
