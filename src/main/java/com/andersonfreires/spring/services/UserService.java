package com.andersonfreires.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonfreires.spring.domain.User;
import com.andersonfreires.spring.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository repository;
	
	
	public List<User> findAll(){
	return	repository.findAll();
	}

	
}
