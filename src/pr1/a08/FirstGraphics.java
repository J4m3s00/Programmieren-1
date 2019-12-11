package pr1.a08;

import schimkat.myway.DirtyPainter2;

public class FirstGraphics {

	public static void main(String[] args) {
		/*DirtyPainter dp = new DirtyPainter("Hello World");
		dp.add(new Lines());
		
		dp.showDrawing();*/
		DirtyPainter2 dp2 = new DirtyPainter2();
		dp2.add(new Snake(dp2));
	}
	
}
