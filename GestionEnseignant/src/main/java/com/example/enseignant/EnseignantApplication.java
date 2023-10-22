package com.example.enseignant;

import com.example.enseignant.entities.Enseignant;
import com.example.enseignant.repositories.IEnseignantRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@EnableDiscoveryClient
public class EnseignantApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(EnseignantApplication.class, args);
    }
    @Bean
ApplicationRunner init (IEnseignantRepository repository){
        return args ->{
            Stream.of("sarra").forEach(nom ->{
                repository.save(new Enseignant(nom));
            });
            repository.findAll().forEach(System.out::println);
        };
    }
}
