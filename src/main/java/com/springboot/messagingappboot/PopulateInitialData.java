package com.springboot.messagingappboot;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.messagingappboot.config.data;
import com.springboot.messagingappboot.config.roleConstants;
import com.springboot.messagingappboot.dto.Credentials;
import com.springboot.messagingappboot.dto.User;
import com.springboot.messagingappboot.service.CredentialsService;
import com.springboot.messagingappboot.service.UserService;

public class PopulateInitialData {
	
	@Autowired
	private static CredentialsService credentialsService;
	@Autowired
	private static UserService userService;
	
		
	
	public static void populateData() {
		System.out.println("populating");
		String role;
		for(String uName : data.USERNAME) {
			
			Credentials credentials = new Credentials();
			credentials.setUsername(uName);
			credentials.setPassword(data.PASSWORD);
			credentialsService.add(credentials);
		
			if(uName.equals("admin")) {
				role = roleConstants.ROLE_ADMIN;
			}else {
				role = roleConstants.ROLE_USER;
			}
			
			User user = new User();
			user.setCredentials(credentials);
			user.setRole(role);
			userService.add(user);
			
		}
	}
	
}
