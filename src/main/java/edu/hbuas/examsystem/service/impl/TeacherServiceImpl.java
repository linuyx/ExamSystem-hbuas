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
        if(null!=teacherMapper.findTeacherByMany(teacher)){
            teacherRt.setFlag(true);
            return teacherRt;
        }else{
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
            return "添加成功";
        }else{
                return"此用户已存在";
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

        if(teacherMapper.findTeacherByNumber(teacher)!=null){
            return "修改失败：此教师工号已经存在";
        }

        teacher.setCid( (collegeMapper.findCollegeByName(teacher.getCollege())).getCid() );
        teacher.setRid( (roleMapper.findRoleByName(teacher.getRname())).getRid() );

        teacherMapper.updateTeacherByTid(teacher);
        return"修改成功";

    }
}
