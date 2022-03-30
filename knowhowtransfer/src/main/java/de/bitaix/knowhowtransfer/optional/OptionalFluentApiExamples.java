package de.bitaix.knowhowtransfer.optional;

import java.time.LocalDate;

import de.bitaix.knowhowtransfer.streams.TestData;
import de.bitaix.knowhowtransfer.streams.TestData.Person;

public class OptionalFluentApiExamples {
	
	
	private LocalDate getDateOfBirth() {
		
		LocalDate dateOfBirth = null;
		
		Person person = TestData.getPerson(1);
		
		if(person != null && person.getDateOfBirth() != null) {
			dateOfBirth = LocalDate.parse(person.getDateOfBirth());
		} else {
			dateOfBirth = getDefaultDate();		
		}
		return dateOfBirth;
		
	}

	private LocalDate getDefaultDate() {
		return LocalDate.of(2000, 1, 1);
	}
	
	
	//----------------------- how to do with optional---------------------------
	
	private LocalDate getDateOfBirthOptional() {
		return TestData.getPersonOptional(5)
			.map(Person::getDateOfBirth)
			.map(LocalDate::parse)			
			.orElse(getDefaultDate());
	}

}
