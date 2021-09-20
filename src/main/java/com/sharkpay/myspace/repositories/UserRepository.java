package com.sharkpay.myspace.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sharkpay.myspace.entities.User;

public interface UserRepository extends MongoRepository<User, String>{

}
