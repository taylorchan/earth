/******************************************************************************
 * 
 *Taylor Chan's works,just for practice!
 * 
 *****************************************************************************/
package com.cq.thinkinjava.io.reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


/**
 * 
 * @author:   qiang.chen
 * @since:    2012-12-14
 * @version : 1.0
 */
public class BufferedInputFile {
    
    
    private String fileName;
    
    
    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }
    
    public String readFileLine(){
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String s = null;
            
            while((s = br.readLine()) != null){
                sb.append(s).append("\n");
            }
            br.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return sb.toString();
    }
    
    /**
     * use inputSteamReader with utf-8 charset
     *
     * @return
     */
    public String readFileLine2(){
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        try {
            is = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String s = null;
            
            while((s = br.readLine()) != null){
                sb.append(s).append("\n");
            }
            br.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return sb.toString();
    }


    
    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public BufferedInputFile(String _filename){
        this.fileName = _filename;
    }
    
    public static void main(String[] args) {
        String filename = "d:/Daily_log.txt";
        BufferedInputFile bi = new BufferedInputFile(filename);
        String s = bi.readFileLine2();
    }
    
}
