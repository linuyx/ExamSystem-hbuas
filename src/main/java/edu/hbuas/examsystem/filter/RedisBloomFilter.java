package edu.hbuas.examsystem.filter;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import edu.hbuas.examsystem.mapper.CollegeMapper;
import edu.hbuas.examsystem.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author linuyx
 * @create 2020-07-17 14:14
 */
@Component
public class RedisBloomFilter {

    @Autowired
    CollegeMapper collegeMapper;

    @Autowired
    TeacherMapper teacherMapper;

    /**
     * 预存的数据个数
     */
    private static int size=50000;

    /**
     * 创建布隆过滤器的对象，并设置容错率
     */
    private static BloomFilter<String> bloomFilter=BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), size,0.01);



    /**
     * RedisBloomFilter对象被创建后,立即初始化的方法
     */
    @PostConstruct
    public void init(){

        //将查询所有college的key存入布隆过滤器
//        bloomFilter.put("allCollege");

        //查询数据库中的college表得到所有对象，并将key存入布隆过滤器
//        List<College> list=collegeMapper.selectAll();
//        for (College college : list) {
//            bloomFilter.put("college:"+college.getCollege());
//        }

        //查询数据库中的teacher表得到所有对象，并将key存入布隆过滤器

    }


    /**
     * 判断key是否存在于布隆过滤器中
     */
    public boolean mightContain(String key){
        return bloomFilter.mightContain(key);
    }

}
