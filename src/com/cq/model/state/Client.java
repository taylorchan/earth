/**2012-5-26**/

package com.cq.model.state;

/**
 * @author ��ǿ
 * @since 1.0
 * @version 2012-5-26 ��ǿ�½�
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
