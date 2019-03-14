package headfirst.designpatterns.decorator.starbuzz.concretecomponent;

import headfirst.designpatterns.decorator.starbuzz.component.Beverage;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}
 
	public double cost() {
		return .99;
	}
}

