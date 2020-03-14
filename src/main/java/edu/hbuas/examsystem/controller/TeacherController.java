package edu.hbuas.examsystem.controller;


import edu.hbuas.examsystem.pojo.Teacher;
import edu.hbuas.examsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    //查询所有teacher
    @GetMapping("/findAllTeacher")
    public List<Teacher> findAllTeacher(){
        return teacherService.findAllTeacher();
    }

    //查询teacher多条件
    @GetMapping("/findTeacherByMany")
    public Teacher findTeacherByMany(Teacher teacher){
        return teacherService.findTeacherByMany(teacher);
    }

    //批量删除teacher根据tid
    @DeleteMapping("/deleteTeacherByTid")
    public String deleteTeacherByNumber(List<Teacher> lists){
        return  teacherService.deleteTeacherByTid(lists);
    }


    //保存teacher
    @PostMapping("/saveTeacher")
    public String insertTeacher(Teacher teacher){
       return teacherService.insertTeacher(teacher);
    }

    //批量导入teacher
    @PostMapping("/insertAllTeacher")
    public String insertAllTeacher(List<Teacher> lists){
        return teacherService.insertAllTeacher(lists);
    }

    //修改teacher通过tid
    @PutMapping("/updateTeacherByTid")
    public String updateTeacher(Teacher teacher){
        return teacherService.updateTeacherByTid(teacher);
    }

}
