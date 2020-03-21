package edu.hbuas.examsystem.mapper;

import edu.hbuas.examsystem.pojo.College;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeMapper {


    //查询所有college
    List<College> findAllColege();

    //根据名称查找college
    College findCollegeByName (String string);

    //查找college用于判断是否存在
    List<College> findCollege(College college);

    //查找college用于判断是否存在且不是自己
    List<College> findCollegeNoSelf(College college);

    //批量删除college
    void deleteCollegeById(@Param("lists") List<College> lists);

    //保存college
    void insertCollege(College college);

    //修改college
    void updateCollegeById(College college);
}
