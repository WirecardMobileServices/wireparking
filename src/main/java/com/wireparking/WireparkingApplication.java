package com.wireparking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.wireparking.repository")
@SpringBootApplication
public class WireparkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WireparkingApplication.class, args);
	}
}
