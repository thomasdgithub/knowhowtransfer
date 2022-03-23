package de.bitaix.knowhowtransfer;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.bitaix.knowhowtransfer.TestData.Person;

public class ParallelStreamExamples {
	
	
	public void printLastNamesDelayedOldSchool() {

		List<Person> allPersons = TestData.getAllPersons();
		
		for (Person person : allPersons) {
			reallySlowOperation(person);
		}
	}
	
	
	private void reallySlowOperation(Person person) {
		System.out.println("waiting... " + person.getFirstName() + "-" +person.getLastName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		
	}
	
	
	
	public void printLastNamesParallelStream() {
		
		List<Person> allPersons = TestData.getAllPersons();
		
		allPersons.parallelStream().forEach(this::reallySlowOperation);
	}
	

}
