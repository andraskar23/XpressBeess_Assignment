package com.neo.mongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.mongodb.dto.ProductRequest;
import com.neo.mongodb.enitity.Product;
import com.neo.mongodb.exception.ProductAlreadyFoundException;
import com.neo.mongodb.exception.ProductNotFoundException;
import com.neo.mongodb.repo.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product addProduct(ProductRequest productRequest) throws ProductAlreadyFoundException {
		Optional<Product> prodAvail = productRepository.findByProductName(productRequest.getProductName());
		if(prodAvail.isPresent()) {
			throw new ProductAlreadyFoundException("Product is already exist...");
		}
		
		Product pr = Product.builder()
				.productName(productRequest.getProductName())
				.price(productRequest.getPrice())
				.reviews(new ArrayList<>())
				.build();
		
		productRepository.save(pr);
		
		return pr;
	}
	
	public List<Product> getAllProduct()
	{
		return productRepository.findAll();
	}
	
	public Product getProdByName(String productName) throws ProductNotFoundException{
		if(productRepository.findByProductName(productName).isEmpty()) {
			throw new ProductNotFoundException("Product is not found");
		}
		
		return productRepository.findByProductName(productName).get();
	}

	public String deleteProduct(String id) throws ProductNotFoundException {
		if(productRepository.findById(id).isEmpty())
		{
			throw new ProductNotFoundException("Product is ${productRequest.getProductName()} not found");
		}
		productRepository.deleteById(id);
		
		return "Product id = "+id +"deleted successfully ";
	}
	
}
