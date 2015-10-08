/**2012-5-26**/

package com.cq.model.visitor;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
 */
public class Client {
    
    /**
     * @param args
     */
    public static void main(String args[]) {
        ObjectStructure os = new ObjectStructure();
        os.attach(new Man());
        os.attach(new Woman());
        // �ɹ���ʱ��ͬ��Ԫ�ط�Ӧ��ͬ
        Visitor s = new Success();
        os.display(s);
        // ʧ�ܵ�ʱ��ͬ��Ԫ�ط�Ӧ��ͬ
        Visitor l = new Love();
        os.display(l);
        
    }
}
