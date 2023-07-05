package ru.sber.user.job.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class UserJobServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserJobServiceApplication.class, args);
    }
}
