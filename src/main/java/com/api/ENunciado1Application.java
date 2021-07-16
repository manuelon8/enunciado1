package com.api;

 
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ENunciado1Application extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ENunciado1Application.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(ENunciado1Application.class, args);
	}

}
