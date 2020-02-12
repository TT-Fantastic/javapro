package com.neuedu.test;

import java.io.*;


public class TestFTW {
    public static void main(String[] args) {
       MyLibrary myLibrary=new MyLibrary("毛泽东选集",176.0,"人民出版社","毛泽东","八亿神州尽舜尧");
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
