package edu.hbuas.examsystem.service.impl;

import edu.hbuas.examsystem.mapper.RoomMapper;
import edu.hbuas.examsystem.pojo.Room;
import edu.hbuas.examsystem.service.RoomService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;

    //查询所有room
    public List<Room> findAllRoom(){
        return roomMapper.findAllRoom();
    }

    //保存room
    public String insertRoom(Room room){
        if(null==roomMapper.findRoomByAll(room)){
            roomMapper.insertRoom(room);
            return "保存成功";
        }else {
            return "此教室已存在";
        }

    }

    //导入所有考场信息
    @Transactional
    public String insertAllRoom(List<Room> lists){
        roomMapper.insertAllRoom(lists);
        return "导入成功";
    }

    //批量删除room通过rrid
    @Transactional
    public String deleteManyRoomByRrid(List<Room> lists){
        roomMapper.deleteManyRoomByRrid(lists);
        return  "删除成功";
    }

    //修改room通过rrid
    public String updateRoomByRrid(Room room){
        if(null==roomMapper.findRoomNoRrid(room)){
            roomMapper.updateRoomByRrid(room);
            return "修改成功";
        }else{
            return "此教室已存在";
        }
    }
}
