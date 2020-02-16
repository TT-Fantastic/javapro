package com.neuedu.review;

public class HerThread extends Thread{
    private Integer count=30;

    @Override
    public void run() {
        while (count>0){
            System.out.println(Thread.currentThread().getName()+"卖了"+count+"票");
            count--;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
