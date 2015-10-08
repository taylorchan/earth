/**2012-5-25**/

package com.cq.model.adaper;


/**
 * 这就是一个类适配器，继承了需要适配的对象
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class OuterUserInfo extends OuterUser implements IUserInfo {
    
    
    /**
     * @see com.cq.model.adaper.IUserInfo#getUserName()
     */
    @Override
    public String getUserName() {// 完成适配
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return getSelfUserInfo().get("name");
    }
    
}
