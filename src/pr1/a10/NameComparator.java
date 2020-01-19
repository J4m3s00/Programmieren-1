package pr1.a10;

import java.util.Comparator;

public class NameComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getLastname().compareTo(o2.getLastname());
	}

}
