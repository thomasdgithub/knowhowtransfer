package de.bitaix.knowhowtransfer.functions;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;
import lombok.AllArgsConstructor;
import lombok.Data;

public class FunctionExampleStep3 {
	
	@Data
	@AllArgsConstructor
	public class Animal {

		private String name;

		public void move(Function<String, String> moveAction, Supplier<String> afterMove, Consumer<Exception> onError) {
			try {
				System.out.println(moveAction.apply(name));
				System.out.println(afterMove.get());
			} catch (Exception e) {
				onError.accept(e);
			}
		}
	}

	@Test
	public void example() {
		new Animal("Eagle").move(e -> "...flying...flying...", () -> "sleeping", e -> System.out.println(e.getMessage())); 
		new Animal("Shark").move(s -> "swim very fast...." , () -> "eating...", e -> System.out.println(e.getMessage()));
		new Animal("Penguin").move(p -> "....swim...swim..." , () -> "waiting", e -> System.out.println(e.getMessage()));
	}	
	
}
