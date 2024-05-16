package com.sparta.springtask1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJpaAuditing
@SpringBootApplication
public class Springtask1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springtask1Application.class, args);
    }

}
