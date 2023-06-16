package com.tingeso.subirporcentajeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SubirPorcentajeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubirPorcentajeServiceApplication.class, args);
	}

}
