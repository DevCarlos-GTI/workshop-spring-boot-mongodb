package com.devcarlos.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcarlos.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//metodo p buscar todos usuários
	//@RequestMapping(method = RequestMethod.GET)
	@GetMapping
	//public List<User> findByAll(){
	public ResponseEntity<List<User>> findByAll(){ //melhorando nossas resposta
		
		//vamos inserir alguns users para test
		User maria = new User("1001", "Maria Brown", "maria@gmail.com"); 
		User alex = new User("1002", "Alex Green", "alex@gmail.com");
		
		//vamos add esse users numa lista
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		
		//return list;
		
		return ResponseEntity.ok().body(list);
	}

}
