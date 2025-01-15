package com.xingchen;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: 35238
 * 功能: 媒资管理的启动类
 * 时间: 2024-04-15 22:11
 */
@EnableSwagger2Doc
@SpringBootApplication
public class MediaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MediaApplication.class, args);
    }
}