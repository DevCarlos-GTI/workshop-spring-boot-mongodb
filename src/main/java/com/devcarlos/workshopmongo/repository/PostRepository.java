package com.devcarlos.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.devcarlos.workshopmongo.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//consulta no database
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	//IgnoreCase ignora letras maiusculas de minusculas

}