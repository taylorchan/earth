/**2012-6-28**/

package com.cq.effectivejava.p74;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-28 陈强新建
 */
public class AbstractFoo {
    
    private int x, y;
    
    private enum State {
        NEW, INITIALIZING, INITIALIZED
    };
    
    /**
     * 原子引用，用于确保对象的完整性
     */
    private final AtomicReference<State> init = new AtomicReference<State>();
    
    public AbstractFoo(int x, int y) {
        initialize(x, y);
    }
    
    protected AbstractFoo() {
    }
    
    protected final void initialize(int x, int y) {// 很好的线程安全状态机
        if (!init.compareAndSet(State.NEW, State.INITIALIZING)) {
            throw new IllegalStateException("already initialized!");
        }
        this.x = x;
        this.y = y;
        init.set(State.INITIALIZED);
    }
    
    protected final int getX() {
        checkInit();
        return x;
    }
    
    protected final int getY() {
        checkInit();
        return y;
    }
    
    private void checkInit() {
        if (init.get() != State.INITIALIZED) {
            throw new IllegalStateException("uninitialized");
        }
    }
    
}
