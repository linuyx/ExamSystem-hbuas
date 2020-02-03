package edu.hbuas.examsystem.service.impl;


import edu.hbuas.examsystem.mapper.TeacherMapper;
import edu.hbuas.examsystem.pojo.Teacher;
import edu.hbuas.examsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private TeacherMapper teacherMapper;

    //查询所有teacher
    public List<Teacher> findAllTeachaer(){
        return teacherMapper.findAllTeachaer();
    }

    //查询teacher根据number
    public Teacher findTeacherByNmuber(String string){
        return teacherMapper.findTeacherByNmuber(string);
    }

    //批量删除teacher根据number
    @Transactional
    public void deleteTeacherByNumber(List<Teacher> lists){
        teacherMapper.deleteTeacherByNumber(lists);
    }

    //保存teacher
    @Transactional
    public void saveTeacher(Teacher teacher){
        //Teacher teacher1=teacherMapper.findTeacherByNmuber(teacher.getNumber());

    }
}
