package com.bai.ding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author BaiDing
 * @date 2020/3/10 0:22
 */
 @MapperScan(value = "com.bai.ding.**.dao")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
