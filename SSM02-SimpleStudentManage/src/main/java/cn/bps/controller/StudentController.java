package cn.bps.controller;


import cn.bps.entity.Student;
import cn.bps.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public String listStudentInfo(Model model, @RequestParam(value = "pg" , defaultValue = "1") int pg){

        if(pg==1){
            pg =1;
        }

        List<Student> students = studentService.listStudentInfo(10*(pg-1),10);



        model.addAttribute("count",studentService.countStudent());
        model.addAttribute("students",students);

        return "index";
    }

    @RequestMapping("edit")
    public String editStudentInfo(Model model, @RequestParam(value = "id",defaultValue = "1") int id){
        Student one = studentService.getOne(id);

        model.addAttribute("student",one);

        return "edit";
    }


    @RequestMapping("/update")
    public String updateStudent(HttpServletRequest request, HttpServletResponse response, @RequestParam(value = "id") int id) {

        Student student = new Student();

        int studentId = Integer.parseInt(request.getParameter("sid"));
        String name = request.getParameter("sname");
        int age = Integer.parseInt(request.getParameter("sage"));
        String sex = request.getParameter("ssex");

        sex = (sex.equals("0"))? "女" : "男";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            e.printStackTrace();
        }



        student.setId(id);
        student.setStudentId(studentId);
        student.setStudentName(name);
        student.setStudentAge(age);
        student.setStudentSex(sex);
        student.setBirthday(birthday);

        System.out.println(student.getStudentName()+"..."+student.getStudentId()+student.getStudentAge());

        studentService.updateStudentInfo(student);

        return "redirect:list?pg=1";
    }


    @RequestMapping("/del")
    public String delStudentRecord(Model model, @RequestParam(value = "id") int id){
        studentService.delStudentRecord(id);
        return "redirect:list?pg=1";
    }

}
