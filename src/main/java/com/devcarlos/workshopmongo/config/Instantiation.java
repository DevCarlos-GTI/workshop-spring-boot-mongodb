package com.devcarlos.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devcarlos.workshopmongo.domain.Post;
import com.devcarlos.workshopmongo.domain.User;
import com.devcarlos.workshopmongo.dto.AuthorDTO;
import com.devcarlos.workshopmongo.repository.PostRepository;
import com.devcarlos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//formatar a data antes de inserir
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));//GMT Hora Média em Greenwich
		
		//1° deleto 
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		//depois inserir
		User maria = new User(null, "Maria Brown", "maria@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com"); 
		
		//vamos salvar 1° os usuarios criar os Ids 
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO( maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		//depois salvar AuthorDTO para receber os ids do users
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		
	}

}
