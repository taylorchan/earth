/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.model.adaper;


/**
 * 
 * @author:   taylor
 * @since:    2013-1-14
 * @version : 1.0
 */
public class OuterUserInfo2 implements IUserInfo{
    /**
     * 与装饰模式的区别，若是装饰模式，这里成员接口与本身所实现的接口必须要一致
     */
    private IOuterUser outUser = new OuterUser();

    /* (non-Javadoc)
     * @see com.cq.model.adaper.IUserInfo#getUserName()
     */
    @Override
    public String getUserName() {//将一个接口转换成另外一个接口,而装饰者模式中不改变接口，只是添加职责
        // TODO Auto-generated method stub
        return outUser.getSelfUserInfo().get("name");
    }
    
    
}
