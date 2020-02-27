package edu.hbuas.examsystem.controller;

import edu.hbuas.examsystem.pojo.College;
import edu.hbuas.examsystem.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/college")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;



    //查询所有college
    @GetMapping("/findAllColege")
    public List<College> findAllColege(){
        return collegeService.findAllColege();
    }


    //根据名称查找college
    @GetMapping("/findCollegeByName")
    public College findCollegeByName (String string){
        return collegeService.findCollegeByName(string);
    }


    //批量删除college
    @DeleteMapping("/deleteCollegeByCid")
    public String deleteCollegeById(List<College> lists){
        return  collegeService.deleteCollegeById(lists);
    }


    //保存college
    @PostMapping("/insertCollege")
    public String insertCollege(College college){
        return collegeService.insertCollege(college);
    }


    //修改college
    @PutMapping("/updateCollege")
    public String updateCollegeById(College college){
        return collegeService.updateCollegeById(college);
    }

}
