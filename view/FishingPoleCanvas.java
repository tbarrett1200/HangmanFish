package view;

import acm.graphics.GCanvas;

@SuppressWarnings("serial")
public class FishingPoleCanvas extends GCanvas {

	public FishingPole fishingPole;

	public FishingPoleCanvas(int width, int height) {	
		fishingPole = new FishingPole(width, height);
		add(fishingPole);
	}
	
	public void doLayout() {
		double x = getWidth() / 2 - fishingPole.getWidth() / 2;
		double y = getHeight() / 2 - fishingPole.getHeight() / 2;
		fishingPole.setLocation(x, y);
	}
}
