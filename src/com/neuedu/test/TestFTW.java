package com.neuedu.test;

import java.io.*;


public class TestFTW {
    public static void main(String[] args) {
       MyLibrary myLibrary=new MyLibrary("你懂得",286.0,"你懂得","你懂得","你懂得");
       OutputStream outputStream=null;
       ObjectOutputStream objectOutputStream=null;
       File file=new File("h:/");
        try {
            outputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(outputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  catch (IOException e) {
            e.printStackTrace();
        }


    }
}
