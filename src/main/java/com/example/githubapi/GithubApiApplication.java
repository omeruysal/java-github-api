package com.example.githubapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GithubApiApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(GithubApiApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);}

}
