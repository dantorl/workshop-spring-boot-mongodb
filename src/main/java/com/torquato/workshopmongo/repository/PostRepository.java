package com.torquato.workshopmongo.repository;

import com.torquato.workshopmongo.domain.Post;
import com.torquato.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
