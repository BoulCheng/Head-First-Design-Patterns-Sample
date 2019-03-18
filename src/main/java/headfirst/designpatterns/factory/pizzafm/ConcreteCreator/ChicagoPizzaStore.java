package headfirst.designpatterns.factory.pizzafm.ConcreteCreator;

import headfirst.designpatterns.factory.pizzafm.AbstractCreator.PizzaStore;
import headfirst.designpatterns.factory.pizzafm.AbstractProduct.Pizza;
import headfirst.designpatterns.factory.pizzafm.ConcreteProduct.ChicagoStyleCheesePizza;
import headfirst.designpatterns.factory.pizzafm.ConcreteProduct.ChicagoStyleClamPizza;
import headfirst.designpatterns.factory.pizzafm.ConcreteProduct.ChicagoStylePepperoniPizza;
import headfirst.designpatterns.factory.pizzafm.ConcreteProduct.ChicagoStyleVeggiePizza;

public class ChicagoPizzaStore extends PizzaStore {

    public Pizza createPizza(String item) {
        	if (item.equals("cheese")) {
            		return new ChicagoStyleCheesePizza();
        	} else if (item.equals("veggie")) {
        	    	return new ChicagoStyleVeggiePizza();
        	} else if (item.equals("clam")) {
        	    	return new ChicagoStyleClamPizza();
        	} else if (item.equals("pepperoni")) {
            		return new ChicagoStylePepperoniPizza();
        	} else return null;
	}
}
