package com.springboot.messagingappboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.messagingappboot.dto.Credentials;
import com.springboot.messagingappboot.dto.User;

public interface UserRepository extends JpaRepository<User, String>{

	@Query
	public User findByCredentials(Credentials credentials);
	
}
