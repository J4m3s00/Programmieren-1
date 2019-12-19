package pr1.a09;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import pr1.a08.Gitter;
import pr1.a09f.Mond;
import pr1.a09f.Raumsonde;
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
		Planet planet1 = new Planet(50, sonne, 250);
		Mond mond1 = new Mond(6, planet1, 30);
		Mond mond2 = new Mond(12, planet1, 44);
		Planet planet2 = new Planet(30, sonne, 100);
		
		dp2.add(sonne);
		dp2.add(planet1);
		dp2.add(mond1);
		dp2.add(mond2);
		dp2.add(planet2);
		
		Raumsonde sonde = new Raumsonde(new Point(100, 50));
		dp2.add(sonde);
		
		dp2.show();
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
