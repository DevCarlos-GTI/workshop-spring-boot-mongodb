package com.devcarlos.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.devcarlos.workshopmongo.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//consulta @query
	@Query("{'title' : { $regex: ?0, $options: 'i' } }") // ?0 que dizer o 1° parâmetro q vem no metodo/ i ignora  Maiuscula e minuscula
	List<Post> searchTitle(String text);
	
	//consulta no database
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	//IgnoreCase ignora letras maiusculas de minusculas

}