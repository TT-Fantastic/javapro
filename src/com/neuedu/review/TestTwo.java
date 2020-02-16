package com.neuedu.review;

public class TestTwo {
    public static void main(String[] args) {
    /*HisThread hisThread=new HisThread();
    Thread thread=new Thread(hisThread);
    thread.start();*/
   /* MyInterface m1=new MyAdd();
    MyInterface m2=new MyDivision();
    MyInterface m3=new MyMultiplication();
    MyInterface m4=new MySubtracttion();
        System.out.println(method(45,34,m1));
        System.out.println(method(45,5,m2));
        System.out.println(method(4,14,m3));
        System.out.println(method(45,34,m4));*/
   /*MyInterface myInterface=new MyInterface() {
       @Override
       public int method(int a, int b) {
           return a+b;
       }
   };
        System.out.println(method(12, 23, new MyInterface() {
            @Override
            public int method(int a, int b) {
                return a*b;
            }
        }));
        System.out.println(method(23,43,(a,b)->{
            return a+b;
        }));
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<25;i++){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"线程输出"+i);
                }
            }
        });
        thread.start();*/
        //无复用性可用此方法写，仅能用一次
       Thread thread=new Thread(()->{
           for(int i=0;i<25;i++){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName()+"线程输出"+i);
           }
       });
       thread.start();
    }
    public static void eat(){};
    public static void drink(){};
    public static void speak(){};
    public static int method(int a ,int b,MyInterface myInterface){
        return myInterface.method(a,b);
    }
}
