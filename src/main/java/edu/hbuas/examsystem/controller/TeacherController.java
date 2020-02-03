package edu.hbuas.examsystem.controller;


import edu.hbuas.examsystem.pojo.Teacher;
import edu.hbuas.examsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //查询所有teacher
    @RequestMapping("/findAllTeachaer")
    public List<Teacher> findAllTeachaer(){
        return teacherService.findAllTeachaer();
    }


    //批量删除teacher根据number
    @RequestMapping("/deleteTeacherByNumber")
    public void deleteTeacherByNumber(List<Teacher> lists){
        teacherService.deleteTeacherByNumber(lists);
    }
}
