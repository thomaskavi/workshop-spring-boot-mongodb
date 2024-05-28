package com.thomaskavi.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.thomaskavi.workshopmongo.domain.User;

// A anotação @Repository indica que esta interface é um repositório Spring Data.
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Extende a interface MongoRepository, fornecendo operações CRUD para a entidade User.
    // O tipo da entidade é User e o tipo do ID é String.
}
