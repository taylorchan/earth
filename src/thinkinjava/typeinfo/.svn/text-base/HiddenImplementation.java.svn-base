//: typeinfo/HiddenImplementation.java
// Sneaking around package access.

package typeinfo;

import java.lang.reflect.Method;

import typeinfo.interfacea.A;
import typeinfo.packageaccess.HiddenC;

public class HiddenImplementation {
    
    public static void main(String[] args) throws Exception {
        A a = HiddenC.makeA();
        System.out.println(a.getClass().getName());
        a.f();
        System.out.println(a.getClass().getName());
        // Compile error: cannot find symbol 'C':
        // c与本类不在同一个包中，C又是默认的可见性，无法引入C无法实现向下转型
        // if(a instanceof C) { C c = (C)a; c.g(); }
        // Oops! Reflection still allows us to call g():
        callHiddenMethod(a, "g");
        // And even methods that are less accessible!
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }
    
    static void callHiddenMethod(Object a, String methodName) throws Exception {
        // 注意 虽然是a的引用，但是getClass的结果却是C
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
} /*
   * Output: public C.f() typeinfo.packageaccess.C public C.g() package C.u()
   * protected C.v() private C.w()
   */// :~
