package com.sharkpay.myspace.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sharkpay.myspace.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
