package edu.hbuas.examsystem.service.impl;


import edu.hbuas.examsystem.mapper.CollegeMapper;
import edu.hbuas.examsystem.mapper.RoleMapper;
import edu.hbuas.examsystem.mapper.TeacherMapper;
import edu.hbuas.examsystem.pojo.College;
import edu.hbuas.examsystem.pojo.Role;
import edu.hbuas.examsystem.pojo.Teacher;
import edu.hbuas.examsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TeacherServiceImpl implements TeacherService {


    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    RedisTemplate<String,Object> redisTemplate;


    //查询所有teacher
    public List<Teacher> selectAll(){

        //查询缓存
        List<Teacher> list=(List<Teacher>)redisTemplate.opsForValue().get("allTeacher");

        if(null==list){
            //查询数据库
            list=teacherMapper.selectAll();
            //将查询到的数据存入缓存,并设置过期时间
            redisTemplate.opsForValue().set("allTeacher",list,600, TimeUnit.SECONDS);
        }

        return list;
    }

    //查询teacher多条件
    public Teacher findTeacherByMany(Teacher teacher){

        //查询缓存
        College college=(College) redisTemplate.opsForValue().get("tCollege:"+teacher.getCollege());
        Role    role=(Role) redisTemplate.opsForValue().get("Rname:"+teacher.getRname());

        //两个设置相同的过期时间，一个为null，另一个也为null，所以这里只判断最后设置的一个就可以了
        if(null==college){
            //查询数据库
            college=(College) collegeMapper.selectByName(teacher.getCollege());
            role=(Role)roleMapper.findRoleByName(teacher.getRname());
            //给teacher的Cid和Rid赋值
            teacher.setCid(college.getCid());
            teacher.setRid(role.getRid());
            //将查询到的数据存入缓存，并设置过期时间
            redisTemplate.opsForValue().set("Rname:"+teacher.getRname(),role,
                    600, TimeUnit.SECONDS);
            redisTemplate.opsForValue().set("tCollege:"+teacher.getCollege(),college,
                    600, TimeUnit.SECONDS);
        }else {
            //给teacher的Cid和Rid赋值
            teacher.setCid(college.getCid());
            teacher.setRid(role.getRid());
        }

//        teacher.setCid( (collegeMapper.selectByName(teacher.getCollege())).getCid() );
//        teacher.setRid( (roleMapper.findRoleByName(teacher.getRname())).getRid() );

        //查询缓存
        Teacher teacherRt=(Teacher) redisTemplate.opsForValue().get("cid:"+teacher.getCid()+"tname:"
                + teacher.getTname()+"rid:"+teacher.getRid());

        if(null==teacherRt){
            //查询数据库
            teacherRt=teacherMapper.findTeacherByMany(teacher);
            if(null!=teacherRt){
                //将查询到的数据存入缓存，并设置过期时间
                redisTemplate.opsForValue().set("cid:"+teacher.getCid()+"tname:"
                        + teacher.getTname()+"rid:"+teacher.getRid(),teacherRt,600,TimeUnit.SECONDS);
            }
        }

        //判断返回的数据是否为空，不为空flag赋值为true，为空flag赋值为flase
        if(null!=teacherRt){
            teacherRt.setFlag(true);
            return teacherRt;
        }else{
            //将teacher中falg赋值为false，并返回，如果flag为false，就不会调用里面的其他数据
            teacher.setFlag(false);
            return teacher;
        }

    }


    //批量删除teacher根据tid
    @Transactional
    public String deleteTeacherByTid(List<Teacher> lists){
        //查询数据库中的数据
        teacherMapper.deleteTeacherByTid(lists);

        //新建一个list，并将需要删除的缓存的key存进去
        List<String> list=new ArrayList<>();
        for (int i = 0; i < lists.size(); i++) {
            list.add("cid:"+lists.get(i).getCid()+"tname:"+lists.get(i).getTname()+"rid:"+lists.get(i).getRid());
        }
        //删除缓存中的数据
        redisTemplate.delete(list);

        //删除allTeacher的key
        redisTemplate.delete("allTeacher");

        return "删除成功";
    }

    //保存teacher
    @Transactional
    public String insertTeacher(Teacher teacher){

        teacher.setCid((collegeMapper.selectByName(teacher.getCollege())).getCid());
        teacher.setRid((roleMapper.findRoleByName(teacher.getRname())).getRid());

        if(null==teacherMapper.findTeacherByAll(teacher)){
            //将数据添加到数据库中
            teacherMapper.insertTeacher(teacher);

            //查询数据库，将新增的数据添加到缓存中,并设置过期时间
            redisTemplate.opsForValue().set("cid:"+teacher.getCid()+"tname:"
                    + teacher.getTname()+"rid:"+teacher.getRid(),teacherMapper.findTeacherByMany(teacher),
                    600,TimeUnit.SECONDS);

            //删除allTeacher的key
            redisTemplate.delete("allTeacher");
            return "保存成功";
        }else{
                return"此用户已存在或者教师工号重复";
        }

    }

    //批量导入teacher
    @Transactional
    public String insertAllTeacher(List<Teacher> lists){
        for(Teacher teacher:lists){
            teacher.setCid( (collegeMapper.selectByName(teacher.getCollege())).getCid() );
            teacher.setRid( (roleMapper.findRoleByName(teacher.getRname())).getRid() );
        }

        //将数据添加到数据库中
        teacherMapper.insertAllTeacher(lists);

        //将数据添加到缓存当中,并设置过期时间
        RedisConnection redisConnection=redisTemplate.getConnectionFactory().getConnection();
        redisConnection.openPipeline();
        for (Teacher list : lists) {
            redisTemplate.opsForValue().set("cid:"+list.getCid()+"tname:"
                    + list.getTname()+"rid:"+list.getRid(),list,600,TimeUnit.SECONDS);
        }
        //删除allTeacher的key
        redisTemplate.delete("allTeacher");
        redisConnection.closePipeline();

        return "导入成功";
    }

    //修改teacher通过tid
    @Transactional
    public String updateTeacherByTid(Teacher teacher){

        if(null!=teacherMapper.findTeacherByNumber(teacher)){
            return "修改失败：此教师工号已经存在";
        }

        teacher.setCid( (collegeMapper.selectByName(teacher.getCollege())).getCid() );
        teacher.setRid( (roleMapper.findRoleByName(teacher.getRname())).getRid() );

        //删除数据库中的内容
        teacherMapper.updateTeacherByTid(teacher);

        //删除缓存中的内容
        redisTemplate.delete("cid:"+teacher.getCid()+"tname:" + teacher.getTname()+"rid:"+teacher.getRid());

        //删除allTeacher的key
        redisTemplate.delete("allTeacher");
        return"修改成功";

    }
}
