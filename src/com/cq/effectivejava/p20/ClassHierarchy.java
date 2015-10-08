/**2012-6-20**/

package com.cq.effectivejava.p20;

/**
 * 清晰的类层次设计优于标签类的设计
 * 
 * @author 陈强
 * @since 1.0
 * @version 2012-6-20 陈强新建
 */
public class ClassHierarchy {
    
    abstract class Shape {
        
        abstract double area();
    }
    
    class Circle extends Shape {
        
        double radius;
        
        Circle(double r) {
            this.radius = r;
        }
        
        /**
         * @see com.cq.effectivejava.p20.ClassHierarchy.Shape#area()
         */
        @Override
        double area() {
            // TODO 自动生成方法存根注释，方法实现时请删除此注释
            return Math.PI * radius * radius;
        }
    }
    
    class Rectangle extends Shape {
        
        double length;
        
        double width;
        
        Rectangle(double width, double length) {
            this.length = length;
            this.width = width;
        }
        
        /**
         * @see com.cq.effectivejava.p20.ClassHierarchy.Shape#area()
         */
        @Override
        double area() {
            // TODO 自动生成方法存根注释，方法实现时请删除此注释
            return length * width;
        }
    }
}
