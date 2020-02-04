package edu.hbuas.examsystem.controller;


import edu.hbuas.examsystem.pojo.Teacher;
import edu.hbuas.examsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

    //查询teacher多条件
    @RequestMapping("/findTeacherByMany")
    public Teacher findTeacherByMany(Teacher teacher){
        return teacherService.findTeacherByMany(teacher);
    }

    //批量删除teacher根据number
    @RequestMapping("/deleteTeacherByNumber")
    public void deleteTeacherByNumber(List<Teacher> lists){
        teacherService.deleteTeacherByNumber(lists);
    }


    //保存teacher
    @RequestMapping("/saveTeacher")
    public void insertTeacher(Teacher teacher){
        teacherService.insertTeacher(teacher);
    }

    //批量导入teacher
    @RequestMapping("/insertAllTeacher")
    public void insertAllTeacher(List<Teacher> lists){
        teacherService.insertAllTeacher(lists);
    }

    //修改teacher通过number
    @RequestMapping("/updateTeacher")
    public void updateTeacher(Teacher teacher){
        teacherService.updateTeacher(teacher);
    }

}
