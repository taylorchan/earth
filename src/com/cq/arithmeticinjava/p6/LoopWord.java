package com.cq.arithmeticinjava.p6;


/**
 * 回文测试
 * @author: qiang.chen
 * @since:    2012-7-9
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class LoopWord {
    
    
    public static boolean loopWord(String word){
        char[] chars = word.toCharArray();
        return checkLoop(chars,0);
    }
    private static boolean  checkLoop(char[] chars,int i){
        int length  = chars.length;
        if(i<length && chars[i] == chars[length-1-i] ){
            if(i == (length+1)/2){
                return true;
            }
            return checkLoop(chars,i+1);
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(loopWord("f"));
    }
}
