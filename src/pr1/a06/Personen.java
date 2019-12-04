package pr1.a06;

import java.io.PrintWriter;
import java.util.Scanner;

import schimkat.berlin.lernhilfe2019ws.io.DirtyFileReader;
import schimkat.berlin.lernhilfe2019ws.io.DirtyFileWriter;
import schimkat.berlin.lernhilfe2019ws.objectPlay.Person;
import schimkat.berlin.lernhilfe2019ws.objectPlay.PersonList;
import schimkat.berlin.lernhilfe2019ws.objectPlay.PersonSet;

public class Personen {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);

		aufgabeC(out);
		
	}

	private static void printPerson(Person person, PrintWriter out) {
		String vorname = person.getVorname();
		String nachname = person.getNachname();
		int geburtsJahr = person.getGeburtsjahr();
		out.printf("%s %s %d\n", vorname, nachname, geburtsJahr);
	}

	public static void printPersons(PersonList persons, PrintWriter out) {
		for (Person p : persons) {
			printPerson(p, out);
		}
	}

	public static void printPersons(PersonSet persons, PrintWriter out) {
		for (Person p : persons) {
			printPerson(p, out);
		}
	}


	public static void printPersons(PersonSet persons, String fileName) {
		DirtyFileWriter fileWriter = new DirtyFileWriter(fileName);
		PrintWriter out = new PrintWriter(fileWriter);

		printPersons(persons, out);

		out.close();
		fileWriter.close();
	}
	
	public static void aufgabeC(PrintWriter out) {
		PersonSet persons = getPersonsFrom("data/persons/Person.txt");
		//printPersons(persons, out);
		
		PersonSet sportfreunde = getPersonsFrom("data/persons/sportfreunde.txt");
		PersonSet kommilitonen = getPersonsFrom("data/persons/kommilitonen.txt");
		
		PersonSet sandk = new PersonSet(sportfreunde);
		sandk.retainAll(kommilitonen);
		
		PersonSet kbutnots = new PersonSet(kommilitonen);
		kbutnots.removeAll(sportfreunde);
		
		PersonSet tandk = new PersonSet(persons);
		tandk.addAll(kommilitonen);
		
		printPersons(sandk, "data/persons/SundK.txt");
		out.println();
		printPersons(kbutnots, "data/persons/KaberNichtS.txt");
		out.println();
		printPersons(tandk, "data/persons/TvereinigtK.txt");
	}

	public static Person createPerson(Scanner dataSource) {
		String firstName = "";
		String lastName = "";
		int yearOfBirth = 0;

		if (dataSource.hasNext())
			firstName = dataSource.next();
		if (dataSource.hasNext())
			lastName = dataSource.next();
		if (dataSource.hasNextInt())
			yearOfBirth = dataSource.nextInt();

		return new Person(firstName, lastName, yearOfBirth);
	}

	public static PersonSet getPeronsFrom(Scanner dataSource) {
		PersonSet result = new PersonSet();
		while (dataSource.hasNext()) {
			result.add(createPerson(dataSource));
		}
		return result;
	}

	public static PersonSet getPersonsFrom(String fileName) {
		DirtyFileReader reader = new DirtyFileReader(fileName);
		Scanner scanner = new Scanner(reader);
		PersonSet result = getPeronsFrom(scanner);
		scanner.close();
		reader.close();
		return result;
	}
	
}

