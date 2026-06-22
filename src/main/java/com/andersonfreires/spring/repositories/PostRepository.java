package com.andersonfreires.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.andersonfreires.spring.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
