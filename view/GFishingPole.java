package view;

import java.awt.Color;

import acm.graphics.GCompound;
import acm.graphics.GImage;
import acm.graphics.GLine;

/**
 * A graphical fishing pole that reels in a fish
 * @author Thomas Barrett and Serena Riback
 * @since 17 February 201
 */
@SuppressWarnings("serial")
public class GFishingPole extends GCompound implements ProgressivelyDrawable {

	private GImage pole;
	private GImage fish;
	private GLine line;
	
	private final double FISH_WIDTH = 0.3;
	private final double FISH_HEIGHT = 0.3;
	private final double POLE_TIP = 0.15;
	private final double FISH_MIN_Y;
	private final double POLE_TIP_X;
	private final double POLE_TIP_Y;
	private int partNum = 0;

	public GFishingPole(int width, int height) {
		FISH_MIN_Y = height * POLE_TIP + 0.6 * height;

		pole = new GImage("pole.png");
		pole.setSize(width, height);
		pole.setLocation(0, 0);
		add(pole);

		POLE_TIP_X = pole.getWidth()-2;
		POLE_TIP_Y = height * POLE_TIP;

		fish = new GImage("fish.png");
		fish.setSize(width * FISH_WIDTH, height * FISH_HEIGHT);
		fish.setLocation(POLE_TIP_X  - fish.getWidth() / 2, POLE_TIP_Y + getMaxParts() * 0.1 * height);
		add(fish);
		
		line = new GLine(POLE_TIP_X, POLE_TIP_Y, POLE_TIP_X, fish.getY());
		line.setColor(Color.WHITE);
		add(line);
	}

	@Override
	public void drawNextPart() {
		if (partNum < getMaxParts()) {
			partNum++;
			double x = fish.getX();
			double y = FISH_MIN_Y - partNum * 0.1 * pole.getHeight();
			fish.setLocation(x, y);
			line.setEndPoint(POLE_TIP_X, fish.getY());
		}
	}

	@Override
	public void reset() {
		fish.setLocation(pole.getWidth() - fish.getWidth() / 2, pole.getHeight() * POLE_TIP + 0.6 * pole.getHeight());
		line.setEndPoint(POLE_TIP_X, fish.getY());
		partNum = 0;
	}

	@Override
	public int getMaxParts() {
		return 6;
	}

}
