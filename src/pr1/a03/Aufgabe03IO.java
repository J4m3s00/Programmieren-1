package pr1.a03;

import java.io.PrintWriter;
import java.util.Random;

import schimkat.berlin.lernhilfe2019ws.io.DirtyFileWriter;

public class Aufgabe03IO {

	public static void main(String[] args) {
		writeIntNumberFile("data/testfiles/randomInts.txt", 1000);
		writeMixedNumberFile("data/testfiles/randomMixed.txt", 1000, 10);
	}

	public static void writeIntNumberFile(String filename, int numberCount) {
		Random rand = new Random();
		DirtyFileWriter fileWriter = new DirtyFileWriter(filename);
		if (numberCount % 2 != 0) numberCount++;
		PrintWriter writer = new PrintWriter(fileWriter);
		
		for (int i = 0; i < numberCount; i++) {
			if (i % 10 == 0 && i != 0) 
				writer.println();
			
			writer.printf("%8d", rand.nextInt(999999));
		}
		
		writer.flush();
		writer.close();
		fileWriter.close();
	}

	public static void writeMixedNumberFile(String fileName, int numberCount, int width) {
		Random rand = new Random();
		int integerIndex = rand.nextInt(10);
		
		DirtyFileWriter fileWriter = new DirtyFileWriter(fileName);
		if (numberCount % 2 != 0) numberCount++;
		PrintWriter writer = new PrintWriter(fileWriter);
		
		for (int i = 0; i < numberCount; i++) {
			if (i % 10 == 0 && i != 0)
				writer.println();
			
			//Create integer
			if (i % integerIndex == 0)
				writer.printf("%" + width + "d", rand.nextInt(999999));
			else 
				writer.printf("%" + width + "f", rand.nextDouble());
		}
		writer.flush();
		writer.close();
		fileWriter.close();
	}
	
}
