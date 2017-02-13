package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import acm.graphics.GCanvas;
import controller.HangmanViewController;
import model.Phrase;

/**
 * A hang-man graphical user interface
 * @author Serena Riback
 * @since February 7th, 2017
 */
@SuppressWarnings("serial")

public class HangmanView extends JFrame implements KeyListener {

	private final int CANVAS_WIDTH = 600;
	private final int CANVAS_HEIGHT = 400;
	
	private GCanvas canvas = new GCanvas();
	private JLabel title = new JLabel("HANGMAN");
	private JLabel subtitle = new JLabel("The Fish Edition");
	private JLabel statusMessage = new JLabel("Guess a letter");
	private JButton newGameButton = new JButton("New Game");
	private FishingPole graphic;
	private GuessedLetters letters = new GuessedLetters(CANVAS_WIDTH);
	private JLabel word;
	
	private HangmanViewController controller;
	
	public HangmanView(HangmanViewController controller) {
		setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		canvas.setBackground(Color.CYAN);
		add(canvas, BorderLayout.CENTER);
		canvas.addKeyListener(this);
		this.canvas.setFocusable(true);
		this.controller = controller;
		
		//the title
		
		title.setFont(new Font("titleFont",Font.BOLD,50));
		subtitle.setFont(new Font("subtitleFont", Font.ITALIC,25));
		statusMessage.setFont(new Font("statusFont", Font.PLAIN,20));
		
		canvas.add(title, 280,25);
		canvas.add(subtitle,280,75);
		add(newGameButton, BorderLayout.SOUTH);
		newGameButton.addActionListener(action -> {
		    controller.didStartGame();
		    graphic.reset();
		});
		canvas.add(letters, 280,110);
		
	
		graphic = new FishingPole(100,300);
		graphic.setLocation(30, 30);
		canvas.add(graphic);
		
    }
	
	public ProgressivelyDrawable getHangman() {
	    return graphic;
	}
	
	public void displayPhrase(Phrase phrase){
		if(word != null) canvas.remove(word);
		word = new JLabel(phrase.toString());
		word.setFont(new Font("biggerAndPrettier", Font.BOLD,35));
		canvas.add(word,280,200);
	}


	@Override
	public void keyTyped(KeyEvent e) {
		char c = Character.toUpperCase(e.getKeyChar());
		if (c <= 'Z' && c >= 'A') {
			controller.didGuessLetter(c);
			letters.setGrayedOut(c, true);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
}
