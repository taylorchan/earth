/**2012-6-27**/

package com.cq.effectivejava.p66;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-6-27 陈强新建
 */
public class VolatitleStopThread {
    
    /**
     * 使用volatile后不用对stopRequest采用同步访问 注意，如果是自增类型操作，不能用volatile
     */
    private static volatile boolean stopRequest;
    
    private static long nextkey;
    
    private static final AtomicLong nextNum = new AtomicLong();
    
    public static long generateNextNum() {
        long i = 1l;
        return nextNum.addAndGet(i);
    }
    
    /**
     * 自增的方法
     * 
     * @return
     */
    public static synchronized long getNextKey() {
        return nextkey++;
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
        stopRequest = true;
    }
}
