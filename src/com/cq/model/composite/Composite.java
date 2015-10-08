/**2012-5-25**/

package com.cq.model.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * 树枝构件（Composite）类
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class Composite implements Component {
    
    private final Vector<Component> componentVector = new Vector<Component>();
    
    // 返还自己的实例
    public Component getComposite() {
        return this;
    }
    
    public void sampleOperation() {
        Enumeration enumeration = getChild(); // components()
        while (enumeration.hasMoreElements()) {
            ((Component) enumeration.nextElement()).sampleOperation();
        }
    }
    
    /**
     * 聚集管理方法
     * 
     * @param component
     */
    public void add(Component component) {
        componentVector.addElement(component);
    }
    
    /**
     * @param component
     */
    public void remove(Component component) {
        componentVector.removeElement(component);
    }
    
    /**
     * 聚集管理方法，返还聚集的Enumeration对象
     * 
     * @return
     */
    public Enumeration getChild() {
        return componentVector.elements();
    }
}
