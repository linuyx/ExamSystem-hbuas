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
    @GetMapping("/selectAll")
    @ResponseBody
    public List<College> selectAll(){
        return collegeService.selectAll();
    }



    //根据名称查找college
    @GetMapping("/selectByName")
    @ResponseBody
    public College selectByName (String college){
        return collegeService.selectByName(college);
    }



    //批量删除college
    @DeleteMapping("/deleteByName")
    @ResponseBody
    public String deleteByName(@RequestBody List<String> list){
        return  collegeService.deleteByName(list);
    }



    //保存college
    @PostMapping("/insertCollege")
    @ResponseBody
    public String insertCollege(@RequestBody College college){
        return collegeService.insertCollege(college);
    }



    //修改college
    @PutMapping("/updateById")
    @ResponseBody
    public String updateById(@RequestBody College college){
        return collegeService.updateById(college);
    }

}
