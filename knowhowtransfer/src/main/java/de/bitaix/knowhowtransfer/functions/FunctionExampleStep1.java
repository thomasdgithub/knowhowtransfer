package de.bitaix.knowhowtransfer.functions;

import org.junit.jupiter.api.Test;

public class FunctionExampleStep1 {

	public class Animal {

		public void move(MoveAction moveAction) {
			System.out.println(moveAction.move());
		}
	}

	public class Fish extends Animal {
	}

	public class Bird extends Animal {
	}

	public class Eagle extends Animal {
	}

	public class Penguin extends Bird {
	}

	public class Shark extends Fish {
	}

	public interface MoveAction {
		public abstract String move();
	}

	public class FlyAction implements MoveAction {
		@Override
		public String move() {
			return "...flying.... flying.... flying";
		}
	}

	public class SwimAction implements MoveAction {
		@Override
		public String move() {
			return "...swim ....swim ...swim";
		}
	}

	@Test
	public void example() {
		new Shark()
			.move(new SwimAction());
		
		new Eagle()			
			.move(new FlyAction());
		
		new Penguin()			
			.move(new SwimAction());
	}
}
