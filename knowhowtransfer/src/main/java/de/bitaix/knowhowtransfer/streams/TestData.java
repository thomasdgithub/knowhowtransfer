package de.bitaix.knowhowtransfer.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;

public class TestData {
	
	@Data
	@AllArgsConstructor
	public static class Person{
		private Integer id;
		private String firstName;
		private String lastName;
		private String zipCode;
		private String dateOfBirth;
	}
	
	public static List<Person> getAllPersons(){
		return Arrays.asList( 
				new Person(0, "Max", "Mustermann", "0000000", "1990-05-05"),
				new Person(4, "Harry", "Hirsch", "4444444", "1995-05-05"),
				new Person(1, "Hein", "Blöd", "555555", "2005-05-05"),
				new Person(2, "Luke", "Skywalker", "6666666", "2002-05-05"),
				new Person(3, "Forrest", "Gump", "777777", "1988-05-05"),
				new Person(null, "Lisa", "Mueller", "8888888", null));
	}

	public static Optional<Person> getPersonOptional(int id) {
		return getAllPersons().stream()
				.filter(p -> p.getId().equals(id))
				.findFirst();
	}

	public static Person getPerson(int id) {
		return getPersonOptional(id).orElse(null);
	}
}
