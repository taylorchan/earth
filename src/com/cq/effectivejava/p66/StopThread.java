/**2012-6-27**/

package com.cq.effectivejava.p66;

import java.util.concurrent.TimeUnit;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-27 陈强新建
 */
public class StopThread {
    
    private static boolean stopRequest;
    
    private static synchronized void requestStop() {
        stopRequest = true;
    }
    
    private static synchronized boolean stopRequest() {
        return stopRequest;
    }
    
    public static void main(String[] args) {
        Thread backgroundThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                int i = 0;
                while (!stopRequest) {
                    i++;
                }
                System.out.println(i);
            }
        });
        backgroundThread.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        }
        requestStop();
    }
}
