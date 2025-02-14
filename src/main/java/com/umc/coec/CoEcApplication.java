package com.umc.coec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CoEcApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoEcApplication.class, args);
    }

}
