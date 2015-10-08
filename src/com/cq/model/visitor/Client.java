/**2012-5-26**/

package com.cq.model.visitor;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class Client {
    
    /**
     * @param args
     */
    public static void main(String args[]) {
        ObjectStructure os = new ObjectStructure();
        os.attach(new Man());
        os.attach(new Woman());
        // 成功的时候不同的元素反应不同
        Visitor s = new Success();
        os.display(s);
        // 失败的时候不同的元素反应不同
        Visitor l = new Love();
        os.display(l);
        
    }
}
