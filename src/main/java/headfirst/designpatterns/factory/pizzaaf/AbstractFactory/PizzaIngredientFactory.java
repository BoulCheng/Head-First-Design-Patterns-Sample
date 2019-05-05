package headfirst.designpatterns.factory.pizzaaf.AbstractFactory;

import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Clams.Clams;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Cheese.Cheese;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Dough.Dough;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Pepperoni.Pepperoni;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Sauce.Sauce;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Veggies.Veggies;

/**
 * 抽象工厂方法模式
 */
public interface PizzaIngredientFactory {
 
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
 
}
