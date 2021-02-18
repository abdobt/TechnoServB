package com.example.demo;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class Serv2Application {

	public static void main(String[] args) {

		SpringApplication.run(Serv2Application.class, args);
	}
	@Bean
	public RestTemplate restTemplate(){
	 return new RestTemplate();
	 }
}
