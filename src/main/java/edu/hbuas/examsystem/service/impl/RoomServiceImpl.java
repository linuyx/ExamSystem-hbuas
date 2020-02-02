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

    //导入所有考场信息
    @Transactional
    public void insertAllRoom(List<Room> list){
        roomMapper.insertAllRoom(list);
    }
}
