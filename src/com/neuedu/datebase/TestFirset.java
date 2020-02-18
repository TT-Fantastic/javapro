package com.neuedu.datebase;

import java.sql.*;

public class TestFirset {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/qwe?useUnicode=true&characterEncoding=utf8";
        String username="root";
        String password="123456";
        Connection con=null;
        PreparedStatement pre=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=  DriverManager.getConnection(url,username,password);
            pre=  con.prepareStatement("insert into student(Sname) values('稻上飞')");
            int i=pre.executeUpdate();
            System.out.println(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(pre!=null)
                     pre.close();
                if(con!=null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
