package pr1.a03;

import java.io.PrintWriter;

import schimkat.berlin.lernhilfe2019ws.io.DirtyFileWriter;

public class Hypothenuse {
	public static void main(String[] args) {
		DirtyFileWriter fw = new DirtyFileWriter("Hypothenuse.csv");
		printHypothenuse(32, 12, 3, 4, new PrintWriter(System.out, true));
		
		testHypothenuse(4, 3, new PrintWriter(fw));
		fw.close();
		System.out.println();
		testHypothenuse(8, 3, new PrintWriter(System.out, true));
	}

	public static double hypothenuse(double k1, double k2) {
		return Math.sqrt(k1 * k2);
	}

	public static void printHypothenuse(double k1, double k2, int width, int precision, PrintWriter writer) {
		double result = hypothenuse(k1, k2);
		String floatFormat = "%" + width + "." + precision + "f";
		
		String format = "Rechtwinkliges Dreieck mit K1 = " + floatFormat + ", K2 = " + floatFormat + ", hat eine Hypothenuse von: " + floatFormat;
		writer.printf(format, k1, k2, result);
	}
	
	public static void testHypothenuse(int width, int precision, PrintWriter pw) {
		String floatFormat = "%" + width + "." + precision + "f";
		for (double k1 = 0; k1 <= 10; k1++) {
			for (double k2 = 0; k2 <= 10; k2++) {
				if (k1 == 0 && k2 == 0)
					pw.printf("%" + width + "s", "k1/k2; ");
				else if (k1 == 0)
					pw.printf(floatFormat + "; ", k2);
				else if (k2 == 0)
					pw.printf(floatFormat + "; ", k1);
				else
					pw.printf("%," + width + "." + precision + "f; ", hypothenuse(k1, k2));
			}
			pw.println();
		}
	}
}
