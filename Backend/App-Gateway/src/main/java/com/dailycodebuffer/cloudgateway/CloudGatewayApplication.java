package com.dailycodebuffer.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@EnableEurekaClient
@CrossOrigin(origins = "*")
public class CloudGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}
}
