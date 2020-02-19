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
           add(scanner);
        } else if (i == 3) {
           update(scanner);
        } else if (i == 4) {
           del(scanner);
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
        private  void add(Scanner scanner){
            System.out.println("请输入添加姓名");
            String Sname=scanner.next();
            System.out.println("请输入性别");
            String Ssex=scanner.next();
            System.out.println("请输入年龄");
            Integer Sage=scanner.nextInt();
            System.out.println("请输入所在系");
            String Sdept=scanner.next();
            Student student=new Student(Sname,Ssex,Sage,Sdept);
            // 调用服务层 添加该数据
            studentService.add(student);
            //显示列表
            query();
        }
        private  void update(Scanner scanner){
            System.out.println("请输入要修改的学号");
            Integer Sno=scanner.nextInt();
            System.out.println("请输入要修改姓名");
            String Sname=scanner.next();
            System.out.println("请输入要修改性别");
            String Ssex=scanner.next();
            System.out.println("请输入要修改年龄");
            Integer Sage=scanner.nextInt();
            System.out.println("请输入要修改所在系");
            String Sdept=scanner.next();
            Student student=new Student(Sno,Sname,Ssex,Sage,Sdept);
            // 调用服务层 添加该数据
            studentService.update(student);
            //显示列表
            query();
        }
        private void del(Scanner scanner){
            System.out.println("请输入要删除的学号");
            Integer Sno=scanner.nextInt();
            studentService.del(Sno);
            query();
        }

    }