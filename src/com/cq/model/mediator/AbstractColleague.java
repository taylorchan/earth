/**2012-5-26**/

/**2012-5-26**/

package com.cq.model.mediator;

/**
 * 各个客户端的父类
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class AbstractColleague {
    
    protected AbstractMediator mediator;
    
    public AbstractColleague(AbstractMediator ac) {
        this.mediator = ac;
    }
}
