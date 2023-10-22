package com.example.enseignant;


import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
public class EnseignantApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(EnseignantApplication.class, args);
    }
    @Bean
    ApplicationRunner init() {
        return args -> {
            System.out.println("Spring Boot application started!");
            // Your initialization logic goes here
        };
    }
}
