package com.devcarlos.workshopmongo.resources;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcarlos.workshopmongo.domain.User;
import com.devcarlos.workshopmongo.dto.UserDTO;
import com.devcarlos.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//dependencia do meu serviço
	@Autowired
	private UserService service;
	
	//@RequestMapping(method = RequestMethod.GET)
	/*@GetMapping
	public ResponseEntity<List<User>> findALL(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}*/
	
	
	//vamos mudar p lista DTO
	@GetMapping
	//@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findALL(){
		List<User> list = service.findAll();
		
		//vamos converter minha lista de User p lista DTO
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	//@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = service.findById(id);
		//Optional<User> obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
		
	
	//aqui e forma manual
	/*metodo p buscar todos usuários
		//@RequestMapping(method = RequestMethod.GET)
		@GetMapping
		//public List<User> findAll(){
		public ResponseEntity<List<User>> findAll(){ //melhorando nossas resposta

			//vamos inserir alguns users para test
			User maria = new User("1001", "Maria Brown", "maria@gmail.com"); 
			User alex = new User("1002", "Alex Green", "alex@gmail.com");

			//vamos add esse users numa lista
			List<User> list = new ArrayList<>();
			list.addAll(Arrays.asList(maria, alex));

			//return list;

			return ResponseEntity.ok().body(list);
		}*/

}
