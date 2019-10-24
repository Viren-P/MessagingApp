package com.springboot.messagingappboot.service;

import com.springboot.messagingappboot.dto.Credentials;
import com.springboot.messagingappboot.repository.CredentialsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialsService {

	@Autowired
	CredentialsRepository credentialsRepository;
	
	public Credentials getById(String id) {
		return credentialsRepository.findById(id).orElse(new Credentials());
	}
	
	public Credentials getByUsername(String username) {
		return credentialsRepository.findByUsername(username);
	}
	
	public List<Credentials> getall(){
		return credentialsRepository.findAll();
	}
	
	public void add(Credentials credentials) {
		credentialsRepository.save(credentials);
	}
	
	public void update(Credentials credentials) {
		Credentials credentialsExisting = this.getById(credentials.getId());
		if (credentialsExisting != null) {
			credentials.setId(credentialsExisting.getId());
			credentialsRepository.save(credentials);
		}
	}
	
	public void delete(String id) {
		credentialsRepository.deleteById(id);
	}
	
}
