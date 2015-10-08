/**2012-5-25**/

package com.cq.model.template;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public abstract class AbstractHammerModel {
    
    protected abstract void start();
    
    protected abstract void stop();
    
    /**
     * 此基本方法叫做具体方法
     */
    protected abstract void alarm();
    
    /**
     * 定义钩子方法
     * 
     * @return
     */
    protected boolean isAlarm() {
        return true;
    }
    
    /**
     * 发动机启动，在抽象类中实现了的基本方法，叫做具体方法
     */
    protected void boom() {
        System.out.println("the engine boom！！！");
    };
    
    /**
     * 此方法即为模板方法，子类中不能覆盖此方法
     */
    final protected  void run() {
        start();
        boom();
        if (this.isAlarm()) {// 调用方法钩子，子类中只需要选择是否重写钩子方法即可
            alarm();
        }
        stop();
    }
    
}
