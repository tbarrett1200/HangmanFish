package view;

import acm.graphics.GCompound;

public class GuessedLetters extends GCompound{

	char c;
	
	public GuessedLetters(int width){
		super();
		int spacingWidth = width/26;
		int y=0;
		int x=0;
		for(int i=0; i<26; i++){
			c = (char)((int)'A' +i);
			x=i;
			if(i>12) y=20;
			if(i>12) x = i-13;
			add(new Letter(20,20,c), spacingWidth*x, y);
		}
	}
	
}
