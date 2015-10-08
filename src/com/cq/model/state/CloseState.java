/**2012-5-26**/

package com.cq.model.state;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
 */
public class CloseState extends State {
    
    /**
     * @param context
     */
    CloseState() {
        super();
        // TODO �Զ����ɹ��캯�����ע�ͣ����캯��ʵ��ʱ��ɾ����ע��
    }
    
    /**
     * @see com.cq.model.state.State#close()
     */
    @Override
    void close() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        System.out.println("���ݹرգ�");
    }
    
    /**
     * @see com.cq.model.state.State#open()
     */
    @Override
    void open() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        context.setState(Context.open);// ���ţ��ŵ�״̬Ϊ��
        context.getState().open();// ��ӡ���Ǵ򿪵���Ϣ
        
    }
    
    /**
     * @see com.cq.model.state.State#run()
     */
    @Override
    void run() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        context.setState(Context.run);
        context.getState().run();// ��ӡ�������е���Ϣ����Ϣ
    }
    
    /**
     * @see com.cq.model.state.State#stop()
     */
    @Override
    void stop() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        // context.stop();
        context.setState(Context.stop);
        context.getState().stop();// ��ӡ�������е���Ϣ����Ϣ
    }
    
}
