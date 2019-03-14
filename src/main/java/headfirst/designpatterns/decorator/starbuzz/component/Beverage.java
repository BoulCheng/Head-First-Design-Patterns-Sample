package headfirst.designpatterns.decorator.starbuzz.component;

/**
 * 装饰者 被装饰者 超类型 可以是接口
 */
public abstract class Beverage {
	public String description = "Unknown Beverage";
  
	public String getDescription() {
		return description;
	}
 
	public abstract double cost();
}
