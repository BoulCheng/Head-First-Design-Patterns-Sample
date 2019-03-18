package headfirst.designpatterns.factory.pizzaaf.ConcreteFactory;

import headfirst.designpatterns.factory.pizzaaf.AbstractFactory.PizzaIngredientFactory;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Clams.Clams;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Cheese.Cheese;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Cheese.ReggianoCheese;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Clams.FreshClams;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Dough.Dough;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Dough.ThinCrustDough;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Pepperoni.Pepperoni;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Pepperoni.SlicedPepperoni;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Sauce.MarinaraSauce;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Sauce.Sauce;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
 
	public Dough createDough() {
		return new ThinCrustDough();
	}
 
	public Sauce createSauce() {
		return new MarinaraSauce();
	}
 
	public Cheese createCheese() {
		return new ReggianoCheese();
	}
 
	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(), new RedPepper() };
		return veggies;
	}
 
	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FreshClams();
	}
}
