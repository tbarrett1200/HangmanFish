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

/**
 * A hang-man graphical user interface
 * @author Serena Riback
 * @since February 7th, 2017
 */
@SuppressWarnings("serial")
public class HangmanView extends JFrame implements KeyListener{

	private final int CANVAS_WIDTH = 600;
	private final int CANVAS_HEIGHT = 400;
	
	private GCanvas canvas = new GCanvas();
	private JLabel title = new JLabel("HANGMAN");
	private JLabel subtitle = new JLabel("The Fish Edition");
	private JLabel statusMessage = new JLabel("Guess a letter");
	private JButton newGameButton = new JButton("New Game");
	private FishingPole graphic = new FishingPole(100,300);
	private GuessedLetters letters = new GuessedLetters(CANVAS_WIDTH);
	
	private HangmanViewController controller;
	
	public HangmanView(HangmanViewController controller) {
		this.controller = controller;
		addKeyListener(this);
		add(canvas, BorderLayout.CENTER);
		setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		
		//the title
		
		title.setFont(new Font("titleFont",Font.BOLD,50));
		subtitle.setFont(new Font("subtitleFont", Font.ITALIC,25));
		statusMessage.setFont(new Font("statusFont", Font.PLAIN,20));
		
		
		canvas.add(title, 280,25);
		canvas.add(subtitle,280,75);
		add(newGameButton, BorderLayout.SOUTH);
		
		canvas.add(letters, 280,110);
		
		//graphic.setVisible(true);
		//canvas.add(graphic,50,50);
		//canvas.add(statusMessage, CANVAS_WIDTH/2, 300); for now
		
    }
	
	public ProgressivelyDrawable getHangman() {
	    return graphic;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		controller.didGuessLetter(e.getKeyChar());
		letters.greyOutLetter(Character.toUpperCase(e.getKeyChar()));
		System.out.println("hello is this working");
	}
	
	
}
