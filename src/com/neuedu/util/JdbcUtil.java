package com.neuedu.util;

import com.neuedu.imformation.Column;
import com.neuedu.imformation.Student;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    private static final String URL="jdbc:mysql://localhost:3306/qwe?useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME="root";
    private static final String PASSWORD="123456";
    //加载驱动
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     public static Connection getConnection(){
        Connection con=null;
        try {
            con= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    //封装通用的增删改
    public static int executeUpdate(String sql,Object... parmas){
        int result=0;
        Connection con=getConnection();
        PreparedStatement pstmt=null;
        try {
            pstmt=con.prepareStatement(sql);
            if (parmas!=null){
                for (int i=0;i<parmas.length;i++){
                    pstmt.setObject(i+1,parmas[i]);
                }
            }
            result=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con,pstmt);
        }
        return result;
    }
    //封装通用查询方法
    public static <T> List<T> executeQuery(String sql, Class<T> clz,Object... parmas){
        List<T> list=new ArrayList<>();
        Connection con=getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            pstmt=con.prepareStatement(sql);
            if (parmas!=null){
                for (int i =0;i<parmas.length;i++){
                    pstmt.setObject(i+1,parmas[i]);
                }
            }
            rs=pstmt.executeQuery();
            while (rs.next()){
                //创建一个T类型的对象
                //该方法是通过反射 Class对象来调用无参构造创建对象
                T t=clz.newInstance();
                Field[] fields=clz.getDeclaredFields();
                for (Field f:fields) {
                    // 属性名 刚好和 数据库字段名一样了
                    // 我们就可以把属性名 当做数据库里的字段名 用 rs.getObject(属性名)
                    try {
                        // f.getName() 可能和 数据库中的字段名不同
                        // 那么我们就先看 该属性有没有 Column注解  如果有 我们用注解的值当做字段名
                        // 如果没有注解 我们再把 f.getName() 当做字段名
                        // 此刻就要先判断 该属性下 有没有 Column注解
                        String column=f.getName();
                        if (f.isAnnotationPresent(Column.class)){
                            // 如果有 我们就要获取到注解的值 来替换 column的值
                            // 获取注解
                            Column c = f.getAnnotation(Column.class);
                            // 用注解的value 替换 column
                            column = c.value();
                        }

                        Object value = rs.getObject(column);
                        // 拿出值之后 我们就可以为 属性赋值了
                        // 为属性赋值 属性对象是 Field 但是我们必须指明 我们要为哪个对象的属性赋值
                        /*
                         我们用 field 调用set方法 可以进行赋值
                            第一个参数 传一个对象  表示为哪个对象的该属性赋值

                            第二个参数 传值 表示 赋什么样的值

                            注意 如果该属性是 private 那么在赋值之前必须先打开权限
                         */
                        f.setAccessible(true);
                        f.set(t, value);
                    }catch (Exception ex){}
                }
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }finally {
            close(con,pstmt,rs);
        }

        return list;
    }
    //封装的第二种方法
    public  static <T> List<T> executeQuery(String sql,RowMap<T> rowMap,Object... parmas){
        List<T> list=new ArrayList<>();
        Connection con =getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            pstmt=con.prepareStatement(sql);
            if (parmas!=null){
               for (int i=0;i<parmas.length;i++){
                   pstmt.setObject(i+1,parmas[i]);
               }
            }
            rs=pstmt.executeQuery();
            while (rs.next()){
              T t = rowMap.rowMapping(rs);
              list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con,pstmt,rs);
        }
        return list;
    }
    //封装关闭方法
    static void close(Connection con,PreparedStatement pstmt){
        try {
            if (pstmt!=null)
                pstmt.close();
            if (con!=null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void close(Connection con, PreparedStatement pstmt, ResultSet rs){
        try {
            if (rs!=null)
                rs.close();
            close(con,pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
