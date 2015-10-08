//: io/BasicFileOutput.java

package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {
    
    static String filesrc = "f:/practice1.txt";
    
    static String filedes = "f:/practice2.java";
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read(filesrc)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filedes)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null)
            out.println(lineCount++ + ": " + s);
        in.close();
        out.close();
        // Show the stored file:
        System.out.println(BufferedInputFile.read(filedes));
    }
} /* (Execute to see output) */// :~
