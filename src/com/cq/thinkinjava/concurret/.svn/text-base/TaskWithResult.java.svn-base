/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.concurret;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 返回值的线程
 * @author: qiang.chen
 * @since:    2012-7-25
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class TaskWithResult {
    
    static class Result implements Callable<String>{
        private int id;
        
        /**
         * 
         */
        public Result(int id) {
            this.id = id;
        }
        @Override
        public String call(){
            return "task of result: "+ id;
        }
        
    }
    
    public static void main(String[] args) {
        //可以复线程对象的线程池
       ExecutorService exe = Executors.newCachedThreadPool();
       List<Future<String>> resultList = new ArrayList<Future<String>>();
       for (int i = 0; i < 5; i++) {
           resultList.add(exe.submit(new Result(i)));
       }
       for (Future<String> future : resultList) {
           try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       }
        
        
        
    }
   
}
