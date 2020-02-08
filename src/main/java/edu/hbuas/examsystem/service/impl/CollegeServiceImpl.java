package edu.hbuas.examsystem.service.impl;

import edu.hbuas.examsystem.mapper.CollegeMapper;
import edu.hbuas.examsystem.pojo.College;
import edu.hbuas.examsystem.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeServiceImpl implements CollegeService {


    @Autowired
    private CollegeMapper collegeMapper;

    //查询所有college
    public List<College> findAllColege(){
       return collegeMapper.findAllColege();
    }

    //根据名称查找college
    public College findCollegeByName (String string){
       return collegeMapper.findCollegeByName(string);
    }

    //批量删除college
    public String deleteCollege(List<College> lists){
        collegeMapper.deleteCollege(lists);
        return "删除成功";
    }

    //保存college
    public String insertCollege(College college){
        if(0==collegeMapper.findCollege(college).size()){
            collegeMapper.insertCollege(college);
            return "保存成功";
        }else{
            return "此学院已存在";
        }
    }

    //修改college
    public String updateCollege(College college){
        if(0==collegeMapper.findCollege(college).size()){
            collegeMapper.updateCollege(college);
            return "保存成功";
        }else {
            return "此学员已存在";
        }
    }
}
