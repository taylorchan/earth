/**2012-5-25**/

package com.cq.model.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 信息查看类，里面有一组项目的集合，需要通过迭代器来访问，所以需要返回自己定义的迭代器
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class ProjectInfo implements IProject {
    
    private final List<Project> ls = new ArrayList<Project>();
    
    /**
     * @see com.cq.model.iterator.IProject#add(int, java.lang.String)
     */
    @Override
    public void add(int num, String name) {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        this.ls.add(new Project(num, name));
    }
    
    /**
     * @see com.cq.model.iterator.IProject#getProjectInfo()
     */
    @Override
    public String getProjectInfo() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return null;
    }
    
    /**
     * 返回自定义迭代器
     * 
     * @see com.cq.model.iterator.IProject#iterator()
     */
    @Override
    public Iterator iterator() {
        // TODO 自动生成方法存根注释，方法实现时请删除此注释
        return new ProjectIterator(this.ls);
    }
    
    public static void main(String args[]) {
        String str = "Project..";
        ProjectInfo p = new ProjectInfo();
        for (int i = 0; i < 100; i++) {
            p.add(i, str + i);
        }
        Iterator it = p.iterator();
        while (it.hasNext()) {
            System.out.println((it.next()));
        }
        
    }
}
