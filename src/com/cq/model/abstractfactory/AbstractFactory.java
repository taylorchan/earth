/**2012-3-19**/

package com.cq.model.abstractfactory;

/**
 * ���һϵ�еĲ�Ʒ����ĳһ�ֲ�Ʒ 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-3-19 ��ǿ�½�
 */
public interface AbstractFactory{
    
    public Cpu createCpu();
    
    public Mainboard createMainboard();
}
