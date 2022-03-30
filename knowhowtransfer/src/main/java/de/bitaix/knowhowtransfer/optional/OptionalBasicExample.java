package de.bitaix.knowhowtransfer.optional;

import java.util.Optional;

import de.bitaix.knowhowtransfer.streams.TestData;
import de.bitaix.knowhowtransfer.streams.TestData.Person;

public class OptionalBasicExample {
	
	
	public void getPersonsFirstName() {
		String firstName = null;
		Person person = TestData.getPerson(5);
		if(person != null ) {
			firstName = person.getFirstName();
		}
		if(firstName == null) {
			throw new IllegalArgumentException("firstname is still empty");
		}
		System.out.println(firstName);
	}
	
	
	
	public Optional<Person> getPerson(int id){
		Person person = TestData.getPerson(5);
		if(person.getFirstName().equals("Luke")) {
			return Optional.ofNullable(person);
		}
		return Optional.empty();
	}
	
	
	
	//----------------------- how to do with optional---------------------------
	
	
	public void getPersonsFirstNameOptional() {
		Optional<Person> person = getPerson(5);
		
		if(person.isPresent()) {
			System.out.println(person.get().getFirstName());
		} 
	}
	

}
