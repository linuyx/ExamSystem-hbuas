package edu.hbuas.examsystem.mapper;


import edu.hbuas.examsystem.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherMapper {

    //查询所有teacher
    List<Teacher> findAllTeachaer();

    //查询teacher根据number
    Teacher findTeacherByNmuber(String string);

    //批量删除teacher根据number
    void deleteTeacherByNumber(@Param("lists") List<Teacher> lists);

    //保存teacher
    void saveTeacher(Teacher teacher);

}
