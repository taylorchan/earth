/**2012-5-25**/

package com.cq.model.template;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-25 ��ǿ�½�
 */
public class HammerModel1 extends AbstractHammerModel {
    
    /**
     * @see com.cq.model.template.AbstractHammerModel#alarm()
     */
    @Override
    protected void alarm() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        System.out.println("hammerq alarms");
    }
    
    /**
     * @see com.cq.model.template.AbstractHammerModel#start()
     */
    @Override
    protected void start() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        System.out.println("hammer1 start!");
    }
    
    /**
     * @see com.cq.model.template.AbstractHammerModel#stop()
     */
    @Override
    protected void stop() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        System.out.println("hammer1 stop");
    }
    
    /**
     * ��д���ӷ���
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
