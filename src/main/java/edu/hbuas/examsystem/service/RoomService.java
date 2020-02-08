package edu.hbuas.examsystem.service;

import edu.hbuas.examsystem.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomService {

    //查询所有room
    List<Room> findAllRoom();

    //保存room
    String insertRoom(Room room);

    //导入所有考场信息
    String insertAllRoom(List<Room> lists);

    //批量删除room通过rrid
    String deleteManyRoomByRrid(List<Room> lists);

    //修改room通过rrid
    String updateRoomByRrid(Room room);
}
