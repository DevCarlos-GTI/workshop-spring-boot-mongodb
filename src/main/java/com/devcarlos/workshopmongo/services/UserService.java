package com.devcarlos.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarlos.workshopmongo.domain.User;
import com.devcarlos.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	//insanciar nossa dependências
	@Autowired
	private UserRepository repository;
	
	//metodo p buscar todos users
	public List<User> findAll(){
		return repository.findAll();
	}
	
}
