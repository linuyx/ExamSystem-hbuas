package edu.hbuas.examsystem.controller;


import edu.hbuas.examsystem.pojo.Surface;
import edu.hbuas.examsystem.service.SurfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/surface")
public class SurfaceController {


    @Autowired
    private SurfaceService surfaceService;

    //查询所有surface
    @RequestMapping("/findAllSurface")
    @ResponseBody
    public List<Surface> findAllSurface(){
        return surfaceService.findAllSurface();
    }
}
