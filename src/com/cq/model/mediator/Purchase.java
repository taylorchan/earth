/**2012-5-26**/

package com.cq.model.mediator;

/**
 * �ɹ���
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
 */
public class Purchase extends AbstractColleague {
    
    /**
     * @param ac
     */
    public Purchase(AbstractMediator ac) {
        super(ac);
        // TODO �Զ����ɹ��캯�����ע�ͣ����캯��ʵ��ʱ��ɾ����ע��
    }
    
    public void buyComputere(int num) {
        mediator.execute("purchase.buy", num);
    }
    
    public void refuseBuy() {
        System.out.println("refuse to buy computer!");
    }
}
