/**2012-5-27**/

package com.cq.model.flyweight.complex;

import java.util.ArrayList;
import java.util.List;

import com.cq.model.flyweight.simple.FlyWeight;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-27 陈强新建
 */
public class Client {
    
    public static void main(String args[]) {
        List<Character> ls = new ArrayList<Character>(5);
        ls.add('a');
        ls.add('b');
        ls.add('c');
        ls.add('a');
        ls.add('c');
        
        FlyWeightFactory fwf = new FlyWeightFactory();
        FlyWeight fw1 = fwf.factory(ls);
        FlyWeight fw2 = fwf.factory(ls);
        
        fw1.operation("complexmodel call!!");
        fw2.operation("fw2 call");
        
    }
}
