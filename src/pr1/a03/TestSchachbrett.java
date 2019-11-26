package pr1.a03;

import java.io.PrintWriter;

import pr1.a02.Schachbrett;
import schimkat.berlin.lernhilfe2019ws.io.DirtyFileWriter;

public class TestSchachbrett {

	public static void main(String[] args) {
		printSchachbrett("data/schachbrett/schachbrett.txt", false);
	}

	public static void printSchachbrett(String fileName, boolean isReversed) {
		DirtyFileWriter writer = new DirtyFileWriter(fileName);
		PrintWriter out = new PrintWriter(writer);
		
		if (isReversed)
			Schachbrett.printSchachbrett(out);
		else
			Schachbrett.printSchachbrettReverse(out);
		
		out.flush();
		out.close();
		writer.close();
	}

}
