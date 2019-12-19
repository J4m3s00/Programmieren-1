package pr1.a09f;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import pr1.a09.Planet;

public class Mond extends RotierenderHimmelskörper {

	public Mond(Planet stern, double bahnRadius) {
		this(25, stern, bahnRadius);
	}
	
	public Mond(int radius, Planet planet, double bahnRadius) {
		super(new Point(0, 0), radius, planet, bahnRadius);
	}
	
	public Mond(Mond copy) {
		super(copy.position, copy.radius, copy.parent, copy.bahnRadius);
	}
	
	@Override
	public void draw(Graphics2D g, double delta) {
		super.draw(g, delta);
		g.setColor(Color.gray);
		g.fillOval(position.x -(radius / 2), position.y - (radius / 2), radius, radius);
	}
}
