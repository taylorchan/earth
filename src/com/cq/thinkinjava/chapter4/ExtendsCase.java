/**2012-4-30**/

package com.cq.thinkinjava.chapter4;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-4-30 陈强新建
 */
public class ExtendsCase extends Fibonacci {
    
    private final int in;
    
    ExtendsCase(int i) {
        // super();
        in = i;// final field must be initialized before use
    }
    
    private void h() {
        f();
    }
    
    @Override
    void f() {
    }
}
