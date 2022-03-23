package de.bitaix.knowhowtransfer;

import de.bitaix.knowhowtransfer.TestData.Person;

public class OptionalExamples {
	
	public void optionalOldSchool() {
		
		Person person = TestData.getPerson(0);
		
		String result = "";
		
		if (person != null && person.getFirstName().equals("Luke")){
			result = person.getFirstName().toUpperCase();
		}else {
			result = "Luke not found";
		}
		
		System.out.println(result);
		
	}
	
	
	public void optionalExample() {
		
		String result = TestData.getPersonOptional(0)
			.filter(p -> p.getFirstName().equals("Luke"))
			.map(p -> p.getFirstName().toUpperCase())
			.orElse("Luke not found");
		
		System.out.println(result);
		
	}
	

}
