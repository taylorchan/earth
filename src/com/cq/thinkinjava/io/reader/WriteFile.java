/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.io.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-12-14
 * @version : 1.0
 */
public class WriteFile {
    
    
    public static void writeFile(String inPath,String outPath){
        String temp = new BufferedInputFile(inPath).readFileLine2();
        BufferedReader br = new BufferedReader(new StringReader(temp));
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new BufferedWriter(new FileWriter(outPath)));
            int lineCount  = 1;
            String s = null;
            while((s = br.readLine()) !=null)
                pw.println(lineCount++ + ":" +s);
            pw.close();
            System.out.println(new BufferedInputFile(outPath).readFileLine());
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
       
    }
    public static void main(String[] args) {
        String filename = "d:/Daily_log.txt";
        
        String outFile = "d:/Daily_log_out.txt";
        
        writeFile(filename, outFile);
    }
}
