package com.springboot.messagingappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.messagingappboot.dto.Credentials;
import com.springboot.messagingappboot.dto.User;
import com.springboot.messagingappboot.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User getById(String id) {
		return userRepository.findById(id).orElse(new User());
	}
	
	public List<User> getall(){
		return userRepository.findAll();
	}
	
	public User getByCredentials(Credentials credentials) {
		return userRepository.findByCredentials(credentials);
	}
	
	public void add(User user) {
		userRepository.save(user);
	}
	
	public void update(User user) {
		User userExisting = this.getById(user.getId());
		if (userExisting != null) {
			user.setId(userExisting.getId());
			userRepository.save(user);
		}
	}
	
	public void delete(String id) {
		userRepository.deleteById(id);
	}
	
	
}
