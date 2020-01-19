package pr1.a10;

public class Person implements Comparable<Person>{

	private String firstname;
	private String lastname;
	private int yearOfBirth;
	
	public Person(String firstname, String lastname, int yearOfBirth) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.yearOfBirth = yearOfBirth;
	}
	
	public Person(Person p) {
		this(p.firstname, p.lastname, p.yearOfBirth);
	}
	
	public Person(schimkat.berlin.lernhilfe2019ws.objectPlay.Person copy) {
		this(copy.getVorname(), copy.getNachname(), copy.getGeburtsjahr());
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	
	@Override
	public String toString() {
		return firstname + ", " + lastname + ": " + yearOfBirth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + yearOfBirth;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (yearOfBirth != other.yearOfBirth)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public int compareTo(Person o) {
		
		return this.lastname.compareTo(o.getLastname());
	}

}
