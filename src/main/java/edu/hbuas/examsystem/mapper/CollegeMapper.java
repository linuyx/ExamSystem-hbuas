package edu.hbuas.examsystem.mapper;

import edu.hbuas.examsystem.pojo.College;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeMapper {

    //根据名称查找college
    College findCollegeByName (String string);
}
