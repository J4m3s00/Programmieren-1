package pr1.a09;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Planet extends Himmelskörper {

	protected Stern stern;
	protected double bahnRadius;
	protected double yearInDays;
	
	private double currentTime;
	
	public Planet(Stern stern, double bahnRadius) {
		this(25, stern, bahnRadius);
	}
	
	public Planet(int radius, Stern stern, double bahnRadius) {
		super(new Point(0, 0), radius);
		this.stern = stern;
		this.bahnRadius = bahnRadius;
		this.yearInDays = 365;
		this.position = moveToPositionAtTime(0);
		currentTime = 0;
	}
	
	public Planet(Planet copy) {
		this(copy.radius, copy.stern, copy.bahnRadius);
	}
	
	@Override
	public void draw(Graphics2D g, double delta) {
		this.position = moveToPositionAtTime((currentTime += (delta * 10)));
		g.setColor(Color.BLUE);
		g.fillOval(position.x -(radius / 2), position.y - (radius / 2), radius, radius);
	}
	
	private Point moveToPositionAtTime(double timeInDays) {
		double bogenmass = 2.0 * Math.PI * (timeInDays / yearInDays);
		int x = (int) (stern.position.x + (this.bahnRadius * Math.cos(bogenmass)));
		int y = (int) (stern.position.y + (this.bahnRadius * Math.sin(bogenmass)));
		return new Point(x, y);
	}
}
