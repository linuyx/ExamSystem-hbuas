package edu.hbuas.examsystem;

import edu.hbuas.examsystem.controller.RoomController;
import edu.hbuas.examsystem.controller.TeacherController;
import edu.hbuas.examsystem.pojo.Room;
import edu.hbuas.examsystem.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ExamsystemApplicationTests {

    @Autowired
    private RoomController roomController;

    @Autowired
    private TeacherController teacherController;


    @Test
    //测试查询所有room
    public void testFindAllRoom(){
       List<Room> lists= roomController.findAllRoom();
       for(Room room :lists)
        System.out.println(room);
    }

    @Test
    //测试导入所有考场信息
    public void testInsertAllRoom(){
        List<Room> lists =new ArrayList<>();
        Room room1=new Room();
        Room room2=new Room();
        Room room3=new Room();

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

        room3.setTid(1024);
        room3.setRid(1024);
        room3.setPlace("test3");
        room3.setNumber("test3");
        room3.setCampus(1024);
        room3.setStorid(1024);

        lists.add(room1);
        lists.add(room2);
        lists.add(room3);

        roomController.insertAllRoom(lists);
    }


    //测试批量删除room通过rrid
    @Test
    public void deleteManyRoomByRrid(){
        List<Room> lists=new ArrayList<>();

        Room room1=new Room();
        Room room2=new Room();
        Room room3=new Room();

        room1.setRrid(1336);
        room2.setRrid(1337);
        room3.setRrid(1338);

        lists.add(room1);
        lists.add(room2);
        lists.add(room3);

        roomController.deleteManyRoomByRrid(lists);

    }


    //查询所有teacher
    @Test
    public void testFindAllTeachaer(){
        List<Teacher> lists=teacherController.findAllTeachaer();
        for(Teacher teacher:lists){
            System.out.println(teacher);
        }


    }
}
