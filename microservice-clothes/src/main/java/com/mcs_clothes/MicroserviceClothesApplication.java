package com.mcs_clothes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceClothesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClothesApplication.class, args);
	}

}
