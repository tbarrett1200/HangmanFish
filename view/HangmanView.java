package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

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
public class HangmanView extends JFrame {

	private final int CANVAS_WIDTH = 600;
	private final int CANVAS_HEIGHT = 400;
	
	private GCanvas canvas = new GCanvas();
	private JLabel title = new JLabel("HANGMAN");
	private JLabel subtitle = new JLabel("The Fish Edition");
	
	private HangmanViewController controller;
	
	public HangmanView(HangmanViewController controller) {
		this.controller = controller;
		add(canvas, BorderLayout.CENTER);
		setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		
		//the title
		canvas.add(title, 300,200);
		canvas.add(subtitle,300,220);
		
    }
}
