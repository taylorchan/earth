/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-4-19
 * @version : 1.0
 */
public class T3 {
    
    public T3() {
        super();
    }
    
    private static class Person{
        int left;
        Person(int left){
            this.left = left;
        }
        
        public String toString(){
            return "" + left;
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int kill = Integer.parseInt(sc.nextLine());
            int num = Integer.parseInt(sc.nextLine());
            String lefts = sc.nextLine().trim();
            List<Person> list = new ArrayList<Person>();
            String[] tmp = lefts.split(" "); 
            for(String t : tmp){
                list.add(new Person(Integer.parseInt(t)));
            }
            int i=0;
            int size = list.size();
            int maxKill = 0;
            loop1:
            for(; i<size; i++){
                if((size-1-i) < maxKill) break;
                Person p = list.get(i);
                int kill_left = kill;
                int killed = 0;
                if(p.left <= kill_left){//开始找
                    kill_left -= p.left;
                    killed++;
                    for(int j = 1; j<=size-1 && kill_left >0; j++){
                        int next_index = (i + j) % size;
                        Person next = list.get(next_index);
                        if(next.left <=kill_left){
                            kill_left -= next.left;
                            killed++;
                        }
                    }
                }
                maxKill = killed > maxKill ? killed : maxKill;
                if(maxKill == list.size()){
                    break loop1;
                }
            } 
            System.out.println(maxKill);
        } 
    }
}
