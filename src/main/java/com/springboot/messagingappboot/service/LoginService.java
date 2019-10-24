package com.springboot.messagingappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.messagingappboot.config.roleConstants;
import com.springboot.messagingappboot.dto.Credentials;
import com.springboot.messagingappboot.dto.User;
import com.springboot.messagingappboot.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	UserService userService;
	@Autowired
	CredentialsService credentialsService;
	@Autowired
	UserRepository userRepository;
	
	public String getView(String role) {
		if (role.equals(roleConstants.ROLE_ADMIN)) {
			return "admin";
		}else if (role.equals(roleConstants.ROLE_USER)){
			return "user";
		} else {
			return "";
		}
	}
	
	public User getUser(String username) {
		Credentials credentials = credentialsService.getByUsername(username);
		return userService.getByCredentials(credentials);
	}
	
	public boolean userExists(String username) {
		if(getUser(username) == null) {
			return false;
		}
		return true;
		
//		List<User> users = userRepository.findAll();
//		for(User u : users) {
//			if (u.getCredentials().getUsername().trim().equalsIgnoreCase(username)) {
//				return true;
//			}
//		}
//		return false;
	}
	
}
