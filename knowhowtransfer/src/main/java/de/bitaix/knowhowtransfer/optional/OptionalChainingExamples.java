package de.bitaix.knowhowtransfer.optional;

import java.time.LocalDate;
import java.util.Optional;

public class OptionalChainingExamples {
	
	
	private LocalDate getDateOfBirth(int id) {
		return LocalDate.of(2000, 1, 1);
	}

	private LocalDate getDefaultDate() {
		return LocalDate.of(2000, 1, 1);
	}
	
	public void dateOfBirthLogic() {
		
		LocalDate dateOfBirth = getDateOfBirth(5);
		
		if(dateOfBirth == null) {
			dateOfBirth = getDefaultDate();
		}
		
		
		if(dateOfBirth == null) {
			throw new IllegalArgumentException();
		}

		System.out.println(dateOfBirth);
	}

	
	
	private Optional<LocalDate> getDateOfBirthOptional(int id) {
		return Optional.of(LocalDate.of(2000, 1, 1));
	}

	private Optional<LocalDate> getDefaultDateOptional() {
		return Optional.of(LocalDate.of(2000, 1, 1));
	}
	
	public LocalDate methodChainingWithOptional() {
		return getDateOfBirthOptional(5)
			.or(this:: getDefaultDateOptional)
			.orElseThrow(IllegalArgumentException::new);
	}
	

	
	
	
	
}
