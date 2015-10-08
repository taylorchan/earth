/**2012-5-25**/

package com.cq.model.command;

/**
 * ɾ��ҳ�������
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-25 ��ǿ�½�
 */
public class DeletePageCommand extends Command {
    
    /**
     * �˴�������˭����ִ������籾�����о���ҳ���鸺��ִ������
     * 
     * @see com.cq.model.command.Command#execute()
     */
    @Override
	public void execute() {
        // TODO �Զ���ɷ������ע�ͣ�����ʵ��ʱ��ɾ���ע��
        super.pg.find();
        super.pg.delete();
        super.pg.change();
    }
    
}
