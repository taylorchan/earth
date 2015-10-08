/**2012-3-19**/

package com.cq.model.observer;

import java.util.ArrayList;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
// 将有关状态存入各 ConcreteObserver对象，当它的状态发生改变时，向它的各个观察者发出通知。

public class ConcreteSubject implements Subject {
    
    private final ArrayList<Observer> observers;
    
    public ConcreteSubject() {
        
        observers = new ArrayList<Observer>();
        
    }
    
    public void registerObserver(Observer o) {
        
        observers.add(o);
        
    }
    
    public void removeObserver(Observer o) {
        
        int i = observers.indexOf(o);
        
        if (i > -1) {
            
            observers.remove(i);
            
        }
        
    }
    
    public void notifyObservers() {
        
        for (int i = 0; i < observers.size(); i++) {
            
            Observer observer = observers.get(i);
            
            observer.notice();
            
        }
        
    }
    
    public void stateChanged() {
        
        notifyObservers();
        
    }
    
    public void setState() {
        
        stateChanged();
        
    }
    
}
