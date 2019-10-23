package com.springboot.messagingappboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.messagingappboot.dto.Credentials;

public interface CredentialsRepository extends JpaRepository<Credentials, String>{

	@Query
	public Credentials findByUsername(String username);
	
}
