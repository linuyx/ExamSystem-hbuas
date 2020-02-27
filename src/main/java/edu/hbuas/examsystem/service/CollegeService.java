package edu.hbuas.examsystem.service;

import edu.hbuas.examsystem.pojo.College;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CollegeService {

    //查询所有college
    List<College> findAllColege();

    //根据名称查找college
    College findCollegeByName (String string);

    //批量删除college
    String deleteCollegeById(List<College> lists);

    //保存college
    String insertCollege(College college);

    //修改college
    String updateCollegeById(College college);
}
