package headfirst.designpatterns.factory.pizzafm.ConcreteCreator;

import headfirst.designpatterns.factory.pizzafm.AbstractCreator.PizzaStore;
import headfirst.designpatterns.factory.pizzafm.AbstractProduct.Pizza;
import headfirst.designpatterns.factory.pizzafm.ConcreteProduct.NYStyleCheesePizza;
import headfirst.designpatterns.factory.pizzafm.ConcreteProduct.NYStyleClamPizza;
import headfirst.designpatterns.factory.pizzafm.ConcreteProduct.NYStylePepperoniPizza;
import headfirst.designpatterns.factory.pizzafm.ConcreteProduct.NYStyleVeggiePizza;

public class NYPizzaStore extends PizzaStore {

	public Pizza createPizza(String item) {
		if (item.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else if (item.equals("veggie")) {
			return new NYStyleVeggiePizza();
		} else if (item.equals("clam")) {
			return new NYStyleClamPizza();
		} else if (item.equals("pepperoni")) {
			return new NYStylePepperoniPizza();
		} else return null;
	}
}
