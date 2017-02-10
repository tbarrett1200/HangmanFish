package view;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GOval;


public class Letter extends GCompound {

	public Letter(int width, int height, char l){
		super();
		GOval bubble = new GOval(width, height);
		GLabel letter = new GLabel(Character.toString(l));
		
		bubble.setColor(Color.BLACK);
		bubble.setFillColor(Color.WHITE);
		bubble.setFilled(true);
		add(bubble);
		
		letter.setColor(Color.BLACK);
		letter.setFont(new Font("font", Font.BOLD, 14));
		add(letter,bubble.getWidth()/4,bubble.getHeight()-bubble.getHeight()/4);
	}
	
}
