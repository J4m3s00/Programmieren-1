package pr1.a08;

import java.awt.Color;

import schimkat.myway.DirtyPainter2;

public class FirstGraphics {

	public static void main(String[] args) {
		Gitter gitter = new Gitter(50, 50);
		Gitter gitter2 = new Gitter(10, 10);
		
		/*DirtyPainter dp = new DirtyPainter("Hello World");
		dp.add(gitter2);
		dp.add(gitter);
		dp.showDrawing();*/
		
		DirtyPainter2 dp2 = new DirtyPainter2();
		//dp2.add(new Snake(dp2));
		gitter.setColor(Color.red);
		dp2.add(gitter2);
		dp2.add(gitter);
		
	}
	
}
