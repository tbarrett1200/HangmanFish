/*
 * File: BackgroundPanel.java
 * Author: Thomas Barrett
 * Created: Feb 16, 2017
 */
package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {

    Image background;
    
    public BackgroundPanel(String img) {
	try {
	    background = ImageIO.read(new File(img));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    @Override
    public void paintComponent(Graphics g) {
	g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
    }
}
