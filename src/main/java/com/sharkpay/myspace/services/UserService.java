package com.sharkpay.myspace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharkpay.myspace.entities.User;
import com.sharkpay.myspace.repositories.UserRepository;

@Service
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
		updateData(user, obj);
		return repository.save(user);
	}
	
	public void deleteById(String id) {
		User user = findById(id);
		repository.delete(user);
	}
	
	private void updateData(User newUser, User oldUser) {
		newUser.setEmail(oldUser.getEmail());
		newUser.setName(oldUser.getName());
		newUser.setPassword(oldUser.getPassword());
	}

}
