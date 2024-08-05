package com.database.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.database.config.entity.User;
import com.database.config.repo.UserRepo;

@SpringBootApplication
public class DbConfig1Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DbConfig1Application.class, args);
		
		UserRepo ups = context.getBean(UserRepo.class);
	
		User us = new User();
		us.setName("Hemant Garg");
		us.setCity("Pune");
		
		User us1 = ups.save(us);
	
		System.out.println(us1);
	}

}
