package edu.hbuas.examsystem.service;

import edu.hbuas.examsystem.pojo.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomService {

    //查询所有room
    List<Room> findAllRoom();

    //导入所有考场信息
    void insertAllRoom(List<Room> list);
}
