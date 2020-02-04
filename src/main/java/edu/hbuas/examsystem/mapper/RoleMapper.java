package edu.hbuas.examsystem.mapper;

import edu.hbuas.examsystem.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {

    //根据名称查询role
    Role findRoleByName(String string);
}
