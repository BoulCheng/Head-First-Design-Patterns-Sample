package headfirst.designpatterns.adapter.ducks.DuckAdapter;

import headfirst.designpatterns.adapter.ducks.Duck.MallardDuck;
import headfirst.designpatterns.adapter.ducks.Turkey.Turkey;

public class TurkeyTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();
		Turkey duckAdapter = new DuckAdapter(duck);
 
		for(int i=0;i<10;i++) {
			System.out.println("The DuckAdapter says...");
			duckAdapter.gobble();
			duckAdapter.fly();
		}
	}
}
