package com.example.etudiant;

import com.example.etudiant.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication

public class EtudiantApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantApplication.class, args);
	}
	@Autowired
	private EtudiantRepository repository;

	@Bean
	ApplicationRunner init() {
		return (args) -> {




		};
	}
}
