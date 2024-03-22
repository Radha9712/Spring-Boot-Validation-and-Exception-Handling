package com.validation.api.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.api.dto.UserRequest;
import com.validation.api.entity.User;
import com.validation.api.exception.UserNotFoundException;
import com.validation.api.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User saveUser(UserRequest userRequest) {
		User user = new User();
		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setMobile(userRequest.getMobile());
		user.setGender(userRequest.getGender());
		user.setAge(userRequest.getAge());
		user.setNationality(userRequest.getNationality());
		return  repository.save(user);
		
		
	 
	}
	
	public List<User> getAllusers(){
		return repository.findAll();
	}
	
	public User getUser(int id) throws UserNotFoundException {
		User user = repository.findByuserId(id);
		if (user!=null) {
			return user;
		}else {
			throw new UserNotFoundException("user not found with id:"+id);
		}
	}

}
