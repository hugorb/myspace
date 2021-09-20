package com.sharkpay.myspace.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sharkpay.myspace.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
