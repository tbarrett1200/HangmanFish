import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import acm.graphics.GCanvas;

/*
 * File: HangmanView.java
 * Author: Thomas Barrett
 * Created: Feb 7, 2017
 */

public class HangmanView extends JFrame {

	public final int CANVAS_WIDTH = 600;
	public final int CANVAS_HEIGHT = 400;
	
	public GCanvas canvas = new GCanvas();
	private JLabel title = new JLabel("HANGMAN");
	private JLabel subtitle = new JLabel("The Fish Edition");
	
	public HangmanView(HangmanController controller) {
		add(canvas, BorderLayout.CENTER);
		setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		
		//the title
		canvas.add(title, 300,200);
		canvas.add(subtitle,300,220);
		
    }
}
