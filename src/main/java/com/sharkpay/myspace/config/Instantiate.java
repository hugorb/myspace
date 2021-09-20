package com.sharkpay.myspace.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.sharkpay.myspace.entities.Comment;
import com.sharkpay.myspace.entities.Post;
import com.sharkpay.myspace.entities.User;
import com.sharkpay.myspace.repositories.PostRepository;
import com.sharkpay.myspace.repositories.UserRepository;

@Configuration
public class Instantiate implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User("Hugo", "hugo@gmail.com", "123456");
		User u2 = new User("Rafael", "rafael@gmail.com", "741258");
		User u3 = new User("Vinicius", "vini@gmail.com", "963285");
		
		Post p1 = new Post(LocalDate.now(), "Sextou", "sextando no bar com os amigos", 4, u2);
		Post p2 = new Post(LocalDate.now(), "Estudos", "estudar é importante", 93, u1);
		Post p3 = new Post(LocalDate.now(), "Java > PHP", "é só olhar no google trends", 1, u3);
		
		Comment c1 = new Comment("nem me chamou :(", LocalDate.now(), 3, u1);
		Comment c2 = new Comment("boa! partiu virar dev!", LocalDate.now(), 3, u2);
		Comment c3 = new Comment("que post bom!", LocalDate.now(), 3, u3);
		
		p1.getComments().add(c1);
		p2.getComments().add(c2);
		p3.getComments().add(c3);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		postRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
