package com.neuedu.studentservice;

import com.neuedu.imformation.Column;
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
        return studentbottom.add(student);
    }

    @Override
    public int update(Student student) {
        return studentbottom.update(student);
    }

    @Override
    public int del(int Sno) {
        return studentbottom.del(Sno);
    }

    @Override
    public Student queryOne(int Sno) {
        return null;
    }
}
