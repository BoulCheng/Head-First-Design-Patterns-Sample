package headfirst.designpatterns.strategy.algorithms2;

import headfirst.designpatterns.strategy.algorithms2.QuackBehavior;

public class Quack implements QuackBehavior {
	public void quack() {
		System.out.println("Quack");
	}
}
