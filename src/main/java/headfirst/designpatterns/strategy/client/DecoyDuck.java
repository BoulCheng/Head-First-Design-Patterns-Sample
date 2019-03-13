package headfirst.designpatterns.strategy.client;

import headfirst.designpatterns.strategy.algorithms1.FlyNoWay;
import headfirst.designpatterns.strategy.algorithms2.MuteQuack;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}
	public void display() {
		System.out.println("I'm a duck Decoy");
	}
}
