//: generics/GenericMethods.java

package generics;

public class GenericMethods {
    
    public <T, R, S> void f(T x, R r, String s) {
        System.out.println(x.getClass().getName());
        System.out.println(r.getClass().getName());
        System.out.println(s.getClass().getName());
    }
    
    // 从结果来看，基本类型不能应用于泛型编程
    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", 5.0f, "");
        // gm.f(1);
        // gm.f(1.0);
        // gm.f(1.0F);
        // gm.f('c');
        // gm.f(gm);
    }
} /*
   * Output: java.lang.String java.lang.Integer java.lang.Double java.lang.Float
   * java.lang.Character GenericMethods
   */// :~
