package headfirst.designpatterns.adapter.ducks.TurkeyAdapter;

import headfirst.designpatterns.adapter.ducks.Duck.Duck;
import headfirst.designpatterns.adapter.ducks.Turkey.Turkey;

public class TurkeyAdapter implements Duck {
	Turkey turkey;
 
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
    
	public void quack() {
		turkey.gobble();
	}
  
	public void fly() {
		for(int i=0; i < 5; i++) {
			turkey.fly();
		}
	}
}
