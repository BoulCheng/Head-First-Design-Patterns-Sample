package headfirst.designpatterns.decorator.starbuzz.concretecomponent;

import headfirst.designpatterns.decorator.starbuzz.component.Beverage;

public class Decaf extends Beverage {
	public Decaf() {
		description = "Decaf Coffee";
	}
 
	public double cost() {
		return 1.05;
	}
}

