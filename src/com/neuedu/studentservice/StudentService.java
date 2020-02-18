package com.neuedu.studentservice;

import com.neuedu.imformation.Student;
import com.neuedu.studentbottom.IsStudentbottom;
import com.neuedu.studentbottom.Studentbottom;

import java.util.List;

public class StudentService implements IsStudentService {
    IsStudentbottom studentbottom =new Studentbottom();
    @Override
    public List<Student> query() {
        return studentbottom.query();
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
