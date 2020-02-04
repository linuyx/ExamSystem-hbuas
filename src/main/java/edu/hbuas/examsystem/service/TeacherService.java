package edu.hbuas.examsystem.service;

import edu.hbuas.examsystem.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    //查询所有teacher
    List<Teacher> findAllTeachaer();

    //查询teacher根据查询teacher多条件
    Teacher findTeacherByMany(Teacher teacher);

    //批量删除teacher根据number
    void deleteTeacherByNumber(List<Teacher> lists);

    //保存teacher
    void insertTeacher(Teacher teacher);

    //批量导入teacher
    void insertAllTeacher(List<Teacher> lists);

    //修改teacher通过number
    void updateTeacher(Teacher teacher);
}
