package pr1.a09;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Stern extends Himmelskörper{
	
	public Stern() {
		super();
	}
	
	public Stern(Point p, int radius) {
		super(p, radius);
	}
	
	public Stern(Stern copy) {
		super(copy);
	}

	@Override
	public void draw(Graphics2D g, double delta) {
		g.setColor(Color.YELLOW);
		g.fillOval(position.x -(radius / 2), position.y - (radius / 2), radius, radius);
	}
	
}
