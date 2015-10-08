//: typeinfo/ClassInitialization.java

package com.cq.thinkinjava.chapter14;

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
        //使用.class的方式不会引发初始化
        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // Does not trigger initialization:
        // 常量，直接在常量池中访问
        System.out.println(Initable.staticFinal);
        // Does trigger initialization:
        // 现在开始初始化
        System.out.println(Initable.staticFinal2);
        // Does trigger initialization:
        System.out.println(Initable2.staticNonFinal);
        //使用Class.forName会引发初始化
        Class clazz = Class.forName("com.cq.thinkinjava.chapter14.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }
} /*
   * Output: After creating Initable ref 47 Initializing Initable 258
   * Initializing Initable2 147 Initializing Initable3 After creating Initable3
   * ref 74
   */// :~
