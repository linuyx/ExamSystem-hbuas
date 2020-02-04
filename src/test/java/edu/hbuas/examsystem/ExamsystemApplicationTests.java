package edu.hbuas.examsystem;

import edu.hbuas.examsystem.controller.RoomController;
import edu.hbuas.examsystem.controller.TeacherController;
import edu.hbuas.examsystem.pojo.Room;
import edu.hbuas.examsystem.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

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


    //测试保存用户
    @Test
    public void testInsertTeacher(){
        Teacher teacher=new Teacher();

        teacher.setNumber("twww");
        teacher.setTname("test");
        teacher.setSex("男");
        teacher.setWages("123456789");
        teacher.setPhone("123456789");
        teacher.setCollege("马克思主义学院");
        teacher.setRname("教师");
        teacher.setTimes(0);

        teacherController.insertTeacher(teacher);
    }

    //测试删除用户
    @Test
    public void testDeleteTeacherByNumber(){
        Teacher teacher1=new Teacher();
        Teacher teacher2=new Teacher();
        Teacher teacher3=new Teacher();


        teacher1.setNumber("txxx2");
        teacher2.setNumber("");
        teacher3.setNumber("");

        List<Teacher> lists=new ArrayList<>();

        lists.add(teacher1);
        lists.add(teacher2);
        lists.add(teacher3);

        teacherController.deleteTeacherByNumber(lists);
    }


    //测试teacher多条件查询
    @Test
    public void testFindTeacherByMany (){
        Teacher teacher=new Teacher();

        teacher.setCollege("食品科学技术学院·化学工程学院");
        teacher.setRname("教师");
        teacher.setTname("周睿");

        System.out.println(teacherController.findTeacherByMany(teacher));
    }


    //修改teacher通过number
    @Test
    public void updateTeacher(){

        Teacher teacher=new Teacher();
        teacher.setNumber("txxxx");
        teacher.setTname("test222");
        teacher.setSex("男");
        teacher.setWages("456789");
        teacher.setPhone("11111111111");
        teacher.setCollege("教务处");
        teacher.setRname("教师");
        teacher.setTimes(0);

        teacherController.updateTeacher(teacher);
    }

    //批量导入teacher
    @Test
    public void insertAllTeacher(){
        List<Teacher> lists=new ArrayList<>();

        Teacher teacher1=new Teacher();
        Teacher teacher2=new Teacher();

        teacher1.setNumber("txxx1");
        teacher1.setTname("test222");
        teacher1.setSex("男");
        teacher1.setWages("456789");
        teacher1.setPhone("11111111111");
        teacher1.setCollege("教务处");
        teacher1.setRname("教师");
        teacher1.setTimes(0);


        teacher2.setNumber("txxx2");
        teacher2.setTname("test222");
        teacher2.setSex("男");
        teacher2.setWages("456789");
        teacher2.setPhone("11111111111");
        teacher2.setCollege("马克思主义学院");
        teacher2.setRname("教师");
        teacher2.setTimes(0);

        lists.add(teacher1);
        lists.add(teacher2);
        teacherController.insertAllTeacher(lists);
    }

}
