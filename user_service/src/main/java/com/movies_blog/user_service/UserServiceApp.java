package com.movies_blog.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.movies_blog.user_service")
@EnableAsync
@ComponentScan(basePackages = {"com.movies_blog.common", "com.movies_blog.user_service"})
@EntityScan(basePackages = {"com.movies_blog.common.Entities", "com.movies_blog.user_service.Entities"})
public class UserServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApp.class, args);
    }

}
