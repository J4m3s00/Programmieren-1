package pr1.a10;

public class PersonCompare {

	public static int byName(Person p1, Person p2) {
		return p1.getFirstname().compareTo(p2.getFirstname());
	}
	
	public static int byLastName(Person p1, Person p2) {
		return p1.getLastname().compareTo(p2.getLastname());
	}
	
	public static int byYear(Person p1, Person p2) {
		return p1.getYearOfBirth() - p2.getYearOfBirth();
	}
	
}
