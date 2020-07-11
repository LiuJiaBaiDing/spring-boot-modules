package com.bai.ding.admin.controller;

import com.bai.ding.admin.model.Dog;
import com.bai.ding.common.util.RedisUtil;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author BaiDing
 * @date 2020/3/10 0:27
 */
@RestController
public class Admin {

    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("redis")
    public String login() {
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        Dog dog1 = new Dog();
        dog1.setId(11);
        dog1.setName("aaa");
        dog1.setAge(3);

        Dog dog2 = new Dog();
        dog2.setId(12);
        dog2.setName("bbb");
        dog2.setAge(4);

        List<Dog> list = Lists.newArrayList();
        list.add(dog2);

        dog1.setChildren(list);

        vo.set("dog", dog1);
        return RedisUtil.get("dog");
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }
}
