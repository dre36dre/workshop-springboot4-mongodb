package com.andersonfreires.spring.config;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.andersonfreires.spring.domain.User;
import com.andersonfreires.spring.repositories.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;


	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		
		User maria = new User(null, "Maria Black", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User dre = new User(null, "Dre Yellow", "dre@gmail.com");
		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob,dre));

	}

}