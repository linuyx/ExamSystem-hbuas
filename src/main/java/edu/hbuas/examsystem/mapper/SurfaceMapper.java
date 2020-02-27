package edu.hbuas.examsystem.mapper;


import edu.hbuas.examsystem.pojo.Surface;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurfaceMapper {

    //查询所有surface
    List<Surface> findAllSurface();
}
