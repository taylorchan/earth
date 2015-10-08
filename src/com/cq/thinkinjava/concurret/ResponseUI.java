/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * 
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class ResponseUI extends Thread{
    
    private static volatile double d = 1.0d;
    
    
    /**
     * 
     */
    public ResponseUI() {
        setDaemon(true);
        start();
    }
    @Override
    public void run(){
        while(true){
            d = d + (Math.PI + Math.E)/d;
            try {
                TimeUnit.MILLISECONDS.sleep(500L);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new ResponseUI();
        try {
            System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(d);
    }
    
}
