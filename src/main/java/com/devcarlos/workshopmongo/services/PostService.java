package com.devcarlos.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devcarlos.workshopmongo.domain.Post;
import com.devcarlos.workshopmongo.repository.PostRepository;
import com.devcarlos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	// insanciar nossa dependências
	@Autowired
	private PostRepository repository;


	// metodo p buscar por ID
	public Post findById(String id) { 
		 Optional<Post> obj = repository.findById(id); 
		 return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); 
	}
	
	public List<Post> findByTitle(String text) {
		
		//mesmo criado no repositorio
		return repository.findByTitleContainingIgnoreCase(text);
		
	}
}
