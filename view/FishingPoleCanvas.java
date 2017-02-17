package view;

import acm.graphics.GCanvas;

/**
 * A GCanvas that displays a centered fishing pole
 * @author Thomas Barrett and Serena Riback
 * @since 17 February 2017
 */
@SuppressWarnings("serial")
public class FishingPoleCanvas extends GCanvas {

	private GFishingPole fishingPole;

	/**
	 * 
	 * @param width
	 * @param height
	 */
	public FishingPoleCanvas(int width, int height) {	
		fishingPole = new GFishingPole(width, height);
		add(fishingPole);
	}

	/**
	 * Resets
	 */
	public void reset() {
		fishingPole.reset();
	}
	
	/**
	 * @return the fishing pole graphical object
	 */
	public ProgressivelyDrawable getProgressivelyDrawable() {
		return fishingPole;
	}
	
	@Override
	public void doLayout() {
		double x = getWidth() / 2 - fishingPole.getWidth() / 2;
		double y = getHeight() / 2 - fishingPole.getHeight() / 2;
		fishingPole.setLocation(x, y);
	}
	
}
