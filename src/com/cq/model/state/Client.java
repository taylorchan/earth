/**2012-5-26**/

package com.cq.model.state;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-5-26 陈强新建
 */
public class Client {
    
    /**
     * @param args
     */
    public static void main(String args[]) {
        Context con = new Context();
        con.setState(new CloseState());
        con.open();
        con.close();
        con.run();
        con.stop();
        
    }
}
