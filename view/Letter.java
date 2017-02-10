package view;

import java.awt.Color;
import java.awt.Font;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GOval;


public class Letter extends GCompound {

	GOval bubble;
	
	public Letter(int width, int height, char l){
		super();
		bubble = new GOval(width, height);
		GLabel letter = new GLabel(Character.toString(l));
		
		bubble.setColor(Color.BLACK);
		bubble.setFillColor(Color.WHITE);
		bubble.setFilled(true);
		add(bubble);
		
		letter.setColor(Color.BLACK);
		letter.setFont(new Font("font", Font.BOLD, 14));
		add(letter,bubble.getWidth()/4,bubble.getHeight()-bubble.getHeight()/4);
	}
	
	public void grayOut(){
		bubble.setFillColor(Color.LIGHT_GRAY);
		bubble.setFilled(true);
	}
	
}
