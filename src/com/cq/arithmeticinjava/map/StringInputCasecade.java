/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.arithmeticinjava.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


/**
 * 
 * @author: qiang.chen
 * @since:    2012-7-24
 * @version : 1.0
 * @E-mail： qiang.chen@xinyi-tech.com
 */
public class StringInputCasecade {
    /**
     * 打印出所有关联的字符（单词）
     *
     * @param adjWords
     * @param minWords
     */
    public static void printHeighChangeables(Map<String,List<String>> adjWords,int minWords){
        Set<String> keySet  = adjWords.keySet();
        List<String> stringList = null;
        for (String key : keySet) {
            stringList = adjWords.get(key);
            if(stringList.size() >= minWords){
                System.out.print(key+" (");
                System.out.print(stringList+"):");
                for (String w : stringList) {
                    System.out.print(" "+w);
                }
                System.out.println();
                
            }
        }
        
    }
    /**
     * return true the two words are the same length and
     * differ in only one position
     *
     * @param word1
     * @param word2
     * @return
     */
    public static boolean oneCharOff(String word1,String word2){
        if(word1.length() != word2.length())
            return false;
        int diffs = 0;
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)){
                if(++diffs > 1)
                    return false;
            }
        }
        return diffs == 1;
    }
    /**
     * 
     *
     * @param theWords
     * @return
     */
    public static Map<String,List<String>> computeAdjacentWords(List<String> theWords){
        Map<String,List<String>> adjWords = new TreeMap<String,List<String>>();
        String[] words = new String[theWords.size()];
        theWords.toArray(words);
        for(int i = 0;i<words.length;i++){
            for (int j = i+1; j < words.length; j++) {
                if(oneCharOff(words[i], words[j])){
                    update(adjWords,words[i],words[j]);
                    update(adjWords,words[j],words[i]);
                }
            }
        }
        return adjWords;
    }
    
    private static <K> void update(Map<K,List<String>> m,K key,String value){
        List<String> list = m.get(key);
        if(list == null){
            list = new ArrayList<String>();
            m.put(key, list);
        }
        list.add(value);
    }
}
