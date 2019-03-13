package headfirst.designpatterns.strategy.client;

import headfirst.designpatterns.strategy.algorithms1.FlyWithWings;
import headfirst.designpatterns.strategy.algorithms2.Quack;

public class MallardDuck extends Duck {

	public MallardDuck() {

		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();

	}

	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}
