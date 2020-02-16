package com.neuedu.review;

public class TestThree {
    public static void main(String[] args) {
        Thread m1=new HerThread();
        Thread m2=new HerThread();
        m1.start();
        m2.start();
    }
   ;

}
