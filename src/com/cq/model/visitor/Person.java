/**2012-5-26**/

package com.cq.model.visitor;

/**
 * ģ��ڵ�Ľӿ�
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
 */
public interface Person {
    
    /**
     * @param visitor
     */
    void accept(Visitor visitor);
}
