/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.test;

import java.security.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 
 * @author:   chenqiang3
 * @since:    2015-4-4
 * @version : 1.0
 */
public class DateTest {
    public static void main(String args[]){
        Date time = new Date(System.currentTimeMillis());
        System.out.println(time);
        SimpleDateFormat df =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //SimpleDateFormat df =  new SimpleDateFormat();
        String date="2015-4-4";
        System.out.println(df.format(time));
        Date d2 = null;
        try {
            d2 = df.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(d2);

    }
    
}
