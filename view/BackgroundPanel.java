package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BackgroundPanel extends JPanel {

	private Image image;

	public BackgroundPanel(String path) {
		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.err.println("Image not found: " + path);
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
}
