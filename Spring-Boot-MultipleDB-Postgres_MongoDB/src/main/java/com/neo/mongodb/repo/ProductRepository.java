package com.neo.mongodb.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.neo.mongodb.enitity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

	@Query(value = "{ 'productName': ?0 }")
	Optional<Product> findByProductName(String name);
}
