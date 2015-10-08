/**2012-5-26**/

package com.cq.model.state;

/**
 * 可与策略模式对比说 这里是一个状态管理器，管理了与电梯相关的所有状态
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class Context {
    
    /** 状态集 */
    public static final State open = new OpenState();
    
    /***/
    public static final State close = new CloseState();
    
    /***/
    public static final State run = new RunState();
    
    /***/
    public static final State stop = new StopState();
    
    private State state;
    
    /**
     * @return 获取 state属性值
     */
    public State getState() {
        return state;
    }
    
    /**
     * @param state 设置 state 属性值为参数值 state
     */
    public void setState(State state) {
        this.state = state;
        this.state.setContext(this);
    }
    
    public void run() {
        this.state.run();
    }
    
    public void open() {
        this.state.open();
    }
    
    public void close() {
        this.state.close();
    }
    
    public void stop() {
        this.state.stop();
    }
}
