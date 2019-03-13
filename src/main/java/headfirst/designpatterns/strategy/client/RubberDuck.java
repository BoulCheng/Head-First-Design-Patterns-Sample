package headfirst.designpatterns.strategy.client;

import headfirst.designpatterns.strategy.algorithms1.FlyNoWay;
import headfirst.designpatterns.strategy.algorithms2.Squeak;

public class RubberDuck extends Duck {
 
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
 
	public void display() {
		System.out.println("I'm a rubber duckie");
	}
}
