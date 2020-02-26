package com.mcy.mp.fristmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.mcy.mp.fristmp.mapper"})
public class FristmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(FristmpApplication.class, args);
    }

}
