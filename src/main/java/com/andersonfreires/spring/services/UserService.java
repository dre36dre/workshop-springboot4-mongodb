package com.andersonfreires.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonfreires.spring.domain.User;
import com.andersonfreires.spring.dto.UserDTO;
import com.andersonfreires.spring.repositories.UserRepository;
import com.andersonfreires.spring.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private  UserRepository repository;
	
	
	public List<User> findAll(){
	return	repository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	public User insert(User obj) {
		return repository.insert(obj);
				}
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(),objDto.getEmail());
	}
}
