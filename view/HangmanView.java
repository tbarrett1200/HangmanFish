package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
 * 
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

    private JLabel word;
    private JLabel title;
    private JLabel subtitle;
    private JLabel statusMessage;
    private JButton newGameButton;
    private FishingPole graphic;
    private GuessedLetters letters;

    private JPanel contentPanel;

    private HangmanViewController controller;

    public HangmanView(HangmanViewController controller) {
	this.controller = controller;
	setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
	addHangman();
	addContentPanel();
	addStatusMessage();
	addNewGameButton();

    }

    private void addStatusMessage() {
	statusMessage = new JLabel("Guess a letter");
	statusMessage.setFont(new Font("statusFont", Font.PLAIN, 20));
	add(statusMessage, BorderLayout.NORTH);
    }
    
    private void addNewGameButton() {
	newGameButton = new JButton("New Game");
	add(newGameButton, BorderLayout.SOUTH);
	newGameButton.addActionListener(action -> {
	    controller.didStartGame();
	    graphic.reset();
	    letters.reset();
	});
    }
	public void layoutWord() {
	    if (word != null) word.setLocation(wordCanvas.getWidth()/2,wordCanvas.getHeight()/2);
	}
	
	public void layoutTitle() {
		title.setLocation(titleCanvas.getWidth()/2, titleCanvas.getHeight()/2 - subtitle.getHeight());
		subtitle.setLocation(titleCanvas.getWidth()/2, titleCanvas.getHeight()/2 + title.getHeight()/3);
	}
	
	public void layoutLetter() {
		letters.setLocation(letterCanvas.getWidth()/2, letterCanvas.getHeight()/2);
	}

    private void addHangman() {
	graphic = new FishingPole(100, 300);
	graphic.setLocation(0, 0);
	hangmanCanvas.addComponentListener(new ComponentAdapter() {
	    @Override
	    public void componentResized(ComponentEvent e) {
		double width = graphic.getWidth();
		double height = graphic.getHeight();
		graphic.setLocation(hangmanCanvas.getWidth() / 2 - width / 2,
			hangmanCanvas.getHeight() / 2 - height / 2);
	    }
	});
	
	hangmanCanvas.add(graphic);
	hangmanCanvas.setBackground(Color.BLUE);
	hangmanCanvas.setPreferredSize(new Dimension(200, 400));
	add(hangmanCanvas, BorderLayout.WEST);
    }
    
    private void addTitle(JPanel panel) {
	 
	title = new JLabel("HANGMAN");
	title.setFont(new Font("titleFont", Font.BOLD, 50));
	panel.add(title);
	subtitle = new JLabel("The Fish Edition");
	subtitle.setFont(new Font("subtitleFont", Font.ITALIC, 25));
	panel.add(subtitle);
    }
    private void addContentPanel() {
	contentPanel = new JPanel();
	contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
	addTitle(contentPanel);
	addLetterCanvas(contentPanel);
	addWordCanvas(contentPanel);
	add(contentPanel, BorderLayout.CENTER);
    }
    
    private void addLetterCanvas(JPanel panel) {
	letters = new GuessedLetters(700);
	letterCanvas.setBackground(Color.RED);
	letterCanvas.setFocusable(true);
	letterCanvas.addKeyListener(this);
	letterCanvas.add(letters, 0, 0);
	letterCanvas.addComponentListener(new ComponentAdapter() {
	    @Override
	    public void componentResized(ComponentEvent e) {
		letters.resize(letterCanvas.getWidth());
	    }
	});
	panel.add(letterCanvas);
    }
    
    private void addWordCanvas(JPanel panel) {

	wordCanvas.setBackground(Color.GREEN);
	wordCanvas.addComponentListener(new ComponentAdapter() {
	    @Override
	    public void componentResized(ComponentEvent e) {
		layoutWord();
	    }
	});
	panel.add(wordCanvas);
    }
    public ProgressivelyDrawable getHangman() {
	return graphic;
    }

    public void displayPhrase(Phrase phrase) {
	if (word != null) wordCanvas.remove(word);
	word = new JLabel(phrase.toString());
	word.setFont(new Font("biggerAndPrettier", Font.BOLD, 35));
	wordCanvas.add(word);
	layoutWord();
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
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
