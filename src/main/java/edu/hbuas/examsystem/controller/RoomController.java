package edu.hbuas.examsystem.controller;

import edu.hbuas.examsystem.pojo.Room;
import edu.hbuas.examsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {


    @Autowired
    private RoomService roomService;

    //查询所有room
    @GetMapping("/findAllRoom")
    @ResponseBody
    public List<Room> findAllRoom(){
        return roomService.findAllRoom();
    }

    //保存room
    @PostMapping("/insertRoom")
    @ResponseBody
    public String insertRoom(Room room){
        return roomService.insertRoom(room);
    }

    //导入所有考场信息
    @PostMapping("/insertAllRoom")
    @ResponseBody
    public String insertAllRoom(List<Room> lists){
       return roomService.insertAllRoom(lists);
    }

    //批量删除room通过rrid
    @DeleteMapping("/deleteRoomByRrid")
    @ResponseBody
    public String deleteManyRoomByRrid(List<Room> lists){
        return roomService.deleteManyRoomByRrid(lists);
    }

    //修改room通过rrid
    @PutMapping("/updateRoomByRrid")
    @ResponseBody
    public String updateRoomByRrid(Room room){
        return roomService.updateRoomByRrid(room);
    }

}
