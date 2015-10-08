/**2012-5-25**/

package com.cq.model.iterator;


/**
 * 所有项目的信息类
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class Project {
    
    int num = 0;
    
    String name = "";
    
    /**
     * @param num
     * @param name
     */
    public Project(int num, String name) {
        this.name = name;
        this.num = num;
    }
    
    /**
     * @see com.cq.model.iterator.IProject#getProjectInfo()
     */
    @Override
    public String toString() {
        return "项目信息为： " + this.num + "    " + this.name;
    }
    
}
