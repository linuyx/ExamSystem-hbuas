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
    void insertAllRoom(@Param("lists") List<Room> lists);

    //批量删除room通过rrid
    void deleteManyRoomByRrid(@Param("lists") List<Room> lists);
}
