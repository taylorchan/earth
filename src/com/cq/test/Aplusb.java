/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.test;

import java.io.IOException;
import java.util.Scanner;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-4-7
 * @version : 1.0
 */
public class Aplusb {
    
    public Aplusb() {
        super();
    }
    
    public static void main(String args[]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner stdin = new Scanner(System.in);  
        String s = "";
        int value = 0;
        while(stdin.hasNext()){
                s = stdin.nextLine();
                String[]  params = s.split(" ");
                value = 0;
                if(params.length == 1)
                    value = Integer.parseInt(params[1]);
                else if(params.length > 1){
                    int v1 = Integer.parseInt(params[0]);
                    int v2 = Integer.parseInt(params[1]);
                    value = v1 + v2;
                } 
                System.out.println(value);
                s = stdin.nextLine();
        }
    }
}
