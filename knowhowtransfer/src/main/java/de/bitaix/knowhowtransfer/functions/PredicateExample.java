package de.bitaix.knowhowtransfer.functions;

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
	public void exampleWithPredicateUsingAHelperMethod() {
		Person person = TestData.getPersonOptional(1).get();
		
		Optional<String> luke = check( firstName -> firstName.equals("Luke"), person.getFirstName(), "This is Luke Skywalker");
		Optional<String> hein = check( firstName -> firstName.equals("Hein"), person.getFirstName(), "This is Hein Blöd");
		
		System.out.println(
				luke.or(() -> hein)
				.orElseThrow(IllegalArgumentException::new));
	}
	
	private Optional<String> check(Predicate<String> predicate, String firstName, String result){
		if(predicate.test(firstName)) {
			return Optional.ofNullable(result);
		}
		return Optional.empty();
	}

	@Test
	public void exampleWithPredicateUsingFilter() {
		
		Optional<Person> personOptional = TestData.getPersonOptional(2);
		
		Optional<String> luke = personOptional
				.filter(p -> p.getFirstName().equals("Luke"))
			.map(p -> "This is Luke Skywalker");

		Optional<String> hein = personOptional
				.filter(p -> p.getFirstName().equals("Hein"))
			.map(p -> "This is Hein Blöd");
		
		System.out.println(
				luke.or(() -> hein)
				.orElse(""));
	}
}
