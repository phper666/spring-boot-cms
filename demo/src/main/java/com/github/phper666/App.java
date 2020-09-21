package com.github.phper666;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liyuzhao
 */
@SpringBootApplication
@MapperScan("com.github.phper666.schemaregistry.rest.mapper")
public class App {
    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }
}
