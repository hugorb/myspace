package com.sharkpay.myspace.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sharkpay.myspace.entities.Post;
import com.sharkpay.myspace.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll() {
		return repository.findAll();
	}
	
	public Post findById(String id) {
		return repository.findById(id).get();
	}
	
	public Post insert(Post obj) {
		return repository.insert(obj);
	}
	
	public Post update (Post obj) {
		Post post = findById(obj.getId());
		updateData(post, obj);
		return repository.save(post);
	}
	
	public void delete(Post obj) {
		Post post = findById(obj.getId());
		repository.delete(post);
	}
	
	private void updateData(Post newPost, Post oldPost) {
		newPost.setAuthor(oldPost.getAuthor());
		newPost.setContent(oldPost.getContent());
		newPost.setLikes(oldPost.getLikes());
		newPost.setMoment(oldPost.getMoment());
		newPost.setTitle(oldPost.getTitle());
		oldPost.getComments().forEach(comment -> newPost.getComments().add(comment));
	}

}
