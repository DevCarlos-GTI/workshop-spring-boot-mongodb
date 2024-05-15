package com.devcarlos.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarlos.workshopmongo.domain.User;
import com.devcarlos.workshopmongo.dto.UserDTO;
import com.devcarlos.workshopmongo.repository.UserRepository;
import com.devcarlos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	// insanciar nossa dependências
	@Autowired
	private UserRepository repository;

	// metodo p buscar todos users
	public List<User> findAll() {
		return repository.findAll();
	}

	// metodo p buscar por ID
	public User findById(String id) { 
		 Optional<User> obj = repository.findById(id); 
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
	}
	
	//metodo para inserir
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	//metodo delete
	public void delete(String id) {
		
		//vamos aproveitar excerção do findById
		findById(id);
		
		repository.deleteById(id);
	}
	
	//metodo fromDTO
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
	
}
