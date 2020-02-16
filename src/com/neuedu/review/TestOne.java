package com.neuedu.review;

import java.util.*;

public class TestOne {
    public static void main(String[] args)  {
        //HashSet顺序没有任何规则
        //TreeSet根据内容自己排序
        //LinkedHashSet根据键入顺序排序
        /*Set set=new LinkedHashSet();
        set.add(10);
        set.add(20);
        set.add(90);
        set.add(25);
        set.add(100);
        for (Object obj :set){
            System.out.println(obj);
        }*/
        //比较之前需要拆包操作 变量.类型Value
        /*Integer a=473;
        Integer b=473;
        System.out.println(a.intValue()==b.intValue());*/
       /* Map<String,String> map=new HashMap<>();
        map.put("001","王二麻子");
        map.put("002","李四");
        map.put("002","稻上飞");
        Set<String> keys= map.keySet();
        for (String key:keys){
            System.out.println(map.get(key));
        }*/
       try{
           String str=method();
           System.out.println(str);
       }catch (Exception ex){

       }


    }
    /*public static String method(){

        try{
            System.exit(0);
            return "dhsjahdkj";
        }catch(Exception ex){
            return "asfa";
        }finally {
            System.out.println("无论如何都要执行");
        }*/
    public static String method() throws Exception{
        int a=100/0;
        return "sda";
    }

}
