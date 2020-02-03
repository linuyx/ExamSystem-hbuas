package edu.hbuas.examsystem.service;

import edu.hbuas.examsystem.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    //查询所有teacher
    List<Teacher> findAllTeachaer();

    //查询teacher根据number
    Teacher findTeacherByNmuber(String string);

    //批量删除teacher根据number
    void deleteTeacherByNumber(List<Teacher> lists);

    //保存teacher
    void saveTeacher(Teacher teacher);
}
