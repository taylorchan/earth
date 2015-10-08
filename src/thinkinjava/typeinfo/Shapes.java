//: typeinfo/Shapes.java

package typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
    
    void draw() {
        System.out.println(this + ".draw()");
    }
    
    void rotate(Shape sh) {
        if (!(sh instanceof Circle))
            System.out.println(this + ".rotate��");
    }
    
    @Override
    abstract public String toString();
}

class Circle extends Shape {
    
    @Override
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    
    @Override
    public String toString() {
        return "Square";
    }
}

class Triangle extends Shape {
    
    @Override
    public String toString() {
        return "Triangle";
    }
}

class Rhomboid extends Shape {
    
    @Override
    public String toString() {
        return "Rginboid";
    }
}

public class Shapes {
    
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());
        for (Shape shape : shapeList) {
            shape.draw();
            shape.rotate(shape);
        }
        
        Rhomboid rh = new Rhomboid();
        Shape sh = rh;
        System.out.println(sh instanceof Shape && (sh instanceof Rhomboid));
        // ����ת��������ʱ�ǳ���ģ���Ϊ�ڱ���ʱ����������֪�����ľ�������
        // Circle cr = (Circle) sh;
        // cr.draw();
    }
} /*
   * Output: Circle.draw() Square.draw() Triangle.draw()
   */// :~
