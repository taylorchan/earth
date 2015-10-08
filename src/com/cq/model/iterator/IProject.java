/**2012-5-25**/

package com.cq.model.iterator;

import java.util.Iterator;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public interface IProject {
    
    /**
     * @param num
     * @param name
     */
    public void add(int num, String name);
    
    /**
     * @return
     */
    String getProjectInfo();
    
    /**
     * 返回一个迭代器
     * 
     * @return
     */
    public Iterator iterator();
}
