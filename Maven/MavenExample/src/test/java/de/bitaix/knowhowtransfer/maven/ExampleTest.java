package de.bitaix.knowhowtransfer.maven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import de.bitaix.exampledependency.MyDependencyService;

class ExampleTest {

	@Test
	void test() {
		Example example = new Example();

		assertTrue(example.checkString());

	}

	@Test
	void testDependencyChanges() {
		MyDependencyService myDependencyService = new MyDependencyService();
		assertEquals("This is just a String!", myDependencyService.justGiveMeAString());
	}

}
