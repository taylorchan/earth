//: typeinfo/ClassInitialization.java

package typeinfo;

import java.util.Random;

class Initable {
    
    static final int staticFinal = 47;
    
    static final int staticFinal2 = 48;
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    
    static int staticNonFinal = 147;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    
    public static Random rand = new Random(47);
    
    public static void main(String[] args) throws Exception {
        String s1 = "abc";
        String s2 = "def";
        String s3 = "abcdef";
        String s4 = "abc" + "def";
        System.out.println(s3 == s4);
        
        C c = new  C();
    }
    
    public static int add(int a, int b){
        return a + b;
    }
    
    public static String add(String a, String b){
        String aa = "aaa";
        return aa;
    }
} 

class A{    
    A(){
        this.method1();
        this.method2();
    }
    void method1(){
        System.out.println("this is A method1");
    }
    
   private void method2(){
        System.out.println("this is A method2");
    }
}

class C extends A{    
    C(){
       super();
    }
    void method1(){
        System.out.println("this is B method1");
    }
    
   private void method2(){
        System.out.println("this is A method2");
    }
}