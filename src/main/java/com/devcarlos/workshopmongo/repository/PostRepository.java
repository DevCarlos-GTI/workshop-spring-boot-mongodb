package com.devcarlos.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.devcarlos.workshopmongo.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	
	//consulta @query/testar se tem um titulo/// ?0 que dizer o 1° parâmetro q vem no metodo/ i ignora  Maiuscula e minuscula/ search = procurar
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	//consulta no database
	List<Post> findByTitleContainingIgnoreCase(String text);//IgnoreCase ignora letras maiusculas de minusculas
	
	////fazer comparações de minDate(?1) And maxDate(?2) , comparar text(?0) com Title or Body or Coments.text de acordos com os atributos
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}