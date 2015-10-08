/**2012-5-26**/

package com.cq.model.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class ObjectStructure {
    
    private final List<Person> elements = new ArrayList<Person>();
    
    /**
     * @param p
     */
    public void attach(Person p) {
        elements.add(p);
    }
    
    /**
     * @param p
     */
    public void detach(Person p) {
        if (elements.contains(p)) {
            elements.remove(p);
        }
    }
    
    /**
     * 遍历所有的元素
     * 
     * @param v
     */
    public void display(Visitor v) {
        for (Person p : this.elements) {
            p.accept(v);
        }
    }
}
