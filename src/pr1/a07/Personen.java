package pr1.a07;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2019ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2019ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2019ws.objectPlay.Factory;

public class Personen {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);

		aufgabeC(out);
	}

	private static void printPerson(schimkat.berlin.lernhilfe2019ws.objectPlay.Person person, PrintWriter out) {
		String vorname = person.getVorname();
		String nachname = person.getNachname();
		int geburtsJahr = person.getGeburtsjahr();
		out.printf("%s %s %d\n", vorname, nachname, geburtsJahr);
	}

	public static ArrayList<Person> createPersonList() {
		ArrayList<Person> result = new ArrayList<Person>();
		ArrayList<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> persons = Factory.createTestPersonliste();
		for (schimkat.berlin.lernhilfe2019ws.objectPlay.Person p : persons) {
			result.add(new Person(p));
		}
		return result;
	}

	public static void printPersons(Collection<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> persons, PrintWriter out) {
		for (schimkat.berlin.lernhilfe2019ws.objectPlay.Person p : persons) {
			printPerson(p, out);
		}
	}

	public static void printPersons(Collection<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> persons, String fileName) {
		DirtyFileWriter fileWriter = new DirtyFileWriter(fileName);
		PrintWriter out = new PrintWriter(fileWriter);

		printPersons(persons, out);

		out.close();
		fileWriter.close();
	}

	public static void aufgabeC(PrintWriter out) {
		Collection<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> persons = getPersonsFrom("data/persons/schimkat.berlin.lernhilfe2019ws.objectPlay.Person.txt");
		// printPersons(persons, out);

		Collection<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> sportfreunde = getPersonsFrom("data/persons/sportfreunde.txt");
		Collection<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> kommilitonen = getPersonsFrom("data/persons/kommilitonen.txt");

		HashSet<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> sandk = new HashSet<schimkat.berlin.lernhilfe2019ws.objectPlay.Person>(sportfreunde);
		sandk.retainAll(kommilitonen);

		HashSet<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> kbutnots = new HashSet<schimkat.berlin.lernhilfe2019ws.objectPlay.Person>(kommilitonen);
		kbutnots.removeAll(sportfreunde);

		HashSet<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> tandk = new HashSet<schimkat.berlin.lernhilfe2019ws.objectPlay.Person>(persons);
		tandk.addAll(kommilitonen);

		printPersons(sandk, "data/persons/SundK.txt");
		out.println();
		printPersons(kbutnots, "data/persons/KaberNichtS.txt");
		out.println();
		printPersons(tandk, "data/persons/TvereinigtK.txt");
	}

	public static schimkat.berlin.lernhilfe2019ws.objectPlay.Person createPerson(Scanner dataSource) {
		String firstName = "";
		String lastName = "";
		int yearOfBirth = 0;

		if (dataSource.hasNext())
			firstName = dataSource.next();
		if (dataSource.hasNext())
			lastName = dataSource.next();
		if (dataSource.hasNextInt())
			yearOfBirth = dataSource.nextInt();

		return new schimkat.berlin.lernhilfe2019ws.objectPlay.Person(firstName, lastName, yearOfBirth);
	}

	public static Collection<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> getPeronsFrom(Scanner dataSource) {
		HashSet<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> result = new HashSet<schimkat.berlin.lernhilfe2019ws.objectPlay.Person>();
		while (dataSource.hasNext()) {
			result.add(createPerson(dataSource));
		}
		return result;
	}

	public static Collection<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> getPersonsFrom(String fileName) {
		DirtyFileReader reader = new DirtyFileReader(fileName);
		Scanner scanner = new Scanner(reader);
		Collection<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> result = getPeronsFrom(scanner);
		scanner.close();
		reader.close();
		return result;
	}

}
