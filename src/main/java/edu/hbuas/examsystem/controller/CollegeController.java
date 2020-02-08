package edu.hbuas.examsystem.controller;

import edu.hbuas.examsystem.pojo.College;
import edu.hbuas.examsystem.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;



    //查询所有college
    @RequestMapping("/findAllColege")
    public List<College> findAllColege(){
        return collegeService.findAllColege();
    }


    //根据名称查找college
    @RequestMapping("/findCollegeByName")
    public College findCollegeByName (String string){
        return collegeService.findCollegeByName(string);
    }



    //批量删除college
    @RequestMapping("/deleteCollege")
    public String deleteCollege(List<College> lists){
        return  collegeService.deleteCollege(lists);
    }


    //保存college
    @RequestMapping("/insertCollege")
    public String insertCollege(College college){
        return collegeService.insertCollege(college);
    }


    //修改college
    @RequestMapping("/updateCollege")
    public String updateCollege(College college){
        return collegeService.updateCollege(college);
    }
}
