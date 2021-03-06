package pr1.a09;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import pr1.a09f.RotierenderHimmelskörper;

public class Planet extends RotierenderHimmelskörper {
	
	public Planet(Stern stern, double bahnRadius) {
		this(25, stern, bahnRadius);
	}
	
	public Planet(int radius, Stern stern, double bahnRadius) {
		super(new Point(0, 0), radius, stern, bahnRadius);
	}
	
	public Planet(Planet copy) {
		super(copy.position, copy.radius, copy.parent, copy.bahnRadius);
	}
	
	@Override
	public void draw(Graphics2D g, double delta) {
		super.draw(g, delta);
		g.setColor(Color.BLUE);
		g.fillOval(position.x -(radius / 2), position.y - (radius / 2), radius, radius);
	}

}
