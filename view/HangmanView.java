package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.HangmanViewController;

import model.Phrase;

/**
 * A hang-man graphical user interface
 * 
 * @author Thomas Barrett and Serena Riback
 * @since February 7th, 2017
 */
@SuppressWarnings("serial")

public class HangmanView extends JFrame implements KeyListener {

    private final int CANVAS_WIDTH = 600;
    private final int CANVAS_HEIGHT = 400;
    
    public HangmanPanel hangman;
    private JLabel message;
    private JButton newGameButton;
    private JLabel winPercentage;
    private HangmanViewController controller;

    private BackgroundPanel background;
    
    public HangmanView(HangmanViewController controller) {
    	this.controller = controller;
    	setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
    	
    	hangman = new HangmanPanel(600, 400);
     	hangman.setFocusable(true);
    	hangman.requestFocusInWindow();
    	hangman.addKeyListener(this);
    	add(hangman);
    	
    	hangman.addFocusListener(new FocusAdapter(){
    		@Override
    		public void focusLost(FocusEvent e) {
               hangman.requestFocusInWindow();
             }
    	});
    
    	JPanel south = new JPanel();
    	add(south, BorderLayout.SOUTH);

    	addStatusMessage();
    	addWinPercentageLabel(south);
    	addNewGameButton(south);
    }
    
    public void updateWinPercentage() {
	winPercentage.setText("Percent wins: " + controller.winPercentage()*100 + "%");
    }
    
    public void revealWord(String s) {
	hangman.word.setText(s);
    }

    private void addStatusMessage() {
    	message = new JLabel("Guess a letter");
    	message.setFont(new Font("statusFont", Font.PLAIN, 20));
    	message.setOpaque(false);
    	message.setForeground(Color.BLACK);
		add(message, BorderLayout.NORTH);
    }
    
    private void addWinPercentageLabel(JPanel p){
    	winPercentage = new JLabel("Percent wins: 0%");
    	p.add(winPercentage);
    }

    private void addNewGameButton(JPanel p) {
    	newGameButton = new JButton("New Game");
    	p.add(newGameButton);
    	newGameButton.addActionListener(action -> {
    		controller.didStartGame();
    		hangman.reset();
    		message.setText("Guess A Letter!");
    		displayPhrase(controller.getPhrase());
    	});
    }
	

    @Override
    public void keyTyped(KeyEvent e) {
	char c = Character.toUpperCase(e.getKeyChar());
		if (c <= 'Z' && c >= 'A') {
			controller.didGuessLetter(c);
		}
    }


	public void displayPhrase(Phrase phrase) {
		hangman.word.setText(phrase.toString());
	}

	public ProgressivelyDrawable getHangman() {
		return hangman.pole.getProgressivelyDrawable();
	}
	

   
	public void displayLoseMessage() {
		message.setText("You Lose!");
		
	}
	
	public void displayWinMessage() {
		message.setText("You Win!");		
	}
	
	@Override
	  public void keyPressed(KeyEvent e) {
	}

	@Override
	  public void keyReleased(KeyEvent e) {
	 }

}
