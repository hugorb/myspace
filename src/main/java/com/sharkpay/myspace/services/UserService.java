package com.sharkpay.myspace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sharkpay.myspace.entities.User;
import com.sharkpay.myspace.repositories.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(String id) {
		return repository.findById(id).get();
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User update(User obj) {
		User user = findById(obj.getId());
		user.setEmail(obj.getEmail());
		user.setName(obj.getName());
		user.setPassword(obj.getPassword());
		return repository.save(user);
	}
	
	public void delete(User obj) {
		repository.delete(obj);
	}

}
