package com.devcarlos.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.devcarlos.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {


	//so com isso ja faco operações com database MongoDB

}
