/**2012-6-29**/

package com.cq.effectivejava.p74;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *子类实现序列化接口 因为父类未实现接口，所以需要在子类中读写父类中的属性，不然无法完成子类的序列化
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-6-29 陈强新建
 */
public class Foo extends AbstractFoo implements Serializable {
    
    /***/
    private static final long serialVersionUID = -2923620762270344659L;
    
    private void readObject(ObjectInputStream s) {
        int x1 = 0, y1 = 0;
        try {
            s.defaultReadObject();
            x1 = s.readInt();
            y1 = s.readInt();
        } catch (IOException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        initialize(x1, y1);
    }
    
    private void writeObject(ObjectOutputStream s) {
        try {
            s.defaultWriteObject();
            s.writeInt(getX());
            s.writeInt(getY());
        } catch (IOException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
    }
    
    public Foo(int x, int y) {
        super(x, y);
    }
    
}
