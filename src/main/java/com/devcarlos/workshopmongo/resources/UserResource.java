package com.devcarlos.workshopmongo.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devcarlos.workshopmongo.domain.Post;
import com.devcarlos.workshopmongo.domain.User;
import com.devcarlos.workshopmongo.dto.UserDTO;
import com.devcarlos.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	//dependencia do meu serviço
	@Autowired
	private UserService service;
	
	//lista todos
	//vamos mudar p lista DTO
	@GetMapping
	//@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findALL(){
		List<User> list = service.findAll();
		
		//vamos converter minha lista de User p lista DTO
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	//listar por Id
	//@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id){
		User obj = service.findById(id);
		//Optional<User> obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	//inserir
	//@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
		
		User obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		//vamos pegar novo obj que foi inserido
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//deletar
	//@RequestMapping(method = RequestMethod.DELETE)
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		
		//p retonar uma vois=d
		return ResponseEntity.noContent().build();
	}
	
	//atualizar
	//@RequestMapping(method = RequestMethod.PUT)
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id){
		
		User obj = service.fromDTO(objDto);
		
		//antes de atualizar setar o Id
		obj.setId(id);
		
		//atualizar
		service.update(obj);
		
		//p retonar uma vois=d
		return ResponseEntity.noContent().build();
	}
	
	//buscar por id post
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id){
		User obj = service.findById(id);
		//Optional<User> obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());
	}
	
	//listar
	//@RequestMapping(method = RequestMethod.GET)
		/*@GetMapping
		public ResponseEntity<List<User>> findALL(){
			List<User> list = service.findAll();
			return ResponseEntity.ok().body(list);
	}*/
		
	
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
