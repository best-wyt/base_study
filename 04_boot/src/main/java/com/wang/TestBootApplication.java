package com.wang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author wyt
 * @date 2023/3/15 16:27
 * @description
 */
@SpringBootApplication
@EnableWebMvc
public class TestBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBootApplication.class, args);
    }

}
