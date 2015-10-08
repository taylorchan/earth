/**2012-5-25**/

package com.cq.model.command;

/**
 *命令的调用者,发出不同的命令
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-25 ��ǿ�½�
 */
public class Invoker {
    
    private ICommand command;
    
    /**
     * 
     */
    public void action() {
        this.command.execute();
    }
    
    /**
     * @return ��ȡ command����ֵ
     */
    public ICommand getCommand() {
        return command;
    }
    
    /**
     * @param command
     */
    public void setCommand(ICommand command) {
        this.command = command;
    }
}
