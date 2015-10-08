//: exceptions/StormyInning.java
// Overridden methods may throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions.

package exceptions;

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

abstract class Inning {
    
    public Inning() throws BaseballException {
    }
    
    public void event() throws BaseballException {
        // Doesn't actually have to throw anything
    }
    
    public abstract void atBat() throws Strike, Foul;
    
    public void walk() {
    } // Throws no checked exceptions
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
}

interface Storm {
    
    public void event() throws RainedOut;
    
    public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm {
    
    /**
     * 因为需要隐式的调用父类的默认构造器，所以必须包含父类构造器抛出的异常， 可以多抛出自定义异常
     * 但在子类构造器中，即使显式的调用父类构造器，也无法捕获到父类构造器中的异常
     * 
     * @throws RainedOut
     * @throws BaseballException
     * @throws BaseballException
     */
    public StormyInning() throws RainedOut, BaseballException {
        super();
    }
    
    public StormyInning(String s) throws Foul, BaseballException {
    }
    
    // Regular methods must conform to base class:
    // ! void walk() throws PopFoul {} //Compile error
    // Interface CANNOT add exceptions to existing
    // methods from the base class:
    // ! public void event() throws RainedOut {}
    // If the method doesn't already exist in the
    // base class, the exception is OK:
    /**
     * 接口中的方法在父类中不存在，则在实现类中可选择不抛出异常或者抛出接口方法中抛出的异常
     */
    @Override
    public void rainHard() throws RainedOut {
    }
    
    // You can choose to not throw any exceptions,
    // even if the base version does:
    /**
     * 接口中的方法在父类中存在，抛出的异常即要满足接口也要满足父类， 若不是同一种异常， 只能选择不抛出任何异常
     */
    @Override
    public void event() {
    }
    
    // Overridden methods can throw inherited exceptions:
    @Override
    /**
     * 单纯的覆盖父类的方法，可以选择不抛出任何异常，抛出父类方法中的部分异常
     * 或者是异常的子类
     */
    public void atBat() throws PopFoul {
    }
    
    /**
     * 对于方法声明中抛出的异常，一定要在调用方法的时候捕获， 对于父类引用指向子类对象的做法， 需要捕获父类方法中所抛出的异常
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        // Strike not thrown in derived version.
        try {
            // What happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();
            // You must catch the exceptions from the
            // base-class version of the method:
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
} // /:~
