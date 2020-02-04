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
    public List<Teacher> findAllTeachaer(){
        return teacherMapper.findAllTeachaer();
    }

    //查询teacher根据number
    public Teacher findTeacherByMany(Teacher teacher){
        teacher.setCid( (collegeMapper.findCollegeByName(teacher.getCollege())).getCid() );
        teacher.setRid( (roleMapper.findRoleByName(teacher.getRname())).getRid() );

        return teacherMapper.findTeacherByMany(teacher);
    }

    //批量删除teacher根据number
    @Transactional
    public void deleteTeacherByNumber(List<Teacher> lists){
        teacherMapper.deleteTeacherByNumber(lists);
    }

    //保存teacher
    @Transactional
    public void insertTeacher(Teacher teacher){
        teacher.setCid( (collegeMapper.findCollegeByName(teacher.getCollege())).getCid() );
        teacher.setRid( (roleMapper.findRoleByName(teacher.getRname())).getRid() );
        teacherMapper.insertTeacher(teacher);
    }

    //批量导入teacher
    @Transactional
    public void insertAllTeacher(List<Teacher> lists){
        for(Teacher teacher:lists){
            teacher.setCid( (collegeMapper.findCollegeByName(teacher.getCollege())).getCid() );
            teacher.setRid( (roleMapper.findRoleByName(teacher.getRname())).getRid() );
        }

        teacherMapper.insertAllTeacher(lists);
    }

    //修改teacher通过number
    @Transactional
    public void updateTeacher(Teacher teacher){
        teacher.setCid( (collegeMapper.findCollegeByName(teacher.getCollege())).getCid() );
        teacher.setRid( (roleMapper.findRoleByName(teacher.getRname())).getRid() );

        teacherMapper.updateTeacher(teacher);
    }
}
