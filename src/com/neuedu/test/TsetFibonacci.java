package com.neuedu.test;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TsetFibonacci {
    public static void main(String[] args) {
        System.out.println(sum(1000));
        //System.out.println(method(5));
        /*int[] content=new int[50];
        content[0]=1;
        content[1]=1;
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for (int i=2;i<=n;i++){
            content[i]=content[i-1]+content[i-2];
        }
        System.out.println(content[n]);*/

        /*double height=100;
        for(int i=1;i<=9;i++)//计算第一次落地到第十次落地
        {
            height=height/2;
        }
        System.out.println("第十次落地时的高度是："+height);*/

       /* Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        for (int i=0;i<n;i++){
            int a =(int)Math.sqrt(i+100);
            int b=(int)Math.sqrt(i+168+100);
            if (a*a==i+100&&b*b==i+100+168) {
                System.out.println("这个数是"+i);
            }

        }*/

       /*         Scanner s = new Scanner(System.in);
                System.out.print("请输入排成一圈的人数：");
                int n = s.nextInt();
                boolean[] arr = new boolean[n];

                for (int i = 0; i < arr.length; i++) {
                    arr[i] = true;
                } // 数组赋值都是true

                int leftCount = n;
                int countNum = 0;
                int index = 0;
                while (leftCount > 1) {
                    if (arr[index] == true) {
                        countNum++;
                        if (countNum == 3) {
                            countNum = 0;
                            arr[index] = false;
                            leftCount--;
                        }
                    }
                    index++;
                    if (index == n) {
                        index = 0;
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (arr[i] == true) {
                        System.out.println("原排在第" + (i + 1) + "位的人留下了。");
                    }
                }
            }*/

    }
    /*public static  int method(int n){
        if (n==1||n==2){
            return 1;
        }else {
            int a=1;
            int b=1;
            int c=0;
            for (int i=3;i<=n;i++){
                c=a+b;
                a=b;
                b=c;

            }
            return c;
        }
    }*/
    public static int sum(int n){
        List<Integer> list=new ArrayList<>();
        for (int i=1;i<=n;i++){
            list.add(i);
        }
        int m=1;
        while (list.size()>1){
            if (m!=3){
               int first= list.remove(0);
                list.add(first);
                m++;
            }else {
                list.remove(0);
                m=1;
            }
        }
        return list.get(0);
    }
}



