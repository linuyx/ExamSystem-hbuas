package edu.hbuas.examsystem.service;

import edu.hbuas.examsystem.pojo.College;

import java.util.List;

public interface CollegeService {

    //查询所有college
    List<College> selectAll();

    //根据名称查找college
    College selectByName (String college);

    //批量删除college
    String deleteByName(List<String> list);

    //保存college
    String insertCollege(College college);

    //修改college
    String updateById(College college);
}
