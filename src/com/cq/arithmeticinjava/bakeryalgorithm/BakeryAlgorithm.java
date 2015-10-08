/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.bakeryalgorithm;

import java.util.Random;


/**
 * a algorithm for critial section
 * @author:   taylor
 * @since:    2013-1-25
 * @version : 1.0
 */
public class BakeryAlgorithm {
    static int counter = 0;
    static Random rd = new Random(31);
    static Custom[] cusoms = new Custom[10];
    static boolean[] chose = new boolean[10];
    public static void main(String[] args) {
       
        for (int i = 0; i < cusoms.length; i++) {
            cusoms[i] = creatCustom();
        }
        Thread t = null;
        for (int i = 0; i < cusoms.length; i++) {
            t = new Thread(cusoms[i]);
            t.start();
        }
    }
    
    
    public static Custom creatCustom(){
       
        return new Custom(rd.nextInt(30),counter++);
        
    }
    
    public static int getMaxCustomNum(){
        int max = 0;
        for (int i = 0; i < cusoms.length; i++) {
            if(cusoms[i] == null)
                continue;
            if(cusoms[i].number > max){
                max = cusoms[i].number;
            }
        }
        return max;
    }
    

     static class Custom implements Runnable,Comparable<Custom>{
        int name;
        int no;
        int number = 0;
        
        
        Custom(int sn,int no){
            this.name = sn;
            this.no = no;
        }

        /* (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        @Override
        public void run() {
            while(true){
                chose[no] = true;
                System.out.println(this + " is ready to access critical seciton now!");
                number = getMaxCustomNum() + 1;//给新来的用户分配一个号码
                chose[no] = false;
                for(int j = 0;j < 10;j++){
                    while(chose[j]){
                        while(cusoms[j].number != 0 && cusoms[j].compareTo(this) < 0){//这里是检查是否当前进程是否需要等待
                            System.out.println(this + "  is waiting for " + cusoms[j]);
                        }
                    }
                }
                System.out.println(this + "  is in critical seciton now!");
                number = 0;
                break;
            }
        }

        /* (non-Javadoc)
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo(Custom o) {
            if(this.number != o.number)
                return number - o.number;
            else 
                return this.name - o.name;
        }
        
        public String toString(){
            return this.name + "--- " + number; 
        }
    }
}

