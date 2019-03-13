package headfirst.designpatterns.observer.weather.subject;

import headfirst.designpatterns.observer.weather.Observer.Observer;

/**
 * 主题
 */
public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
