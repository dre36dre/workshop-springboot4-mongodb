package com.andersonfreires.spring.config;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.andersonfreires.spring.domain.Post;
import com.andersonfreires.spring.domain.User;
import com.andersonfreires.spring.repositories.PostRepository;
import com.andersonfreires.spring.repositories.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;
	
	@Autowired
	private PostRepository postRepository;


	@Override
	public void run(String... arg0) throws Exception {
				
			
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		postRepository.deleteAll() ;
		
		User maria = new User(null, "Maria Black", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User dre = new User(null, "Dre Yellow", "dre@gmail.com");
		
		
		
		Post post1=new Post(null, sdf.parse("22/06/2026"),"Partiu viagem","Vou viajar para Nova Iorque",maria);
		Post post2=new Post(null, sdf.parse("22/06/2026"),"Bom dia","Acordei feliz hoje!",maria);
		Post post3=new Post(null, sdf.parse("22/06/2026"), "Boa tarde", "Hoje estou tão feliz",dre) ;
		
		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob,dre));
		postRepository.saveAll(Arrays.asList(post1,post2,post3));
		}

}