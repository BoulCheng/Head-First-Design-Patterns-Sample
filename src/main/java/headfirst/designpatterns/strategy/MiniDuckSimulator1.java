package headfirst.designpatterns.strategy;

import headfirst.designpatterns.strategy.algorithms1.FlyRocketPowered;
import headfirst.designpatterns.strategy.client.Duck;
import headfirst.designpatterns.strategy.client.MallardDuck;
import headfirst.designpatterns.strategy.client.ModelDuck;

public class MiniDuckSimulator1 {
 
	public static void main(String[] args) {
 
		Duck mallard = new MallardDuck();
		mallard.performQuack();
		mallard.performFly();
   
		Duck model = new ModelDuck();
		model.performFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.performFly();

	}
}
