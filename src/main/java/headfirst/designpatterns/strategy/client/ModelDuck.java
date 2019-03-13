package headfirst.designpatterns.strategy.client;

import headfirst.designpatterns.strategy.algorithms1.FlyNoWay;
import headfirst.designpatterns.strategy.algorithms2.Quack;

public class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a model duck");
	}
}
