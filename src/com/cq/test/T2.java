/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-4-10
 * @version : 1.0
 */
public class T2 {
    
    public T2() {
        super();
    }
    
    private static class Person{
        int id;
        int root;
        boolean modifed = false;
        public Person(int id){
            this.id = id;
            this.root = id;
        }

       @Override 
        public String toString(){
           return "id is: " + this.id + ",  root is: " + this.root;
        }

      @Override 
       public boolean equals(Object o){
           return this.root == Person.class.cast(o).root;
       }
      
      @Override 
       public int hashCode(){
          return String.valueOf(this.root).hashCode();
       }
    }
    private static class Connection {
        int start;
        int end;
        
        Connection(int _start,int  _end){
            this.start = _start;
            this.end = _end;
        }
        /* (non-Javadoc)
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public String toString(){
            return "< " + this.start + ", " + this.end + " >";
        }
    }
    
    private static class Xcomparator implements Comparator<Connection>{

        /* (non-Javadoc)
         * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
         */
        @Override
        public int compare(Connection o1, Connection o2) {
            if(o1.start == o2.start)
                return o1.end - o2.end;
            return o1.start - o2.start;
        }
    }
    
    private static void fixNodeRecursion(List<Connection> list, List<Person> pList){
        for(Connection con : list){
            int left = con.start;
            int right = con.end;

            Person leftP = pList.get(left - 1);
            Person rightP = pList.get(right - 1);
            int leftRoot = leftP.root;
            int rightRoot = rightP.root;
            int minRoot = Math.min(leftRoot, rightRoot);
            leftP.root = rightP.root = minRoot;
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String t = sc.nextLine();
            List<Person> persons = new ArrayList<Person>();
            int T = Integer.parseInt(t);
            for(int i=0; i<T; i++){
                persons.add( new Person(i+1));
            }
            int m = Integer.parseInt(sc.nextLine());
            List<Connection> pq = new ArrayList<Connection>(m);
            for(int i=0; i<m; i++){
                String s = sc.nextLine();
                String tmp[] = s.split(" ");
                int start = Integer.parseInt(tmp[0]);
                int end = Integer.parseInt(tmp[1]);
                int left = Math.min(start, end);
                int right = Math.max(start, end);
                Connection co = new Connection(left, right);
                pq.add(co);
            }
            Collections.sort(pq, new Xcomparator());
            fixNodeRecursion(pq,  persons);
            Set<Person> set =  new HashSet<Person>(persons);
            System.out.println(set.size());
        }
    }
}
