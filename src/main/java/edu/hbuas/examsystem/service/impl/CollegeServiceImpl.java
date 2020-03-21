package edu.hbuas.examsystem.service.impl;

import edu.hbuas.examsystem.mapper.CollegeMapper;
import edu.hbuas.examsystem.pojo.College;
import edu.hbuas.examsystem.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        //得到查询的对象
        College coRt=collegeMapper.findCollegeByName(string);
        //若为空，新建对象，flag赋值为false并返回；不为空，则返回查询到的对象
        if(null==coRt) {
            College co = new College();
            co.setFlag(false);
            return co;
        }else{
            coRt.setFlag(true);
            return coRt;
        }
    }

    //批量删除college
    @Transactional
    public String deleteCollegeById(List<College> lists){
        collegeMapper.deleteCollegeById(lists);
        return "删除成功";
    }

    //保存college
    @Transactional
    public String insertCollege(College college){
        //判断是否存在相同的学院编号和学院名称
        if(0==collegeMapper.findCollege(college).size()){
            collegeMapper.insertCollege(college);
            return "保存成功";
        }else{
            return "此学院已存在或者学院编号重复";
        }
    }

    //修改college
    @Transactional
    public String updateCollegeById(College college){
        //判断是否存在相同的学院编号和学院名称且不是自己
        if(0==collegeMapper.findCollegeNoSelf(college).size()){
            collegeMapper.updateCollegeById(college);
            return "保存成功";
        }else {
            return "此学院已存在或者学院编号重复";
        }
    }
}
