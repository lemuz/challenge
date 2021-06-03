package com.equifax.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import dummy.DummyTest;


@SpringBootApplication(exclude = { 
    HibernateJpaAutoConfiguration.class})
public class ChallengeApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		
		SpringApplication.run(ChallengeApplication.class, args);
		
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ChallengeApplication.class);
	}
	
	@Bean
	public DummyTest dummyTest() {
		return new DummyTest();
	}
}
