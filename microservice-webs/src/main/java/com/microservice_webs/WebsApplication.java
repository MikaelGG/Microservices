package com.microservice_webs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class WebsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsApplication.class, args);
	}

}
