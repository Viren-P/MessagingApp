package com.springboot.messagingappboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.messagingappboot.dto.Message;
import com.springboot.messagingappboot.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;
	
	public Message getById(String id) {
		return messageRepository.findById(id).orElse(new Message());
	}
	
	public List<Message> getBySender(String senderName) {
		return messageRepository.findBySender(senderName);
	}
	
	public List<Message> getByReceiver(String receiverName){
		return messageRepository.findByReceiver(receiverName);
	}
	
	public List<Message> getByTitle(String title){
		return messageRepository.findByTitle(title);
	}
	
	public List<Message> getall(){
		return messageRepository.findAll();
	}
	
	public void add(Message message) {
		messageRepository.save(message);
	}
	
	public void update(Message message) {
		Message messageExisting = this.getById(message.getId());
		if (messageExisting != null) {
			message.setId(messageExisting.getId());
			messageRepository.save(message);
		}
	}
	
	public void delete(String id) {
		messageRepository.deleteById(id);
	}
	
}