package com.lanwq.data_structure_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

// 排除数据库依赖
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DataStructureDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataStructureDemoApplication.class, args);
    }

}
