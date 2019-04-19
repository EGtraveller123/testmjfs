package com.hxg.testmjfs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = "com.hxg.testmjfs.mapper")

public class TestmjfsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestmjfsApplication.class, args);
    }

}
