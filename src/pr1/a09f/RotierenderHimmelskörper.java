package pr1.a09f;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import pr1.a09.Himmelskörper;

public class RotierenderHimmelskörper extends BewegterHimmelskörper{
	private final double YEAR_IN_DAYS = 365;
	
	protected Himmelskörper parent;
	protected double bahnRadius;
	
	public RotierenderHimmelskörper() {
		super();
		this.parent = null;
		this.bahnRadius = 0;
	}
	
	public RotierenderHimmelskörper(Point position, int radius, Himmelskörper parent, double bahnRadius) {
		super(position, radius);
		this.parent = parent;
		this.bahnRadius = bahnRadius;
	}
	
	@Override
	public void draw(Graphics2D g, double delta) {
		if (parent == null) return;
		super.draw(g, delta);
		g.setColor(Color.GREEN);
	}
	
	@Override
	public void moveToPositionAtTime(double timeInDays) {
		double bogenmass = 2.0 * Math.PI * (timeInDays / YEAR_IN_DAYS) * (bahnRadius / 10);
		this.position.x = (int) (parent.getPosition().x + this.bahnRadius * Math.cos(bogenmass));
		this.position.y = (int) (parent.getPosition().y + this.bahnRadius * Math.sin(bogenmass));
	}

}
