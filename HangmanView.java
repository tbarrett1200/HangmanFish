import java.awt.BorderLayout;

import javax.swing.JFrame;

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
	
	public HangmanView(HangmanController controller) {
		add(canvas, BorderLayout.CENTER);
		setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		
    }
}
