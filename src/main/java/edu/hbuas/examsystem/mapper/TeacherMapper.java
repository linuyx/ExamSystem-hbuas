package edu.hbuas.examsystem.mapper;


import edu.hbuas.examsystem.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    //查询所有teacher
    List<Teacher> findAllTeachaer();

     //查询teacher多条件
    Teacher findTeacherByMany(Teacher teacher);

    //批量删除teacher根据number
    void deleteTeacherByNumber(@Param("lists") List<Teacher> lists);

    //保存teacher
    void insertTeacher(Teacher teacher);

    //批量导入teacher
    void insertAllTeacher(@Param("lists") List<Teacher> lists);

    //修改teacher通过number
    void updateTeacher(Teacher teacher);

}
