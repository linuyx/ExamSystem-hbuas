package edu.hbuas.examsystem.mapper;

import edu.hbuas.examsystem.pojo.Room;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomMapper {

    //查询所有room
    List<Room> findAllRoom();

    //查询room全条件
    Room findRoomByAll(Room room);

    //查询roomrrid不等于自己
    Room findRoomNoRrid(Room room);

    //保存room
    void insertRoom(Room room);

    //导入所有考场信息
    void insertAllRoom(@Param("lists") List<Room> lists);

    //批量删除room通过rrid
    void deleteManyRoomByRrid(@Param("lists") List<Room> lists);

    //修改room通过rrid
    void updateRoomByRrid(Room room);
}
