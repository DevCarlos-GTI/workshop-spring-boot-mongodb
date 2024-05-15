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
	
	//metodo para atualizar
	public User update(User obj) {
		
		//para atualizar 1° busco o user por id
		User newObj = findById(obj.getId()); 
		updateData(newObj, obj); 
		return repository.save(newObj); 
	}
	
	//obj copia os dados para newObj
	private void updateData(User newObj, User obj) {
		
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}

	//metodo fromDTO
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
	
}
