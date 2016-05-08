package app.receiver.observable;

import java.util.HashMap;

import app.receiver.observer.Observer;

public interface Subject {
	public void run();
	public void registerObserver(Observer observer);
	public void notifyObservers(HashMap result);
	public void removeObserver(Observer observer);
}
