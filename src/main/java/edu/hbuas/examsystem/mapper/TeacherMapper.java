package edu.hbuas.examsystem.mapper;


import edu.hbuas.examsystem.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    //查询所有teacher
    List<Teacher> selectAll();

     //查询teacher多条件
    Teacher findTeacherByMany(Teacher teacher);

    //查询teacher全条件
    Teacher findTeacherByAll(Teacher teacher);

    //查询单个teacher根据number
    Teacher findTeacherByNumber(Teacher teacher);

    //批量删除teacher根据tid
    void deleteTeacherByTid(@Param("lists") List<Teacher> lists);

    //保存teacher
    void insertTeacher(Teacher teacher);

    //批量导入teacher
    void insertAllTeacher(@Param("lists") List<Teacher> lists);

    //修改teacher通过tid
    void updateTeacherByTid(Teacher teacher);

}
