package pr1.a03;

import java.io.PrintWriter;

import schimkat.berlin.lernhilfe2019ws.io.DirtyFileWriter;

public class Hypothenuse {
	public static void main(String[] args) {
		DirtyFileWriter fw = new DirtyFileWriter("Hypothenuse.csv");
		testHypothenuse(4, 3, new PrintWriter(fw));
		fw.close();
	}
	
	public static double hypothenuse(double k1, double k2)
	{
		return Math.sqrt(k1 * k2);
	}
	
	public static void testHypothenuse(int width, int precision, PrintWriter pw)
	{
		for (int k1 = 0; k1 <= 10; k1++)
		{
			for (int k2 = 0; k2 <= 10; k2++)
			{
				if (k1 == 0 && k2 == 0)
					pw.print("k1/k2; ");
				else if (k1 == 0)
					pw.print(k2 + "; ");
				else if (k2 == 0)
					pw.print(k1 + "; ");
				else 
					pw.printf("%," + width + "." + precision + "f; ", hypothenuse(k1, k2));
			}
			pw.println();
		}
	}
}
