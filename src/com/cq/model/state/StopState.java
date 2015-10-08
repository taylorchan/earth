/**2012-5-26**/

package com.cq.model.state;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
 */
public class StopState extends State {
    
    /**
     * @param context
     */
    StopState() {
        super();
        // TODO �Զ����ɹ��캯�����ע�ͣ����캯��ʵ��ʱ��ɾ����ע��
    }
    
    /**
     * ֹͣ��ʱ������ű������ǹ��ŵģ����Բ��ù��ˡ�
     * 
     * @see com.cq.model.state.State#close()
     */
    @Override
    void close() {
        
    }
    
    /**
     * ����ִ�п��ŵĶ���ss
     * 
     * @see com.cq.model.state.State#open()
     */
    @Override
    void open() {
        // context.open();
        context.setState(Context.open);
        context.getState().open();
    }
    
    /**
     * ֹͣ��ʱ�򣬿���������
     * 
     * @see com.cq.model.state.State#run()
     */
    @Override
    void run() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        // context.run();
        context.setState(Context.run);
        context.getState().run();
    }
    
    /**
     * @see com.cq.model.state.State#stop()
     */
    @Override
    void stop() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        System.out.println("the lift is stopping now!");
    }
    
}
