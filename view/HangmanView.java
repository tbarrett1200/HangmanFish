package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FocusTraversalPolicy;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import acm.graphics.GCanvas;
import controller.HangmanViewController;
import model.Phrase;

/**
 * A hang-man graphical user interface
 * 
 * @author Serena Riback
 * @since February 7th, 2017
 */
@SuppressWarnings("serial")

public class HangmanView extends JFrame implements KeyListener {

    private final int CANVAS_WIDTH = 600;
    private final int CANVAS_HEIGHT = 400;
    
    public HangmanPanel hangman;
    private JLabel message;
    private JButton newGameButton;
    private HangmanViewController controller;

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
    

    	addStatusMessage();
    	addNewGameButton();
    }

    private void addStatusMessage() {
    	message = new JLabel("Guess a letter");
    	message.setFont(new Font("statusFont", Font.PLAIN, 20));
    	message.setOpaque(false);
    	message.setForeground(Color.BLACK);
		add(message, BorderLayout.NORTH);
    }
    

    private void addNewGameButton() {
    	newGameButton = new JButton("New Game");
    	add(newGameButton, BorderLayout.SOUTH);
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
		return hangman.pole.fishingPole;
	}
	

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

	public void didLoseGame() {
		message.setText("You Lose!");
		
	}
	
	public void didWinGame() {
		message.setText("You Win!");		
	}
}
