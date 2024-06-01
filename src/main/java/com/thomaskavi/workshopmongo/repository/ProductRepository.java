package com.thomaskavi.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.thomaskavi.workshopmongo.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
