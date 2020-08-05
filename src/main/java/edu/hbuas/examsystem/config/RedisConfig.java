package edu.hbuas.examsystem.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author linuyx
 * @create 2020-07-15 13:03
 */

@Configuration
public class RedisConfig {

    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory factory){

        //为了开发方便，一般直接使用<String,Object>
        RedisTemplate<String,Object> template =new RedisTemplate<String,Object>();
        template.setConnectionFactory(factory);

        //Json序列化配置
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer=new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om=new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        //String的序列化
        StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();

        //Key采用string的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        //hash的Key也采用string的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        //value序列化采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //hash的value序列化采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;
    }
}
