package de.bitaix.knowhowtransfer.predicate;

import java.util.Optional;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import de.bitaix.knowhowtransfer.streams.TestData;
import de.bitaix.knowhowtransfer.streams.TestData.Person;

public class PredicateExample {
	
	
	@Test
	public String example() {
		
		
		Person person = TestData.getPersonOptional(1).get();
		
		if(person == null) {
			throw new IllegalArgumentException();
		}
		
		if(person.getFirstName().equals("Luke")) {
			return "This is Luke Skywalker"; 
		}

		if(person.getFirstName().equals("Hein")) {
			return "This is Hein Blöd"; 
		}
		
		return null;
		
	}
	
	
	@Test
	public void exampleWithPredicate2() {
		
		Optional<Person> personOptional = TestData.getPersonOptional(1);
		
		Optional<String> luke = personOptional.filter(p -> p.getFirstName().equals("Luke"))
			.map(p -> "This is Luke");

		Optional<String> hein = personOptional.filter(p -> p.getFirstName().equals("Hein"))
				.map(p -> "This is Luke");
		
		System.out.println(luke.or(() -> hein).orElse(""));
	}
	
	
	
	
	@Test
	public void exampleWithPredicate() {
		
		
		Person person = TestData.getPersonOptional(1).get();
		
		
		Optional<String> check1 = check( firstName -> firstName.equals("Luke"), person.getFirstName(), "This is Luke");
		Optional<String> check2 = check( firstName -> firstName.equals("Hein"), person.getFirstName(), "This is Hein");
		
		System.out.println(check1.or(() -> check2).orElseThrow(IllegalArgumentException::new));
	}
	

	
	
	
	

	private Optional<String> check(Predicate<String> predicate, String firstName, String result){
		
		if(predicate.test(firstName)) {
			return Optional.ofNullable(result);
		}
		
		return Optional.empty();
			
	}
	
	

}
