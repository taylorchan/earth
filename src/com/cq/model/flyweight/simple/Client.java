/**2012-5-27**/

package com.cq.model.flyweight.simple;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public class Client {
    
    public static void main(String args[]) {
        FlyWeightFactory fw = new FlyWeightFactory();
        FlyWeight fly1 = fw.factory(new Character('a'));
        fly1.operation("新罗马字体");
        fly1.operation("微软新体");
        FlyWeight fly2 = fw.factory(new Character('b'));
        fly2.operation("阿拉伯字体");
    }
}
