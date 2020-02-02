package edu.hbuas.examsystem;

import edu.hbuas.examsystem.controller.RoomController;
import edu.hbuas.examsystem.pojo.Room;
import edu.hbuas.examsystem.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ExamsystemApplicationTests {

    @Autowired
    private RoomController roomController;

    @Test
    void contextLoads() {
    }

    @Test
    //测试查询所有room
    void testFindAllRoom(){
       List<Room> lists= roomController.findAllRoom();
       for(Room room :lists)
        System.out.println(room);
    }

    @Test
    //测试导入所有考场信息
    void testInsertAllRoom(){
        List<Room> list =new ArrayList<>();
        Room room1=new Room();
        Room room2=new Room();

        room1.setTid(1024);
        room1.setRid(1024);
        room1.setPlace("test1");
        room1.setNumber("test1");
        room1.setCampus(1024);
        room1.setStorid(1024);

        room2.setTid(1024);
        room2.setRid(1024);
        room2.setPlace("test2");
        room2.setNumber("test2");
        room2.setCampus(1024);
        room2.setStorid(1024);

        list.add(room1);
        list.add(room2);

        roomController.insertAllRoom(list);
    }
}
