package DesignPatterns.Behavioral.Observer;

import java.util.ArrayList;

public interface Observer { // personally I like to call these listeners instead of observers
    ArrayList<Observer> observers = new ArrayList<>(); // list of observers
    static void update(){
        observers.forEach(Observer::response);
    };
    default void subscribe(){
        observers.add(this);
    };
    default void unsubscribe(){
        observers.remove(this);
    }
    void response();
    
}
