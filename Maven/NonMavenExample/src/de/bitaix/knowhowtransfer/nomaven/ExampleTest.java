package de.bitaix.knowhowtransfer.nomaven;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExampleTest {

	@Test
	public void testNonMavenExample() {
		Example example = new Example();
		assertTrue(example.checkStringIsUpperCase("abc"));
	}

}
