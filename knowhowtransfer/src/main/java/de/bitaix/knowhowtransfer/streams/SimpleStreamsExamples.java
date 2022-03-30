package de.bitaix.knowhowtransfer.streams;

import java.util.List;

import de.bitaix.knowhowtransfer.streams.TestData.Person;

public class SimpleStreamsExamples {

	public void printLastNamesOldSchool() {

		List<Person> allPersons = TestData.getAllPersons();

		for (Person person : allPersons) {
			if(person.getId() != null) {				
				System.out.println(person.getLastName());
			}
		}
	}

	
	public void printLastNamesStream(List<Person> allPersons) {
		allPersons.stream()
			.filter(p -> p.getId() != null)
			.map(p -> p.getLastName())
			.forEach(System.out::println);
	}


	
	
	public void sumIdsOldSchool() {
		int result = 0;
		
		for (Person person : TestData.getAllPersons()) {
			if(person.getId() != null) {
				result += person.getId();
			}
		}
		
		System.out.println(result);
		
	}
	
	
	
	
	public void sumIdsReduce() {
		Integer result = TestData.getAllPersons().stream()
		.filter(p -> p.getId() != null)	
		.map(Person::getId)
		.reduce(0, Integer::sum);
		
		System.out.println(result);
		
	}
	
}
