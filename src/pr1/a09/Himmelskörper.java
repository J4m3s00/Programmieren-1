package pr1.a09;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import schimkat.myway.Drawable2;

public class Himmelskörper implements Drawable2 {

	protected Point position;
	protected int radius;
	
	public Himmelskörper() {
		this(new Point(100, 100), 24);
	}
	
	public Himmelskörper(Point position, int radius) {
		this.position = position;
		this.radius = radius;	
	}
	
	public Himmelskörper(Himmelskörper copy) {
		this(copy.position, copy.radius);
	}

	@Override
	public void draw(Graphics2D g, double delta) {
		g.setColor(Color.GRAY);
		g.fillOval(position.x -(radius / 2), position.y - (radius / 2), radius, radius);
	}
	
	public Point getPosition() {
		return position;
	}
	
	public int getRadius() {
		return radius;
	}
	
}
