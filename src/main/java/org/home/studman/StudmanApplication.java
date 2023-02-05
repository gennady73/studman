package org.home.studman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class StudmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudmanApplication.class, args);
	}

}
