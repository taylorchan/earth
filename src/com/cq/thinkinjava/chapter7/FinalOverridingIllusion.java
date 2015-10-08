//: reusing/FinalOverridingIllusion.java
// It only looks like you can override
// a private or private final method.

package com.cq.thinkinjava.chapter7;

import static net.mindview.util.Print.print;

/**
 * 覆盖，只有某方法是基类接口的一部分的时候才会出现。即必须能向上转型并调用相同方法
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-4-30 陈强新建
 */
class WithFinals {
    
    // Identical to "private" alone:
    private final void f() {// 这里final多余，可以不用，private会自动加final
        print("WithFinals.f()");
    }
    
    // Also automatically "final":
    private void g() {// 私有成员，不能算基类接口的一部分
        print("WithFinals.g()");
    }
    
    protected void h() {
        System.out.println("withFnals's h()");
    }
}

class OverridingPrivate extends WithFinals {
    
    private void f() {
        print("OverridingPrivate.f()");
    }
    
    private void g() {
        print("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {
    
    public final void f() {
        print("OverridingPrivate2.f()");
    }
    
    public void g() {
        print("OverridingPrivate2.g()");
    }
}

public class FinalOverridingIllusion {
    
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can't call the methods:s私有成员，如何访问的到？
        // ! op.f();
        // ! op.g();
        // Same here:
        WithFinals wf = op2;
        wf.h();
        // ! wf.f();
        // ! wf.g();
    }
} /*
   * Output: OverridingPrivate2.f() OverridingPrivate2.g()
   */// :~
