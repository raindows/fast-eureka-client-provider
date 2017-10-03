package com.meditrusthealth.fast.eureka.client.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FastEurekaClientProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastEurekaClientProviderApplication.class, args);
	}
}
