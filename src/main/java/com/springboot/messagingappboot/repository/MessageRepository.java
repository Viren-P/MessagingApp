package com.springboot.messagingappboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.messagingappboot.dto.Message;

public interface MessageRepository extends JpaRepository<Message, String>{
	
	@Query
	public List<Message> findBySender(String senderName);
	
	@Query
	public List<Message> findByReceiver(String receiverName);
	
	@Query
	public List<Message> findByTitle(String title);
}
