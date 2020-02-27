package edu.hbuas.examsystem.service.impl;


import edu.hbuas.examsystem.mapper.SurfaceMapper;
import edu.hbuas.examsystem.pojo.Surface;
import edu.hbuas.examsystem.service.SurfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurfaceServiceImpl implements SurfaceService {


    @Autowired
    private SurfaceMapper surfaceMapper;


    //查询所有surface
    public List<Surface> findAllSurface(){
        return surfaceMapper.findAllSurface();
    }
}
