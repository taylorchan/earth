/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.test;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-10-6
 * @version : 1.0
 */
public class Base{
    private String baseName = "base";
    public Base() {
        callName();
    }
 
    public void callName()
    {
        System. out. println(baseName);
    }
 
    static class Sub extends Base {
        private String baseName = "sub";
        public void callName(){
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args) {
        Base b = new Sub();
    }
}
