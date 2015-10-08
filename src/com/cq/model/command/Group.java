/**2012-5-25**/

package com.cq.model.command;

/**
 * 项目组分为三个,每个组可接受各种请求
 * 
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-25 ��ǿ�½�
 */
public abstract class Group {
    
    abstract void find();
    
    abstract void add();
    
    abstract void change();
    
    abstract void delete();
}
