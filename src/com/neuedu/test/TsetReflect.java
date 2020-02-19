package com.neuedu.test;

import com.neuedu.imformation.Dept;
import com.neuedu.imformation.Student;
import com.neuedu.util.JdbcUtil;

import java.lang.reflect.Field;
import java.util.List;

public class TsetReflect {
    public static void main(String[] args) {

//        try {
//            Class clz= Student.class;
//            Student student=new Student();
//            Class clz1=student.getClass();
//            Class clz2= Class.forName("com.neuedu.imformation.Student");
//            System.out.println(clz==clz2);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        Class clz=Student.class;
        //类下 每一个属性都会被封装为Mthod方法

        //Field[] field=clz.getFields();//只能获取公有属性
       /* Field[] field=clz.getDeclaredFields();//忽略访问修饰符，有多少属性获取多少
        for (Field f:field){
            System.out.println(f);
        }*/
        List<Dept> list= JdbcUtil.executeQuery("select deptno,dname,loc from dept", Dept.class);
        System.out.println(list);
    }
}
