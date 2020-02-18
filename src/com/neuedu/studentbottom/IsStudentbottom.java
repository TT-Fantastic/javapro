package com.neuedu.studentbottom;

import com.neuedu.imformation.Student;

import java.util.List;

public interface IsStudentbottom {
    List<Student> query();
    int add(Student student);
    int update(Student student);
    int del(int Sno);
    Student queryOne(int Sno);
}
