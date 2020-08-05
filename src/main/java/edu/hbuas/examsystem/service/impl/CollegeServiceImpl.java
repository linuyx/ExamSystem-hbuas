package edu.hbuas.examsystem.service.impl;

import edu.hbuas.examsystem.filter.RedisBloomFilter;
import edu.hbuas.examsystem.mapper.CollegeMapper;
import edu.hbuas.examsystem.pojo.College;
import edu.hbuas.examsystem.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CollegeServiceImpl implements CollegeService {


    @Autowired
    private CollegeMapper collegeMapper;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    RedisBloomFilter redisBloomFilter;


    /**
     * 查询所有college
     * @return 所有college数据
     */
    public List<College> selectAll(){

        //查询缓存
        List<College> list=(List<College>)redisTemplate.opsForValue().get("allCollege");
        if(null==list){
            //查询数据库
            list=collegeMapper.selectAll();
            //将查询出来的数据存入缓存,并设置过期时间
            redisTemplate.opsForValue().set("allCollege",list,600, TimeUnit.SECONDS);
        }

       return list;
    }



    /**
     * 根据名称查找college
     * @param college college名称
     * @return  查询到的college数据
     */
    public College selectByName (String college){

        //查询缓存
        College collegeRt=(College)redisTemplate.opsForValue().get("college:"+college);

        if(null==collegeRt){
            //查询数据库
            collegeRt=collegeMapper.selectByName(college);
            if(null!=collegeRt) {
                //将查询出来的数据存入缓存，并设置过期时间
                redisTemplate.opsForValue().set("college:" + college, collegeRt, 600, TimeUnit.SECONDS);
            }
        }

        //若为空，给对象co的flag赋值为false并返回；不为空，则返回查询到的对象
        if(null==collegeRt) {
            College co = new College();
            co.setFlag(false);
            return co;
        }else{
            collegeRt.setFlag(true);
            return collegeRt;
        }
    }



    /**
     * 根据名称批量删除college
     * @param list 集合中存的是要删除的college的名称
     * @return 删除的结果
     */
    @Transactional
    public String deleteByName(List<String> list){

        //删除数据库中的数据
        collegeMapper.deleteByName(list);

        //清除list中原来的数据，将需要删除的缓存中的key放进去
        List<String> list1=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            list1.add(i,"college:"+list.get(i));
        }
        //删除缓存中的数据
        redisTemplate.delete(list1);

        //删除allCollege的key
        redisTemplate.delete("allCollege");

        return "删除成功";
    }



    /**
     * 新增college数据
     * @param college cellege对象，里面存有需要添加的属性
     * @return 新增的结果
     */
    @Transactional
    public String insertCollege(College college){
        //判断是否存在相同的学院编号和学院名称
        if(0==collegeMapper.selectCollege(college).size()){
            //往数据库中新增college数据
            collegeMapper.insertCollege(college);

            //查询数据库，将新增的数据添加到缓存中
            redisTemplate.opsForValue().set("college:"+college.getCollege(),collegeMapper.selectByName(college.getCollege()),
                    600, TimeUnit.SECONDS);

            //删除allCollege的key
            redisTemplate.delete("allCollege");
            return "保存成功";
        }else{
            return "此学院已存在或者学院编号重复";
        }
    }



    /**
     * 根据id修改college
     * @param college
     * @return 修改的结果
     */
    @Transactional
    public String updateById(College college){
        //判断是否存在相同的学院编号和学院名称且不是自己
        if(0==collegeMapper.selectCollegeNoSelf(college).size()){
            //往数据库中修改college数据
            collegeMapper.updateById(college);

            //删除缓存中原来的数据
            redisTemplate.delete("college:"+college.getCollegeOld());

            //删除allCollege的key
            redisTemplate.delete("allCollege");
            return "保存成功";
        }else {
            return "此学院已存在或者学院编号重复";
        }
    }
}
