package com.madang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;

@SpringBootApplication(
	exclude = { HttpEncodingAutoConfiguration.class }
)
public class MadangApplication {

	public static void main(String[] args) {
		SpringApplication.run(MadangApplication.class, args);
	}

}
