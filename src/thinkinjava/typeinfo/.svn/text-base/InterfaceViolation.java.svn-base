//: typeinfo/InterfaceViolation.java
// Sneaking around an interface.

package typeinfo;

import typeinfo.interfacea.A;

class B extends A.C implements A {
    
    public void f() {
    }
    
    public void g() {
        System.out.println("b's g()");
    }
    
    void h() {
        System.out.println("b's h()");
    }
}

public class InterfaceViolation {
    
    public static void main(String[] args) {
        A a = new B();
        a.f();
        // a.g(); // Compile error
        System.out.println(a.getClass().getName());
        if (a instanceof B) {// A的引用是instanceof B的
            B b = (B) a;
            b.g();
        }
        A.C ac = new B();
        if (ac instanceof B) {// A.C的引用是instanceof B的
            B bc = (B) ac;
            bc.h();
        }
    }
} /*
   * Output: B
   */// :~
