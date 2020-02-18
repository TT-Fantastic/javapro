package com.neuedu.web;

import com.neuedu.imformation.Student;
import com.neuedu.studentservice.IsStudentService;
import com.neuedu.studentservice.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentWeb {
    IsStudentService studentService=new StudentService();
    public void showmain(){
        System.out.println("------------------");
        System.out.println("1--------------查询");
        System.out.println("2--------------添加");
        System.out.println("3--------------修改");
        System.out.println("4--------------删除");
        System.out.println("其他------------退出");
        System.out.println("------------------");
    }
    public void input() {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i == 1) {
            query();
        } else if (i == 2) {
            System.out.println("添加");
        } else if (i == 3) {
            System.out.println("修改");
        } else if (i == 4) {
            System.out.println("删除");
        } else {
            System.exit(0);
        }
    }
       public void query(){
            // 在此要调用 服务层提供的方法来去访问数据库
            List<Student> list = studentService.query();
            for (Student student : list) {
                System.out.println(student);
            }
        }

    }