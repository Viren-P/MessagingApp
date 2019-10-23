package com.springboot.messagingappboot.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="user_table")
public class User {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(columnDefinition = "CHAR(34)")
	String id;
	String role;
	@OneToOne
	Credentials credentials;
	@OneToMany(mappedBy="sender")
	List<Message> sent;
	@OneToMany(mappedBy="receiver")
	List<Message> received;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Credentials getCredentials() {
		return credentials;
	}
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<Message> getSent() {
		return sent;
	}
	public void setSent(List<Message> sent) {
		this.sent = sent;
	}
	public List<Message> getReceived() {
		return received;
	}
	public void setReceived(List<Message> received) {
		this.received = received;
	}
	
	
	
}
