package headfirst.designpatterns.strategy.algorithms2;

import headfirst.designpatterns.strategy.algorithms2.QuackBehavior;

public class Squeak implements QuackBehavior {
	public void quack() {
		System.out.println("Squeak");
	}
}
