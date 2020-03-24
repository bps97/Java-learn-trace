package cn.bps.service;

import cn.bps.dao.StudentDAO;
import cn.bps.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public ArrayList<Student> listStudentInfo(int start, int end) {
        return studentDAO.listStudentInfo(start, end);
    }

    @Override
    public int countStudent() {
        return studentDAO.countStudent();
    }

    @Override
    public Student getOne(int id) {
        return studentDAO.getOne(id);
    }

    @Override
    public void updateStudentInfo(Student student) {
        studentDAO.updateStudentInfo(student);
        return;
    }

    @Override
    public void delStudentRecord(int id) {
        studentDAO.delStudentRecord(id);
        return;
    }


}
