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
public class T4 {
    
    public T4() {
        super();
    }
    
    private static class Segment implements Comparable<Segment>{
        int start;
        int end;
        int sum = 0;
        Segment(int start, int end, int sum){
            this.start = start;
            this.end = end;
            this.sum += sum;
        }
        
        public String toString(){
            return  "<" + this.start + ", "  + this.end + ">" + " => " + this.sum;
        }

        /* (non-Javadoc)
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo(Segment o) {
            return o.sum -  this.sum;
        }
    }
    
    private static void addSegment(Segment insert){
        int index = 0;
        boolean slice = false;
        while(index < list.size()){
            Segment base = list.get(index);
            record = base.sum > record ? base.sum : record;
             if(insert.end < base.start || insert.start > base.end){//do nothing
                 index++;
            }else{
                int seg1_start = 0;
                int seg1_end = 0;
                int seg1_sum = 0;

                int seg2_start = 0;
                int seg2_end = 0;
                int seg2_sum = 0;

                int seg3_start = 0;
                int seg3_end = 0;
                int seg3_sum = 0;
         
                if(insert.start < base.start){//seg1
                    seg1_start  = insert.start;
                    seg1_end = base.start - 1;
                    seg1_sum = insert.sum;
                    seg2_start = seg1_end + 1;
                }else if(insert.start > base.start){
                    seg1_start  = base.start;
                    seg1_end = insert.start -1 ;
                    seg1_sum = base.sum;
                    seg2_start = seg1_end + 1;
                }else{
                    seg2_start = base.start;
                }
                
                if(insert.end < base.end){//seg1
                    seg2_end = insert.end;
                    seg3_end = base.end;
                    seg3_sum = base.sum;
                     seg3_start = seg2_end + 1;
                }else if(insert.end > base.end){
                    seg2_end = base.end;
                    seg3_end = insert.end;
                    seg3_sum = insert.sum;
                    seg3_start = seg2_end + 1;
                }else{
                    seg2_end = base.end;
                }
                 seg2_sum = base.sum + insert.sum;
                 record = seg2_sum > record ? seg2_sum : record;
                 
                 list.remove(index);
                 int pos = index;
                 if(seg1_start > 0){
                         Segment s1 = new Segment(seg1_start, seg1_end, seg1_sum);
                         list.add(pos++, s1);
                 }
                 Segment s2 = new Segment(seg2_start, seg2_end, seg2_sum);
                 list.add(pos++, s2);
                 if(seg3_start > 0){
                         Segment s3 = new Segment(seg3_start, seg3_end, seg3_sum);
                         list.add(pos++, s3);
                 }
                 index = pos;
                 slice = true;
            }
        }
        if(!slice) {
                list.add(insert);
                record =  record > insert.sum ? record : insert.sum;
        }    
}
    
    private static List<Segment> list ;
    private static int record = 0;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int number = Integer.parseInt(sc.nextLine());
            int i = 0;
            list =  new ArrayList<Segment>(number);
            while(i< number){
                String line = sc.nextLine().trim();
                String[] tmp = line.split(" ");
                int start = Integer.parseInt(tmp[0]);
                int end = Integer.parseInt(tmp[1]);
                int sum = Integer.parseInt(tmp[2]);
                addSegment(new Segment(start, end, sum) );
                ++i;
            }
            //Collections.sort(list);
            //System.out.println(list);
            System.out.println(record);
            record = 0;
            list.clear();
        }
        
    }
}
