/**2012-5-25**/

package com.cq.model.command;

/**
 * ������������
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-25 ��ǿ�½�
 */
public class AddRequirementCommand extends Command {
    
    /**
     * @see com.cq.model.command.Command#execute()
     */
    @Override
	public void execute() {
        // TODO �Զ����ɷ������ע�ͣ�����ʵ��ʱ��ɾ����ע��
        super.requirementGroup.find();
        super.requirementGroup.change();
    }
    
}
