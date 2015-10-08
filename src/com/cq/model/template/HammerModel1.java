/**2012-5-25**/

package com.cq.model.template;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class HammerModel1 extends AbstractHammerModel {
    
    /**
     * @see com.cq.model.template.AbstractHammerModel#alarm()
     */
    @Override
    protected void alarm() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        System.out.println("hammerq alarms");
    }
    
    /**
     * @see com.cq.model.template.AbstractHammerModel#start()
     */
    @Override
    protected void start() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        System.out.println("hammer1 start!");
    }
    
    /**
     * @see com.cq.model.template.AbstractHammerModel#stop()
     */
    @Override
    protected void stop() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        System.out.println("hammer1 stop");
    }
    
    /**
     * 重写钩子方法
     * 
     * @see com.cq.model.template.AbstractHammerModel#isAlarm()
     */
    @Override
    protected boolean isAlarm() {
        return false;
    }
    
    public static void main(String args[]) {
        AbstractHammerModel hammer = new HammerModel1();
        hammer.run();
    }
}
