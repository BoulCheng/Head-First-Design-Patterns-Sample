package headfirst.designpatterns.strategy.algorithms1;

import headfirst.designpatterns.strategy.algorithms1.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}
