package com.neuedu.studentservice;

import com.neuedu.imformation.Student;

import java.util.List;

public interface IsStudentService {
    List<Student> query();
    int add(Student student);
    int update(Student student);
    int del(int Sno);
    Student queryOne(int Sno);
}
