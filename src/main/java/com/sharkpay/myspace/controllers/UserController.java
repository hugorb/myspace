package com.sharkpay.myspace.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharkpay.myspace.dto.UserDTO;
import com.sharkpay.myspace.entities.User;
import com.sharkpay.myspace.services.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> userList = service.findAll();
		List<UserDTO> userDTOList = userList.stream()
				.map(user -> UserDTO.convertToDTO(user))
				.collect(Collectors.toList());
		return ResponseEntity.ok(userDTOList);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User user = service.findById(id);
		UserDTO userDTO = UserDTO.convertToDTO(user);
		return ResponseEntity.ok(userDTO);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody User user) {
		service.insert(user);
		return ResponseEntity.created(null).build();
	}
	
	@PutMapping
	public ResponseEntity<Void> update(@RequestBody User user) {
		service.update(user);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping
	public ResponseEntity<Void> delete(@RequestBody User user) {
		service.delete(user);
		return ResponseEntity.noContent().build();
	}

}
