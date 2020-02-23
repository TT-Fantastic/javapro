package com.neuedu.test;

public class TsetMp {
    public static void main(String[] args) {
        MP(array);
    }
    static int[] array = {21, 25, 28, 456, 145, 221};
    public static void MP(int[] a){

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j <a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            System.out.println(a[i]);
        }

    }
}

