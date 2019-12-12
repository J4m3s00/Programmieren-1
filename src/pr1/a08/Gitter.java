package pr1.a08;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import schimkat.berlin.lernhilfe2019ws.graphics.Drawable;
import schimkat.myway.Drawable2;

public class Gitter implements Drawable2, Drawable {
	public static final int PIXEL_WIDTH = 1000;
	public static final int PIXEL_HEIGHT = 1000;
	private final int AXIS_OFFSET_X = 0;
	private final int AXIS_OFFSET_Y = 0;

	private int dx;
	private int dy;
	private Color color;
	
	public Gitter() {
		this(100, 100);
	}
	
	public Gitter(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
		this.color = Color.yellow;
	}
	
	public Gitter(Gitter copy) {
		this(copy.dx, copy.dy);
	}
	
	@Override
	public void draw(Graphics2D g, double delta) {
		g.setColor(color);
		g.setStroke(new BasicStroke(1));
		for (int y = 0; y < PIXEL_HEIGHT / this.dy; y++) {
			g.drawLine(0, y * this.dy, PIXEL_WIDTH, y * this.dy);
		}
		for (int x = 0; x < PIXEL_WIDTH / this.dx; x++) {
			g.drawLine(x * this.dx, 0, x * this.dx, PIXEL_WIDTH);
		}
		g.setColor(Color.blue);
		g.setStroke(new BasicStroke(4));
		g.drawLine(0, AXIS_OFFSET_Y, PIXEL_WIDTH, AXIS_OFFSET_Y);
		g.drawLine(AXIS_OFFSET_X, 0, AXIS_OFFSET_X, PIXEL_HEIGHT);
	}

	public int getDx() {
		return dx;
	}
	
	public int getDy() {
		return dy;
	}

	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void draw(Graphics g) {
		this.draw((Graphics2D) g, 0.0);
	}
}
