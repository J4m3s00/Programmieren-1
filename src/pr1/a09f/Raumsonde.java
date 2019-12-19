package pr1.a09f;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class Raumsonde extends BewegterHimmelskörper{

	private Point direction;
	private double time;
	
	public Raumsonde(Point direction) {
		super(new Point(0, 0), 20);
		this.direction = direction;
		time = 0;
	}
	
	@Override
	public void draw(Graphics2D g, double delta) {
		moveToPositionAtTime(time += delta);
		g.setColor(Color.LIGHT_GRAY);
		g.fillOval(this.position.x - (radius / 2), this.position.y - (radius / 2), radius, radius);
	}
	
	@Override
	public void moveToPositionAtTime(double timeInDays) {
		this.position.x = (int) (direction.x * timeInDays);
		this.position.y = (int) (direction.y * timeInDays);
		
	}

}
