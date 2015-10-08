/**2012-4-23**/

package com.cq.countline;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈强
 * @since 1.0
 * @version 2012-4-23 陈强新建
 */
public class ReadFile {
    
    private static List<FileInfo> ls = new ArrayList<FileInfo>();
    
    public static void main(String args[]) {
        String filePath = "E:/movie2";
        File objFile = new File(filePath);
        creatFileIOStream(objFile);
        for (FileInfo file : ls) {
            System.out.println(file);
        }
    }
    
    private static void creatFileIOStream(File file) {
        if (file.isDirectory()) {
            File files[] = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    creatFileIOStream(files[i]);
                } else if (files[i].isFile()) {
                    FileInfo objFileInfo = getFileDetail(files[i]);
                    ls.add(objFileInfo);
                }
            }
        }
    }
    
    private static FileInfo getFileDetail(File file) {
        FileInputStream fis = null;
        BufferedReader bf = null;
        FileInfo fileInfo = new FileInfo();
        fileInfo.setFilePath(file.getAbsolutePath());
        fileInfo.setFileName(file.getName());
        long numCount = 0L;
        long charCount = 0L;
        long blankCount = 0L;
        long lineCount = 0L;
        try {
            fis = new FileInputStream(file);
            bf = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e1) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e1.printStackTrace();
        }
        char ch;
        try {
            while (fis.read() != -1) {
                ch = (char) fis.read();
                if (ch >= '0' && ch <= '9') {
                    ++numCount;
                } else if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                    ++charCount;
                } else if (ch == ' ') {
                    ++blankCount;
                }
            }
            while (bf.readLine() != null) {
                ++lineCount;
            }
        } catch (IOException e) {
            // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
            e.printStackTrace();
        } finally {
            
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
                    e.printStackTrace();
                }
            }
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException e) {
                    // TODO 自动生成异常捕获块存根注释，块实现时请删除此注释
                    e.printStackTrace();
                }
            }
        }
        fileInfo.setNum(numCount);
        fileInfo.setCharacterNum(charCount);
        fileInfo.setBlankNum(blankCount);
        fileInfo.setLineNum(lineCount);
        return fileInfo;
    }
}
