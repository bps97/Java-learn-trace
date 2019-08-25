package cn.bps.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {

    private int id;
    private int studentId;
    private String studentName;
    private int studentAge;
    private String studentSex;
    private Date birthday;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(String studentSex) {
        this.studentSex = studentSex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getFormatBirthday(){
        return new SimpleDateFormat("yyyy-MM-dd").format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
