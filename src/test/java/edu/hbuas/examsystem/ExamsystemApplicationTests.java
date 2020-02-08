package edu.hbuas.examsystem;

import edu.hbuas.examsystem.controller.RoomController;
import edu.hbuas.examsystem.controller.TeacherController;
import edu.hbuas.examsystem.pojo.Room;
import edu.hbuas.examsystem.pojo.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.SocketTimeoutException;
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

        System.out.println(roomController.insertAllRoom(lists));
    }


    //测试保存room
    @Test
    public void testInsertRoom(){
        Room room=new Room();

        room.setTid(38);
        room.setRid(1024);
        room.setPlace("N8-C207");
        room.setNumber("C207");
        room.setCampus(0);
        room.setStorid(8);

        System.out.println(roomController.insertRoom(room));
    }


    //测试批量删除room通过rrid
    @Test
    public void testDeleteManyRoomByRrid(){
        List<Room> lists=new ArrayList<>();

        Room room1=new Room();
        Room room2=new Room();

        room1.setRrid(1339);
        room2.setRrid(1340);

        lists.add(room1);
        lists.add(room2);

        System.out.println(roomController.deleteManyRoomByRrid(lists));

    }


    //测试修改room通过rrid
    @Test
    public void testUpdateRoomByRrid(){
        Room room =new Room();

        room.setRrid(1363);
        room.setTid(38);
        room.setRid(1024);
        room.setPlace("N8");
        room.setNumber("C207");
        room.setCampus(0);
        room.setStorid(8);

        System.out.println(roomController.updateRoomByRrid(room));
    }



    //查询所有teacher
    @Test
    public void testFindAllTeachaer(){
        List<Teacher> lists=teacherController.findAllTeacher();
        for(Teacher teacher:lists){
            System.out.println(teacher);
        }
    }


    //测试保存用户
    @Test
    public void testInsertTeacher(){
        Teacher teacher=new Teacher();

        teacher.setNumber("tuoo26");
        teacher.setTname("test2");
        teacher.setSex("男2");
        teacher.setWages("1234567890");
        teacher.setPhone("123456789");
        teacher.setCollege("马克思主义学院");
        teacher.setRname("教师");
        teacher.setTimes(0);

        System.out.println(teacherController.insertTeacher(teacher));
    }

    //测试删除用户
    @Test
    public void testDeleteTeacherByNumber(){
        Teacher teacher1=new Teacher();
        Teacher teacher2=new Teacher();


        teacher1.setTid(13076);
        teacher2.setTid(13077);


        List<Teacher> lists=new ArrayList<>();

        lists.add(teacher1);
        lists.add(teacher2);

        System.out.println(teacherController.deleteTeacherByNumber(lists));
    }


    //测试teacher多条件查询
    @Test
    public void testFindTeacherByMany (){
        Teacher teacher=new Teacher();

        teacher.setCollege("食品科学技术学院·化学工程学院");
        teacher.setRname("教师");
        teacher.setTname("周");

        System.out.println(teacherController.findTeacherByMany(teacher));
    }


    //修改teacher通过tid
    @Test
    public void updateTeacher(){

        Teacher teacher=new Teacher();
        teacher.setTid(13098);
        teacher.setNumber("txxx10");
        teacher.setTname("test2264");
        teacher.setSex("男");
        teacher.setWages("4567897s");
        teacher.setPhone("11111111111");
        teacher.setCollege("教务处");
        teacher.setRname("教师");
        teacher.setTimes(0);

        System.out.println( teacherController.updateTeacher(teacher));;
    }

    //批量导入teacher
    @Test
    public void insertAllTeacher(){
        List<Teacher> lists=new ArrayList<>();

        Teacher teacher1=new Teacher();
        Teacher teacher2=new Teacher();

        teacher1.setNumber("txxx8");
        teacher1.setTname("test222");
        teacher1.setSex("男");
        teacher1.setWages("456789");
        teacher1.setPhone("11111111111");
        teacher1.setCollege("教务处");
        teacher1.setRname("教师");
        teacher1.setTimes(0);


        teacher2.setNumber("txxx9");
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
