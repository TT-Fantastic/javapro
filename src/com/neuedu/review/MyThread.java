package com.neuedu.review;

public class MyThread extends Thread {
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"线程速出------"+i);
        }
    }
}
