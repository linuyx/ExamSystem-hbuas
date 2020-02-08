package edu.hbuas.examsystem.service;

import edu.hbuas.examsystem.pojo.Teacher;

import java.util.List;

public interface TeacherService {

    //查询所有teacher
    List<Teacher> findAllTeacher();

    //查询teacher多条件
    Teacher findTeacherByMany(Teacher teacher);

    //批量删除teacher根据tid
    String deleteTeacherByTid(List<Teacher> lists);

    //保存teacher
    String insertTeacher(Teacher teacher);

    //批量导入teacher
    String insertAllTeacher(List<Teacher> lists);

    //修改teacher通过tid
    String updateTeacherByTid(Teacher teacher);
}
