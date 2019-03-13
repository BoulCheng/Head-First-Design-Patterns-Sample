package headfirst.designpatterns.strategy.client;

import headfirst.designpatterns.strategy.algorithms1.FlyWithWings;
import headfirst.designpatterns.strategy.algorithms2.Quack;

public class RedHeadDuck extends Duck {
 
	public RedHeadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
 
	public void display() {
		System.out.println("I'm a real Red Headed duck");
	}
}
