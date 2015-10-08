/**2012-5-25**/

/**2012-5-25**/

package com.cq.model.composite.demo;

import java.util.Vector;

/**
 * 树枝构件角色（Picture） 有管理组件的功能
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class Picture extends Graphics {
    
    /**
     * 树枝节点有对其他节点的依赖
     */
    private final Vector<Graphics> list = new Vector<Graphics>(10);
    
    @Override
    public void draw() {
        for (int i = 0; i < list.size(); i++) {
            Graphics g = list.get(i);
            g.draw();
        }
    }
    
    /**
     * 添加组件
     * 
     * @param g
     */
    public void add(Graphics g) {
        list.add(g);
    }
    
    /**
     *去除组件说
     * 
     * @param g
     */
    public void remove(Graphics g) {
        list.remove(g);
    }
    
    /**
     * @param i
     * @return
     */
    public Graphics getChild(int i) {
        return list.get(i);
    }
}
