package com.neuedu.studentbottom;

import com.neuedu.imformation.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Studentbottom implements IsStudentbottom {
    String url="jdbc:mysql://localhost:3306/qwe?useUnicode=true&characterEncoding=utf8";
    String username="root";
    String password="123456";
    @Override
    public List<Student> query() {
        List<Student> list =new ArrayList<>();
        Connection con=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
            pstmt=con.prepareStatement("select Sno,Sname,Ssex,Sage,Sdept from student");
            rs=pstmt.executeQuery();

            while(rs.next()){
                Student student=new Student();
                student.setSno(rs.getInt("Sno"));
                student.setSname(rs.getString("Sname"));
                student.setSsex(rs.getString("Ssex"));
                student.setSage(rs.getInt("Sage"));
                student.setSdept(rs.getString("Sdept"));
                list.add(student);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs!=null)
                    rs.close();
                if(pstmt!=null)
                    pstmt.close();
                if (con!=null)
                    con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public int add(Student student) {
        return 0;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public int del(int Sno) {
        return 0;
    }

    @Override
    public Student queryOne(int Sno) {
        return null;
    }
}

