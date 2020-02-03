package edu.hbuas.examsystem.controller;

import edu.hbuas.examsystem.pojo.Room;
import edu.hbuas.examsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {


    @Autowired
    private RoomService roomService;

    //查询所有room
    @RequestMapping("/findAllRoom")
    @ResponseBody
    public List<Room> findAllRoom(){
        return roomService.findAllRoom();
    }

    //导入所有考场信息
    @RequestMapping("/insertAllRoom")
    public void insertAllRoom(List<Room> lists){
        roomService.insertAllRoom(lists);
    }

    //批量删除room通过rrid
    @RequestMapping("/deleteManyRoomByNumber")
    public void deleteManyRoomByRrid(List<Room> lists){
        roomService.deleteManyRoomByRrid(lists);
    }
}
