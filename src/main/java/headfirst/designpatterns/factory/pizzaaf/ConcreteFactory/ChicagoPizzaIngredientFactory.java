package headfirst.designpatterns.factory.pizzaaf.ConcreteFactory;

import headfirst.designpatterns.factory.pizzaaf.AbstractFactory.PizzaIngredientFactory;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Clams.Clams;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Cheese.Cheese;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Cheese.MozzarellaCheese;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Clams.FrozenClams;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Dough.Dough;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Dough.ThickCrustDough;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Pepperoni.Pepperoni;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Pepperoni.SlicedPepperoni;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Sauce.PlumTomatoSauce;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Sauce.Sauce;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Veggies.BlackOlives;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Veggies.Eggplant;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Veggies.Spinach;
import headfirst.designpatterns.factory.pizzaaf.ProductFamily.Veggies.Veggies;

/**
 * 每个具体工厂类都能生成一组产品，即一组接口的各个实例对象
 */
public class ChicagoPizzaIngredientFactory
	implements PizzaIngredientFactory
{

	public Dough createDough() {
		return new ThickCrustDough();
	}

	public Sauce createSauce() {
		return new PlumTomatoSauce();
	}

	public Cheese createCheese() {
		return new MozzarellaCheese();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new BlackOlives(),
		                      new Spinach(),
		                      new Eggplant() };
		return veggies;
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Clams createClam() {
		return new FrozenClams();
	}
}
