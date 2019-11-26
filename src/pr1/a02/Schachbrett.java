package pr1.a02;

import java.io.PrintWriter;

public class Schachbrett {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		
		printSchachbrett(out);
	}

	public static void printSchachbrett(PrintWriter out) {
		for (char c = 'A'; c <= 'H'; c++) {
			for (int i = 1; i <= 8; i++) {
				out.print(c + "" + i + " ");
			}
			out.println();
		}
	}
	

	public static void printSchachbrettReverse(PrintWriter out) {
		for (int i = 1; i <= 8; i++) {
			for (char c = 'A'; c <= 'H'; c++) {
				out.print(c + "" + i + " ");
			}
			out.println();
		}
	}
	
	//Print to console
	public static void printSchachbrett() {
		printSchachbrett(new PrintWriter(System.out, true));
	}
	
	public static void printSchachbrettReverse() {
		printSchachbrettReverse(new PrintWriter(System.out, true));
	}


}
