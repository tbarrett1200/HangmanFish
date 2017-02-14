package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	private GCanvas titleCanvas = new GCanvas();
	private GCanvas letterCanvas = new GCanvas();
	private GCanvas hangmanCanvas = new GCanvas();
	private GCanvas wordCanvas = new GCanvas();
	
	private JLabel title = new JLabel("HANGMAN");
	private JLabel subtitle = new JLabel("The Fish Edition");
	private JLabel statusMessage = new JLabel("Guess a letter");
	private JButton newGameButton = new JButton("New Game");
	private FishingPole graphic;
	private GuessedLetters letters = new GuessedLetters(CANVAS_WIDTH);
	private JPanel contentPanel = new JPanel();
	private JLabel word;
	
	private HangmanViewController controller;
	
	public HangmanView(HangmanViewController controller) {
		this.controller = controller;
		setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		
	//the titles
		
		title.setFont(new Font("titleFont",Font.BOLD,50));
		subtitle.setFont(new Font("subtitleFont", Font.ITALIC,25));
		statusMessage.setFont(new Font("statusFont", Font.PLAIN,20));

		add(newGameButton, BorderLayout.SOUTH);
		newGameButton.addActionListener(action -> {
		    controller.didStartGame();
		    graphic.reset();
		    letters.reset();
		});
		letterCanvas.add(letters, CANVAS_WIDTH/2, 
				CANVAS_HEIGHT/(CANVAS_HEIGHT/6)+title.getHeight()+subtitle.getHeight()-subtitle.getHeight()/4);
		
	
		graphic = new FishingPole(100,300);
		graphic.setLocation(0, 0);
		
		hangmanCanvas.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
			double width = graphic.getWidth();
			double height = graphic.getHeight();
			graphic.setLocation(hangmanCanvas.getWidth()/2-width/2, hangmanCanvas.getHeight()/2-height/2);
		    }    
		});
		hangmanCanvas.add(graphic);		
		
		hangmanCanvas.setBackground(Color.BLUE);
		hangmanCanvas.setPreferredSize(new Dimension(200,400));
		add(hangmanCanvas, BorderLayout.WEST);
		
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		add(contentPanel, BorderLayout.CENTER);
		
		titleCanvas.setBackground(Color.CYAN);
		contentPanel.add(titleCanvas);
	
		title.setFont(new Font("titleFont",Font.BOLD,50));
		subtitle.setFont(new Font("subtitleFont", Font.ITALIC,25));
		statusMessage.setFont(new Font("statusFont", Font.PLAIN,20));
		
		titleCanvas.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
			layoutTitle();
		    }    
		});
		titleCanvas.add(title);
		titleCanvas.add(subtitle);
		
		letterCanvas.setBackground(Color.RED);
		letterCanvas.setFocusable(true);
		letterCanvas.addKeyListener(this);
		letterCanvas.add(letters, 0,0);
		contentPanel.add(letterCanvas);

		wordCanvas.setBackground(Color.GREEN);
		wordCanvas.addComponentListener(new ComponentAdapter() {
		    @Override
		    public void componentResized(ComponentEvent e) {
			layoutWord();
		    }    
		});
		contentPanel.add(wordCanvas);

		add(newGameButton, BorderLayout.SOUTH);
		newGameButton.addActionListener(action -> {
		    controller.didStartGame();
		    graphic.reset();
		    letters.reset();
		});
		
	
		
    }
	
	public ProgressivelyDrawable getHangman() {
	    return graphic;
	}
	
	public void displayPhrase(Phrase phrase){
		if(word != null) wordCanvas.remove(word);
		word = new JLabel(phrase.toString());
		word.setFont(new Font("biggerAndPrettier", Font.BOLD,35));
		layoutWord();
		wordCanvas.add(word);
	}

	public void layoutWord() {
	    word.setLocation(wordCanvas.getWidth()/2,wordCanvas.getHeight()/2);
	}
	
	public void layoutTitle() {
		title.setLocation(titleCanvas.getWidth()/2, titleCanvas.getHeight()/2 - subtitle.getHeight());
		subtitle.setLocation(titleCanvas.getWidth()/2, titleCanvas.getHeight()/2 + title.getHeight());
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
