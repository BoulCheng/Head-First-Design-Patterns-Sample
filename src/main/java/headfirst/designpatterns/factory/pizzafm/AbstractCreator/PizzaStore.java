package headfirst.designpatterns.factory.pizzafm.AbstractCreator;

import headfirst.designpatterns.factory.pizzafm.AbstractProduct.Pizza;

/**
 * 工厂方法模式
 */
public abstract class PizzaStore {
 
	public abstract Pizza createPizza(String item);
 
	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		System.out.println("--- Making a " + pizza.getName() + " ---");
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;
	}
}
