package de.bitaix.knowhowtransfer.functions;

import org.junit.jupiter.api.Test;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FunctionExampleStep2 {
	
	@Data
	@AllArgsConstructor
	public class Animal {

		private String name;

		public void move(MoveFunction moveAction) {
			System.out.println(moveAction.move(this));
		}
	}

	@FunctionalInterface
	public interface MoveFunction {
		
		public String move(FunctionExampleStep2.Animal animal);

	}

	@Test
	public void example() {
		new Animal("Eagle").move(e -> e.getName() + " ...flying...flying..."); 
		new Animal("Shark").move(s -> s.getName() + "swim very fast....");
		new Animal("Penguin").move(p -> p.getName() + "....swim...swim...");
	}
}
