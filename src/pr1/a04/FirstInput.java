package pr1.a04;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2019ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2019ws.io.DirtyFileWriter;

public class FirstInput {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		String numberFile = "data/testfiles/zahlen01.txt";
		String numberFileCopy = "data/testfiles/zahlen01_copy.txt";

		scannerAusprobieren();

		
		//4. a)
		double sum = countSumOf(numberFile);
		System.out.println("Sum of numbers in file zahlen01.txt: " + sum);
		
		DirtyFileReader reader = new DirtyFileReader(numberFile);
		Scanner scanner = new Scanner(reader);
		printNumbersFrom(scanner, 4, 3, new PrintWriter(System.out, true));
		scanner.close();
		reader.close();
		
		//4. b)
		
		DirtyFileReader reader4b = new DirtyFileReader(numberFile);
		Scanner scanner4b = new Scanner(reader4b);
		
		printNumbersFrom(scanner4b, 4, 3, new PrintWriter(System.out, true));
		
		scanner4b.close();
		reader4b.close();
		
		copyNumberFile(numberFile, numberFileCopy, 4, 3);
	}

	public static void scannerAusprobieren() {
		String intNumbers = "9 8 7 6 5 4 3 2 1";
		String doubleNumbers = "1.1 2.2 3.3 4.4 5.5 6.6 7.7 8.8 9.9";
		String mixedNumbers = "1 2.2 3 4.4 5 6.6";

		//a)
		Scanner intScanner = new Scanner(intNumbers);
		while (intScanner.hasNext()) {
			if (intScanner.hasNextInt()) {
				System.out.println("IntScanner: " + intScanner.nextInt());
			} else {
				intScanner.next();
			}
		}
		intScanner.close();

		Scanner doubleScanner = new Scanner(doubleNumbers);
		while (doubleScanner.hasNext()) {
			if (doubleScanner.hasNextDouble()) {
				System.out.println("DoubleScanner: " + doubleScanner.nextDouble());
			} else {
				doubleScanner.next();
			}
		}
		doubleScanner.close();

		Scanner mixedScanner = new Scanner(mixedNumbers);
		while (mixedScanner.hasNext()) {
			if (mixedScanner.hasNextInt()) {
				System.out.println("MixedScanner int: " + mixedScanner.nextInt());
			} else if (mixedScanner.hasNextDouble()) {
				System.out.println("MixedScanner double: " + mixedScanner.nextDouble());
			} else {
				mixedScanner.next();
			}
		}
		mixedScanner.close();
		
		//b)
		DirtyFileReader reader = new DirtyFileReader("data/testfiles/zahlen01.txt");
		Scanner fileScanner = new Scanner(reader);
		while (fileScanner.hasNext())
		{
			if (fileScanner.hasNextInt()) {
				System.out.println("FileScanner int: " + fileScanner.nextInt());
			} else if (fileScanner.hasNextDouble()) {
				System.out.println("FileScanner double: " + fileScanner.nextDouble());
			} else {
				fileScanner.next();
			}
		}
		fileScanner.close();
		reader.close();
	}

	
	//AUFGABE 4 a)
	public static double countSumOf(Scanner in) {
		double result = 0;
		while (in.hasNext()) {
			if (in.hasNextDouble()) {
				result += in.nextDouble();
			} else {
				in.next();
			}
		}
		return result;
	}

	public static double countSumOf(String fileName) {
		DirtyFileReader reader = new DirtyFileReader(fileName);
		Scanner scanner = new Scanner(reader);
		double result = countSumOf(scanner);
		scanner.close();
		reader.close();
		return result;
	}
	
	public static void printNumbersFrom(Scanner in, int width, int precision, PrintWriter out) {
		while (in.hasNext()) {
			if (in.hasNextInt()) {
				out.printf("%," + width + "d\n", in.nextInt());
			} else if (in.hasNextDouble()) {
				out.printf("%," + width + "." + precision + "f\n", in.nextDouble());
			} else {
				in.next();
			}
		}
	}
	//Aufgabe 4 b)
	public static void copyNumberFile(String inFile, String outFile, int width, int precision) {
		DirtyFileReader reader = new DirtyFileReader(inFile);
		Scanner scanner = new Scanner(reader);
		DirtyFileWriter writer = new DirtyFileWriter(outFile);
		PrintWriter out = new PrintWriter(writer);
		
		printNumbersFrom(scanner, width, precision, out);
		
		out.close();
		writer.close();
		scanner.close();
		reader.close();
	}
}
