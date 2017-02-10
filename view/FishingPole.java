package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import acm.graphics.GCompound;

/** 
 * A Graphical representation that 
 * @author Thomas Barrett
 */
@SuppressWarnings("serial")
public class FishingPole extends GCompound implements ProgressivelyDrawable {

    private Image pole;
    
    public FishingPole(int width, int height) {
	try {
	    pole = ImageIO.read(new File("pole.png"));
	} catch (IOException e) {
	    
	}
    }
    
    @Override
    public void drawNextPart() {
	
	
    }

    @Override
    public void reset() {
	// TODO Auto-generated method stub
	
    }

    @Override
    public int getMaxParts() {
	// TODO Auto-generated method stub
	return 0;
    }

	
}
