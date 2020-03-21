package edu.hbuas.examsystem.service.impl;


import edu.hbuas.examsystem.mapper.CollegeMapper;
import edu.hbuas.examsystem.mapper.RoleMapper;
import edu.hbuas.examsystem.mapper.TeacherMapper;
import edu.hbuas.examsystem.pojo.Role;
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

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private RoleMapper roleMapper;



    //查询所有teacher
    public List<Teacher> findAllTeacher(){
        return teacherMapper.findAllTeacher();
    }

    //查询teacher多条件
    public Teacher findTeacherByMany(Teacher teacher){
        teacher.setCid( (collegeMapper.findCollegeByName(teacher.getCollege())).getCid() );
        teacher.setRid( (roleMapper.findRoleByName(teacher.getRname())).getRid() );

        Teacher teacherRt=teacherMapper.findTeacherByMany(teacher);
        //判断返回的数据是否为空，不为空flag赋值为true，为空flag赋值为flase
        if(null!=teacherMapper.findTeacherByMany(teacher)){
            teacherRt.setFlag(true);
            return teacherRt;
        }else{
            //将teacher中falg赋值为false，并返回，如果flag为false，就不会调用里面的其他数据
            teacher.setFlag(false);
            return teacher;
        }

    }


    //批量删除teacher根据tid
    @Transactional
    public String deleteTeacherByTid(List<Teacher> lists){
        teacherMapper.deleteTeacherByTid(lists);
        return "删除成功";
    }

    //保存teacher
    @Transactional
    public String insertTeacher(Teacher teacher){

        teacher.setCid((collegeMapper.findCollegeByName(teacher.getCollege())).getCid());
        teacher.setRid((roleMapper.findRoleByName(teacher.getRname())).getRid());

        if(null==teacherMapper.findTeacherByAll(teacher)){
            teacherMapper.insertTeacher(teacher);
            return "保存成功";
        }else{
                return"此用户已存在或者教师工号重复";
        }

    }

    //批量导入teacher
    @Transactional
    public String insertAllTeacher(List<Teacher> lists){
        for(Teacher teacher:lists){
            teacher.setCid( (collegeMapper.findCollegeByName(teacher.getCollege())).getCid() );
            teacher.setRid( (roleMapper.findRoleByName(teacher.getRname())).getRid() );
        }

        teacherMapper.insertAllTeacher(lists);
        return "导入成功";
    }

    //修改teacher通过tid
    @Transactional
    public String updateTeacherByTid(Teacher teacher){

        if(null!=teacherMapper.findTeacherByNumber(teacher)){
            return "修改失败：此教师工号已经存在";
        }

        teacher.setCid( (collegeMapper.findCollegeByName(teacher.getCollege())).getCid() );
        teacher.setRid( (roleMapper.findRoleByName(teacher.getRname())).getRid() );

        teacherMapper.updateTeacherByTid(teacher);
        return"修改成功";

    }
}
