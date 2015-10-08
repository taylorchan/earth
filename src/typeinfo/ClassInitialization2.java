/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package typeinfo;


/**
 * 
 * @author:   chenqiang3
 * @since:    2015-3-14
 * @version : 1.0
 */

class SuperClass{
    static{
        System.out.println("superclass init");
    }
    String name;

    public SuperClass(){
    }

    public SuperClass(String _name){
        this.name = _name;
    }
    
    public static int value  = 123;
}

class SubClass extends SuperClass{
    
    static{
        System.out.println("subclass init");
    }
    
   // public static int value  = 456;
    
}

class SubClass2 extends SuperClass{
    
    public SubClass2(){
        super("ddddddddddddddddd");
    }

    static{
        System.out.println("subclass init");
    }
    
   // public static int value  = 456;
    
}
public class ClassInitialization2 {

        public static void main(String args[]){
             int _value = SubClass.value;
            System.out.println(_value);
            
            SuperClass sub1 = new SubClass();
            }
    
}
