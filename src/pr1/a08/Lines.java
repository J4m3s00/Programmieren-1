package pr1.a08;

import java.awt.Color;
import java.awt.Graphics2D;

import schimkat.myway.Drawable2;

public class Lines implements Drawable2{

	@Override
	public void draw(Graphics2D g, double delta) {
		g.setColor(Color.red);
		g.fillRect(10, 10, 64, 64);
	}

}
