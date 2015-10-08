/**2012-5-25**/

package com.cq.model.composite;

/**
 * 树叶构件
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-5-25 陈强新建
 */
public class Leaf implements Component {
    
    public void sampleOperation() {
        // ................
    }
    
    // 返还自己的实例
    public Component getComposite() {
        // .............
        return this;
    }
}
