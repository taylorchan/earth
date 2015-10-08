/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @author:   chenqiang3
 * @since:    2015-4-4
 * @version : 1.0
 */
public class PatternTest {

    /**
     * 
     */
    public PatternTest() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static void main(String args[]){
        Pattern pattern = Pattern.compile("^Java.*");
        String text = "Jacccccccccccccva学习资料";
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            System.out.println(matcher.group());
        }
        text = text.replaceAll("Ja.*a", "PHP");
        System.out.println(text);
        
    }
    
}
