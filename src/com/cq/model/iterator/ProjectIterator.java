/**2012-5-25**/

package com.cq.model.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * 自定义迭代器的实现
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class ProjectIterator implements Iterator {
    
    private final List<Project> ls;
    
    private int currentItem = 0;
    
    /**
     * @param ls
     */
    public ProjectIterator(List<Project> ls) {
        this.ls = ls;
    }
    
    /**
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
        if (this.currentItem >= ls.size() || this.ls.get(currentItem) == null) {
            return false;
        }
        return true;
    }
    
    /**
     * @see java.util.Iterator#next()
     */
    @Override
    public Project next() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return this.ls.get(currentItem++);
    }
    
    /**
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        
    }
    
}
