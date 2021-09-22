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

import com.sharkpay.myspace.dto.PostDTO;
import com.sharkpay.myspace.entities.Post;
import com.sharkpay.myspace.services.PostService;

@RestController
@RequestMapping(path = "/posts")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping
	public ResponseEntity<List<PostDTO>> findAll() {
		List<Post> postList = service.findAll();
		List<PostDTO> postDTOList = postList.stream()
				.map(post -> PostDTO.convertToDTO(post))
				.collect(Collectors.toList());
		return ResponseEntity.ok(postDTOList);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<PostDTO> findById(@PathVariable String id) {
		Post post = service.findById(id);
		PostDTO postDTO = PostDTO.convertToDTO(post);
		return ResponseEntity.ok(postDTO);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Post post) {
		service.insert(post);
		return ResponseEntity.created(null).build();
	}
	
	@PutMapping
	public ResponseEntity<Void> update(@RequestBody Post post) {
		service.update(post);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
