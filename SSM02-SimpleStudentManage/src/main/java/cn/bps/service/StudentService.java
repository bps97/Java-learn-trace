package cn.bps.service;

import cn.bps.dao.StudentDAO;
import cn.bps.entity.Student;

import java.util.ArrayList;

public interface StudentService {
    ArrayList<Student> listStudentInfo(int start, int end);

    int countStudent();

    Student getOne(int id);

    void updateStudentInfo(Student student);

    void delStudentRecord(int id);
}
