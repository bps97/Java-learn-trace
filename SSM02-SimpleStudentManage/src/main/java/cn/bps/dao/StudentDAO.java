package cn.bps.dao;

import cn.bps.entity.Student;

import java.util.ArrayList;

public interface StudentDAO {
    ArrayList<Student> listStudentInfo(int start, int end);

    int countStudent();

    Student getOne(int id);

    void updateStudentInfo(Student student);

    void delStudentRecord(int id);
}
