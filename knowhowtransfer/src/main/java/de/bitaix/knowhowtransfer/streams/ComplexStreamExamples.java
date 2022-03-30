package de.bitaix.knowhowtransfer.streams;

import java.time.LocalDate;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import de.bitaix.knowhowtransfer.streams.TestData.Person;

public class ComplexStreamExamples {
	
	
	public void printNamesAsHugeStringOldSchool() {
		List<Person> allPersons = TestData.getAllPersons();
		
		String result = "";
		int count = 0;
		
		for (Person person : allPersons) {
			count++;
			if (person.getId() != null) {
				if (person.getFirstName() != null) {
					result += person.getFirstName().toUpperCase();

					if(count < allPersons.size() - 1) {
						result += ", ";
					}
				}
			}
		}
		System.out.println(result);
	}
	
	
	public void getNamesAsHugeStringStreams() {
		String collect = TestData.getAllPersons().stream()
				.filter(p -> p.getId() != null && p.getFirstName() != null)
				.map(p -> p.getFirstName().toUpperCase())
				.collect(Collectors.joining(", "));
		
		System.out.println(collect);
		
	}
	
	
	public void getAllWithBirthDatesAscendingOldSchool(){
		List<Person> allPersons = TestData.getAllPersons();
		
		Map<LocalDate, Person> date2Person = new HashMap<>();

		for (Person person : allPersons) {
			if(person.getDateOfBirth() != null) {
				LocalDate date = LocalDate.parse(person.getDateOfBirth());
				date2Person.put(date, person);
			}
		}
		
		List<LocalDate> keyList = new ArrayList<>(date2Person.keySet());
		Collections.sort(keyList);
		
		List<Person> result = new ArrayList<>();
		
		for (LocalDate localDate : keyList) {
			result.add(date2Person.get(localDate));
		}
		System.out.println(result);
	}
	
	public void getAllWithBirthDatesAscendingStreams(){
		    List<Person> result = TestData.getAllPersons()
				.stream()
				.filter(p -> p.getDateOfBirth() != null)
				.map(this::createDatePersonMapEntry)
				.sorted((pMap1, pMap2) -> pMap1.getKey().compareTo(pMap2.getKey()))
				.map(SimpleEntry::getValue)
				.collect(Collectors.toList());
		    
		    System.out.println(result);
	}

	private SimpleEntry<LocalDate, Person> createDatePersonMapEntry(Person p) {
		return new SimpleEntry<>(LocalDate.parse(p.getDateOfBirth()), p);
	}
	
}
