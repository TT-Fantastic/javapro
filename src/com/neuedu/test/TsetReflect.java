package com.neuedu.test;

import com.neuedu.imformation.Dept;
import com.neuedu.imformation.Student;
import com.neuedu.util.JdbcUtil;
import com.neuedu.util.RowMap;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TsetReflect {
    public static void main(String[] args) {
        ExecutorService service= Executors.newCachedThreadPool();
        service.execute(()->{
            hoodie();
        });
        service.execute(()->{
            cargo();
        });
    }
    public static void hoodie() {

//        try {
//            Class clz= Student.class;
//            Student student=new Student();
//            Class clz1=student.getClass();
//            Class clz2= Class.forName("com.neuedu.imformation.Student");
//            System.out.println(clz==clz2);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
         /* Class clz=Student.class;
        //类下 每一个属性都会被封装为Mthod方法

        //Field[] field=clz.getFields();//只能获取公有属性
      Field[] field=clz.getDeclaredFields();//忽略访问修饰符，有多少属性获取多少
        for (Field f:field){
            System.out.println(f);
        }
        List<Dept> list= JdbcUtil.executeQuery("select deptno,dname,loc from dept", (rs)-> {

                Dept dept=new Dept();
                try {
                    dept.setDeptno(rs.getInt("deptno"));
                    dept.setDname(rs.getString("dname"));
                    dept.setLocal(rs.getString("loc"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return dept;

        });
        System.out.println(list);*/
        Connection con=JdbcUtil.getConnection();
        PreparedStatement pstmt=null;
        //PreparedStatement pstmt1=null;
        try {
            con.setAutoCommit(false);//每次执行完增删改，不能自动提交
            Thread.sleep(1000);
            pstmt=con.prepareStatement("update dept set dname=?,loc=? where deptno=?");
            pstmt.setString(1,"人事部");
            pstmt.setString(2,"杭州");
            pstmt.setInt(3,20);
            /*pstmt1=con.prepareStatement("insert into  dept(deptno,dname,loc) values (?,?,?)");
            pstmt1.setInt(1,60);
            pstmt1.setString(2,"技术部");
            pstmt1.setString(3,"上海"); */
            int i=pstmt.executeUpdate();
            System.out.println(i);
            int k=100/0;
            //int j=pstmt1.executeUpdate();
           // System.out.println(j);
            con.commit();//由于con.setAutoCommit(false);所以我们必须要手动提交，否则只是在内存中存储。
        } catch (SQLException e) {
            try {
                con.rollback();//回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
               // if (pstmt1!=null)
                //    pstmt1.close();
                if (pstmt!=null)
                    pstmt.close();
                if (con!=null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void cargo(){
        Connection con=JdbcUtil.getConnection();
        PreparedStatement pstmt=null;
        PreparedStatement pstmt1=null;
        ResultSet rs=null;
        try {
            con.setAutoCommit(false);//每次执行完增删改，不能自动提交
            con.setTransactionIsolation(2);//隔离级别为1允许脏读,读一个未提交的；级别为2读已提交
            pstmt=con.prepareStatement("select  deptno,dname,loc from dept");
            rs=pstmt.executeQuery();
            while (rs.next()){
                Dept dept=new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLocal(rs.getString("loc"));
                System.out.println(dept);
            }
            Thread.sleep(2000);
            pstmt1=con.prepareStatement("select  deptno,dname,loc from dept");
            rs=pstmt1.executeQuery();
            while (rs.next()){
                Dept dept=new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLocal(rs.getString("loc"));
                System.out.println(dept);
            }
            //int j=pstmt1.executeUpdate();
            // System.out.println(j);
            con.commit();//由于con.setAutoCommit(false);所以我们必须要手动提交，否则只是在内存中存储。
        } catch (SQLException e) {
            try {
                con.rollback();//回滚
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {

                if (rs!=null)
                    rs.close();
                if (pstmt1!=null)
                    pstmt1.close();
                if (pstmt!=null)
                    pstmt.close();
                if (con!=null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
