package com.humy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: Hu Min
 * @Date: 2018/11/5 13:55
 * @Description:
 */
@SpringBootApplication
public class Springboot_01Application {
    public static void main(String[] args) {
        System.out.println("Start");
        SpringApplication.run(Springboot_01Application.class, args);
    }
}
