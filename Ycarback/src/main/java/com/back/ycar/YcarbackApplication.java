package com.back.ycar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:config/secu.properties")
public class YcarbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(YcarbackApplication.class, args);
	}

}