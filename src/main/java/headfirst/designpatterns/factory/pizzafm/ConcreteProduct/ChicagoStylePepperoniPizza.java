package headfirst.designpatterns.factory.pizzafm.ConcreteProduct;

import headfirst.designpatterns.factory.pizzafm.AbstractProduct.Pizza;

public class ChicagoStylePepperoniPizza extends Pizza {
	public ChicagoStylePepperoniPizza() {
		name = "Chicago Style Pepperoni Pizza";
		dough = "Extra Thick Crust Dough";
		sauce = "Plum Tomato Sauce";
 
		toppings.add("Shredded Mozzarella Cheese");
		toppings.add("Black Olives");
		toppings.add("Spinach");
		toppings.add("Eggplant");
		toppings.add("Sliced Pepperoni");
	}

	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}
