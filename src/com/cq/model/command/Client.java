/**2012-5-25**/

package com.cq.model.command;

/**
 * ģ��ͻ��˵�������
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-25 ��ǿ�½�
 */
public class Client {
    
    public static void main(String args[]) {
        // �ӿ��ˣ�������պ�ִ������
        Invoker zhangsan = new Invoker();
        
        // һ���µ�ɾ��ҳ������
        Command command = new DeletePageCommand();
        zhangsan.setCommand(command);
        zhangsan.action();
        
    }
}
