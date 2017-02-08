package com.anand.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PilotageMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PilotageMicroServiceApplication.class, args);
	}
}
