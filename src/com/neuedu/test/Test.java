package com.neuedu.test;

public class Test {
    public static void main(String[] args) {
        String s = "稻孙必死";
        char[] charArray = s.toCharArray();
        System.out.println(charArray.length);
        for(int i = 0;i < charArray.length;i++){
            System.out.println((int)charArray[i]);
            System.out.println(Integer.toBinaryString(charArray[i]));
        }
    }
}
