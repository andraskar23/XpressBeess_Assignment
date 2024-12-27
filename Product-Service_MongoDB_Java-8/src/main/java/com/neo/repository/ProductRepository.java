package com.neo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.neo.model.Product;

public interface ProductRepository extends MongoRepository<Product , String> {
	
	
}
