package com.example.gestiondescours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class GestiondescoursApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestiondescoursApplication.class, args);
	}

}
