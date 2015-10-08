/**2012-3-19**/

package com.cq.model.observer;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
// Concrete Observer：
// 1. 维护一个指向ConcreteSubject对象的引用。
// 2. 存储有关状态，这些状态应与Subject的状态保持一致。
// 3. 实现Observer的更新接口以使自身状态与Subject的状态保持一致。
public class ConcreteObserver implements Observer {
    
    private final Subject subject;
    
    public ConcreteObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }
    
    public void notice() {
        
        // your code
        
    }

    /**
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }
    
}
