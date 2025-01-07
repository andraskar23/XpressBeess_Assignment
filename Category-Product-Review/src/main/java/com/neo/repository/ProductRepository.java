package com.neo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

	Product findProductByName(String name);

}
