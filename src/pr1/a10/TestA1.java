package pr1.a10;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import schimkat.berlin.lernhilfe2019ws.objectPlay.Factory;

public class TestA1 {

	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out, true);
		
		ArrayList<Person> persons = createPersonList();
		printPersonList(persons, out);
		
		out.println();
		
		persons.sort(PersonCompare::byYear);
		//Collections.sort(persons);
		printPersonList(persons, out);
		
	}
	
	public static ArrayList<Person> createPersonList() {
		ArrayList<Person> result = new ArrayList<Person>();
		ArrayList<schimkat.berlin.lernhilfe2019ws.objectPlay.Person> persons = Factory.createTestPersonliste();
		for (schimkat.berlin.lernhilfe2019ws.objectPlay.Person p : persons) {
			result.add(new Person(p));
		}
		return result;
	}
	
	private static void printPerson(Person person, PrintWriter out) {
		String vorname = person.getFirstname();
		String nachname = person.getLastname();
		int geburtsJahr = person.getYearOfBirth();
		out.printf("%s %s %d\n", vorname, nachname, geburtsJahr);
	}
	
	private static void printPersonList(List<Person> persons, PrintWriter out) {
		for (Person p : persons) {
			printPerson(p, out);
		}
	}
}
