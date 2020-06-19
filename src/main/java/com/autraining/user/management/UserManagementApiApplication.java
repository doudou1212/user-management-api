package com.autraining.user.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementApiApplication.class, args);
	}
}
