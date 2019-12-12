package pr1.a09;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import pr1.a08.Gitter;
import schimkat.myway.DirtyPainter2;

public class Planetarium {

	public static void main(String[] args) {
		Gitter gitter = new Gitter(50, 50);
		Gitter gitter2 = new Gitter(10, 10);

		DirtyPainter2 dp2 = new DirtyPainter2();
		gitter.setColor(Color.red);
		dp2.add(gitter2);
		dp2.add(gitter);

		Stern sonne = new Stern(new Point(400, 400), 50);
		Planet planet1 = new Planet(40, sonne, 100);
		Planet planet2 = new Planet(24, sonne, 50);
		
		dp2.add(sonne);
		dp2.add(planet1);
		dp2.add(planet2);
	}

	private static void generateHimmelskörper(int count, DirtyPainter2 dp) {
		Random rand = new Random();
		for (int i = 0; i < count; i++) {
			Point newPosition = new Point(rand.nextInt(Gitter.PIXEL_WIDTH), rand.nextInt(Gitter.PIXEL_HEIGHT));
			int newRedius = rand.nextInt(100);
			if (rand.nextBoolean())
				dp.add(new Himmelskörper(newPosition, newRedius));
			else 
				dp.add(new Stern(newPosition, newRedius));
		}
	}

}
