/**2012-3-19**/

/**2012-3-19**/

package com.cq.model.observer;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-3-19 陈强新建
 */
// 为那些在Subject发生改变时需获得通知的对象定义一个更新接口。
public interface Observer {
    
    public void notice();
}
