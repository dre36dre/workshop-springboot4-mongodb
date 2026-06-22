package com.andersonfreires.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonfreires.spring.domain.Post;
import com.andersonfreires.spring.repositories.PostRepository;
import com.andersonfreires.spring.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	
	@Autowired
	private PostRepository repository;


	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public  List<Post> findByTitle(String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}
}
