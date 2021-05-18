package com.claim.springbackendlightscape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.claim")
public class SpringBackEndLightscapeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBackEndLightscapeApplication.class, args);
	}

}
