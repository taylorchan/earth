/**2012-3-19**/

/**2012-3-19**/

package com.cq.model.observer;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
public interface Subject {
    
    public void registerObserver(Observer o);
    
    public void removeObserver(Observer o);
    
    public void notifyObservers();
}
