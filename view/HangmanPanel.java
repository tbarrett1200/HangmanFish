package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * A JPanel with a background image that lays out child JPanels
 * @author Thomas Barrett and Serena Riback
 * @since 17 February 2017
 */
@SuppressWarnings("serial")
public class HangmanPanel extends BackgroundPanel {

    FishingPoleCanvas pole = new FishingPoleCanvas(100,300);
    JLabel title = new JLabel("HANGMAN", JLabel.CENTER);
    JLabel subtitle = new JLabel("The Fish Edition", JLabel.CENTER);
    public LetterCanvas letters = new LetterCanvas(400, 100);
    JLabel word = new JLabel("", JLabel.CENTER);
	
	public HangmanPanel(int width, int height) {
		super("background.jpg");
		
		setLayout(null);
		setMinimumSize(new Dimension(width,height));
        setPreferredSize(new Dimension(width,height));
       
        pole.setOpaque(false);       
        title.setFont(new Font("titleFont", Font.BOLD, 50));
        title.setForeground(Color.WHITE);  	
    	subtitle.setFont(new Font("subtitleFont", Font.ITALIC, 25));
    	subtitle.setForeground(Color.WHITE);	
    	letters.setOpaque(false);
    	word.setFont(new Font("biggerAndPrettier", Font.BOLD, 35));
    	word.setOpaque(false);
    	word.setForeground(Color.white);
    	
        add(pole);
        add(title);
        add(subtitle);
        add(letters);
        add(word); 
	}
	
	public void doLayout() {  
		int width = getWidth();
		int height = getHeight();
		
        pole.setLocation(0, 0);
        pole.setSize(width/3, height);
        
        title.setLocation(width/3, 10);
        title.setSize(width-width/3, 50);
        
        subtitle.setLocation(width/3, 60);
        subtitle.setSize(width-width/3, 30);
        
        letters.setLocation(width/3, 90);
        letters.setSize(width-width/3, 100);
        
        word.setLocation(width/3, letters.getY()+letters.getHeight());
        word.setSize(width-width/3, (int) (height-word.getLocation().getY()));
	}

	public void reset() {
		letters.reset();
		pole.reset();
	}	
}
