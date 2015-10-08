//: exceptions/OnOffSwitch.java
// Why use finally?

package exceptions;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-2-24 陈强新建
 */
public class OnOffSwitch {
    
    private static Switch sw = new Switch();
    
    /**
     * @throws OnOffException1
     * @throws OnOffException2
     */
    public static void f() throws OnOffException1, OnOffException2 {
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            f();
            throw new RuntimeException("my Runtime Exc");
            
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return;
        } finally {
            sw.off();
        }
        return;
        
    }
} /*
   * Output: on off
   */// :~
