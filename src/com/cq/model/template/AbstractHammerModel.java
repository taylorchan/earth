/**2012-5-25**/

package com.cq.model.template;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-25 ��ǿ�½�
 */
public abstract class AbstractHammerModel {
    
    protected abstract void start();
    
    protected abstract void stop();
    
    /**
     * �˻��������������巽��
     */
    protected abstract void alarm();
    
    /**
     * ���平�ӷ���
     * 
     * @return
     */
    protected boolean isAlarm() {
        return true;
    }
    
    /**
     * �������������ڳ�������ʵ���˵Ļ����������������巽��
     */
    protected void boom() {
        System.out.println("the engine boom������");
    };
    
    /**
     * �˷�����Ϊģ�巽���������в��ܸ��Ǵ˷���
     */
    final protected  void run() {
        start();
        boom();
        if (this.isAlarm()) {// ���÷������ӣ�������ֻ��Ҫѡ���Ƿ���д���ӷ�������
            alarm();
        }
        stop();
    }
    
}