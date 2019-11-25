package pr1.a03;

import schimkat.berlin.lernhilfe2019ws.io.DirtyFileWriter;

public class Aufgabe03IO {

	public static void main(String[] args) {
		System.out.println("Max int: " + Integer.MAX_VALUE);
		System.out.println("Min int: " + Integer.MIN_VALUE);
		System.out.println((int)Math.pow(2, 31));
		System.out.println((int)-Math.pow(2, 32));
	}

	public static void writeIntNumberFile(String filename, int numberCount) {
		DirtyFileWriter fileWriter = new DirtyFileWriter(filename);
		if (numberCount % 2 != 0) numberCount++;
		
		
		fileWriter.close();
	}

}
