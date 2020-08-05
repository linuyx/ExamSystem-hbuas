package edu.hbuas.examsystem.controller;


import edu.hbuas.examsystem.pojo.Teacher;
import edu.hbuas.examsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;



    //查询所有teacher
    @GetMapping("/selectAll")
    @ResponseBody
    public List<Teacher> selectAll(){
        return teacherService.selectAll();
    }



    //查询teacher多条件
    @GetMapping("/findTeacherByMany")
    @ResponseBody
    public Teacher findTeacherByMany(Teacher teacher){
        return teacherService.findTeacherByMany(teacher);
    }



    //批量删除teacher根据tid
    @DeleteMapping("/deleteTeacherByTid")
    @ResponseBody
    public String deleteTeacherByNumber(@RequestBody List<Teacher> lists){
        return  teacherService.deleteTeacherByTid(lists);
    }



    //保存teacher
    @PostMapping("/insertTeacher")
    @ResponseBody
    public String insertTeacher(@RequestBody Teacher teacher){
       return teacherService.insertTeacher(teacher);
    }



    //批量导入teacher
    @PostMapping("/insertAllTeacher")
    @ResponseBody
    public String insertAllTeacher(@RequestBody List<Teacher> lists){
        return teacherService.insertAllTeacher(lists);
    }



    //修改teacher通过tid
    @PutMapping("/updateTeacherByTid")
    @ResponseBody
    public String updateTeacher(@RequestBody Teacher teacher){
        return teacherService.updateTeacherByTid(teacher);
    }

}
