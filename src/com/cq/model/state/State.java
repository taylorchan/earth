/**2012-5-26**/

package com.cq.model.state;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public abstract class State {
    
    protected Context context;
    
    /**
     * @return 获取 context属性值
     */
    public Context getContext() {
        return context;
    }
    
    /**
     * @param context 设置 context 属性值为参数值 context
     */
    public void setContext(Context context) {
        this.context = context;
    }
    
    State() {
    }
    
    abstract void open();
    
    abstract void close();
    
    abstract void run();
    
    abstract void stop();
    
}
