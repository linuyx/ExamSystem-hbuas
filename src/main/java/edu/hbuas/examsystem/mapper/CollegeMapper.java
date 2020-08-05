package edu.hbuas.examsystem.mapper;

import edu.hbuas.examsystem.pojo.College;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeMapper {

    //查询所有college
    List<College> selectAll();

    //根据名称查找college
    College selectByName (String college);

    //查找college用于判断是否存在
    List<College> selectCollege(College college);

    //查找college用于判断是否存在且不是自己
    List<College> selectCollegeNoSelf(College college);

    //批量删除college
    void deleteByName(@Param("lists") List<String> list);

    //保存college
    void insertCollege(College college);

    //修改college
    void updateById(College college);

}
