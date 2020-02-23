package com.neuedu.review;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class theSecondIO {
    public static int a=0;
    public static List list=new ArrayList();
    public static void main(String[] args) {
        /*File file =new File("h:/sd.java");
        InputStream inputStream=null;
        byte[] b=new byte[10];
        try {
            inputStream= new FileInputStream(file);
            int a =inputStream.read(b);
            while (a!=-1){
                for (int i=0;i<b.length;i++){
                    System.out.println(b[i]);
                }

                a=inputStream.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (inputStream!=null)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        /*CountDownLatch countDownLatch =new CountDownLatch(5000);
        for (int i =0;i<5000;i++){
            countDownLatch.countDown();
        }
        try {
            countDownLatch.await();
            System.out.println("123456");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        Semaphore semaphore=new Semaphore(2);
        CountDownLatch countDownLatch=new CountDownLatch(5000);
        for (int i=0;i<5000;i++){
            Thread t=new Thread(()->{
                /*synchronized (object){

                }*/
                try {
                    //semaphore.acquire();
                    list.add(1);
                    countDownLatch.countDown();
                   // semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
            t.start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
   /* public synchronized void add(){
        while(true){
            System.out.println("add");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void delete(){
        while (true){
            System.out.println("delete");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

}
