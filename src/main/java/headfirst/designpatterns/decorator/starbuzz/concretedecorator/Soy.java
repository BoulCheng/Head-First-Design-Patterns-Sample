package headfirst.designpatterns.decorator.starbuzz.concretedecorator;

import headfirst.designpatterns.decorator.starbuzz.component.Beverage;
import headfirst.designpatterns.decorator.starbuzz.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + beverage.cost();
	}
}
