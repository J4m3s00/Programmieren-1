package pr1.a09f;

import java.awt.Graphics2D;
import java.awt.Point;

import pr1.a09.Himmelskörper;

public abstract class BewegterHimmelskörper extends Himmelskörper{

	private double time;
	
	public BewegterHimmelskörper() {
		super();
		time = 0;
	}
	
	public BewegterHimmelskörper(Point position, int radius) {
		super(position, radius);
		time = 0;
	}
	
	public BewegterHimmelskörper(BewegterHimmelskörper copy) {
		this(copy.position, copy.radius);
		time = 0;
	}
	
	@Override
	public void draw(Graphics2D g, double delta) {
		super.draw(g, delta);
		moveToPositionAtTime(time += delta);
	}
	
	
	public abstract void moveToPositionAtTime(double timeInDays);

}
