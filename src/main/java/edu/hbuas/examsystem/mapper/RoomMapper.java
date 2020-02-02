package edu.hbuas.examsystem.mapper;

import edu.hbuas.examsystem.pojo.Room;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomMapper {

    //查询所有room
    List<Room> findAllRoom();

    //导入所有考场信息
    void insertAllRoom(@Param("list") List<Room> list);
}
