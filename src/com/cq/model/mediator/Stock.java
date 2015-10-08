/**2012-5-26**/

package com.cq.model.mediator;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
 */
public class Stock extends AbstractColleague {
    
    /**
     * @param ac
     */
    public Stock(AbstractMediator ac) {
        super(ac);
        // TODO �Զ����ɹ��캯�����ע�ͣ����캯��ʵ��ʱ��ɾ����ע��
    }
    
    private static int num = 100;
    
    /**
     * �����󣬷�����Ҫ�������۵ľ���
     */
    public void warn() {
        System.out.println("�����Ϊ" + Stock.num);
        mediator.execute("stock.warn");
    }
    
    /**
     * @return ��ȡ num����ֵ
     */
    public static int getNum() {
        return num;
    }
    
    /**
     * @param num ���� num ����ֵΪ����ֵ num
     */
    public static void addNum(int num) {
        Stock.num += num;
    }
    
    /**
     * @param num ���� num ����ֵΪ����ֵ num
     */
    public static void decreaseNum(int num) {
        Stock.num -= num;
    }
    
    public void clearStock() {
        mediator.execute("stock.clear");
    }
}
