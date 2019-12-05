package pr1.a07;

import schimkat.berlin.lernhilfe2019ws.objectPlay.Factory;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person("Jeff", "Michal", 1974);
		Person p2 = new Person(Factory.createTestPersons()[0]);
		
		System.out.println(p1);
		System.out.println(p2);
	}
	
}
