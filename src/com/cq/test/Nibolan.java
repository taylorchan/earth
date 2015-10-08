/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @author:   Taylor Chan
 * @since:    2015-4-7
 * @version : 1.0
 */
public class Nibolan {
    
    public Nibolan() {
        super();
    }
    public static final String dig_pattern = "\\d+";
    public static final String op_pattern = "(\\*|/|-|\\+){1}";
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner stdin = new Scanner(System.in);  
        String s = "";
        while(stdin.hasNext()){
                s = stdin.nextLine().trim();
                String[] exps = s.split(" ");
                Stack<Integer> digStack = new Stack<Integer>();
                LinkedList<Character> opQueue = new LinkedList<Character>();
               Pattern pattern1 = Pattern.compile(dig_pattern);
               Pattern pattern2 = Pattern.compile(op_pattern);
               Matcher matcher = null;
                for(int i=0; i< exps.length; i++){
                    matcher = pattern1.matcher(exps[i]);
                    if(matcher.find()){
                        digStack.push(Integer.parseInt(exps[i]));
                    }
                    matcher = pattern2.matcher(exps[i]);
                    if(matcher.find()){
                        opQueue.add(exps[i].toCharArray()[0]);
                    } 
                }
                CalResult result = null;
                while(true){
                    int dig2 = digStack.pop();
                    int dig1 = digStack.pop();
                    char op = opQueue.poll();
                    
                    result = cal(dig1, dig2, op);
                    if(result.error) {
                        System.out.println("NaN");
                        break;
                    }
                    if(digStack.empty() || opQueue.isEmpty())  break;
                    digStack.push(result.result);
                }
                System.out.println(result.result);

        }
    }
    
     private static class CalResult{
         int result  = 0;
         boolean error = false;
         
     }
    
    private static CalResult cal(int dig1, int dig2, char op){
        CalResult result = new CalResult();
        int val = 0;
        switch(op){
            case '+':
                val = dig1 + dig2;
                break;
             case '*':
                val = dig1 * dig2;
                break;
             case '-':
                val = dig1 - dig2;
                break;
             case '/':
                if(dig2 == 0)
                    result.error = true;
                else
                    val = dig1 / dig2;
                break;
             default:
        }
        result.result = val;
        return result;
    }
}
