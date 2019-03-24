package headfirst.designpatterns.adapter.ducks.TurkeyAdapter;

import headfirst.designpatterns.adapter.ducks.Duck.Duck;
import headfirst.designpatterns.adapter.ducks.Duck.MallardDuck;
import headfirst.designpatterns.adapter.ducks.Turkey.WildTurkey;

public class DuckTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();

		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);

		System.out.println("The Turkey says...");
		turkey.gobble();
		turkey.fly();

		System.out.println("\nThe Duck says...");
		testDuck(duck);

		System.out.println("\nThe TurkeyAdapter says...");
		testDuck(turkeyAdapter);
	}

	static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}
