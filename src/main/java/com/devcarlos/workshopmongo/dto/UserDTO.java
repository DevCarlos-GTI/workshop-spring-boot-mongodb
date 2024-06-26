package com.devcarlos.workshopmongo.dto;

import java.io.Serializable;

import com.devcarlos.workshopmongo.domain.User;

//pega uma copia de user
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;

	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	//construtor manualmente 
	public UserDTO( User obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
