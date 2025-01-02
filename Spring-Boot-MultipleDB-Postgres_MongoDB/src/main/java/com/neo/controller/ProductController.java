package com.neo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neo.mongodb.dto.ProductRequest;
import com.neo.mongodb.enitity.Product;
import com.neo.mongodb.exception.ProductAlreadyFoundException;
import com.neo.mongodb.exception.ProductNotFoundException;
import com.neo.mongodb.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/addproduct")
	public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest) throws ProductAlreadyFoundException {
		Product productSaved = productService.addProduct(productRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
	}

	@GetMapping("/getallproducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> allProduct = (List<Product>) productService.getAllProduct();
		return ResponseEntity.status(HttpStatus.OK).body(allProduct);
	}
	
	
	@GetMapping("/getprodbyname/{name}")
	public ResponseEntity<?> getProdByName(@RequestParam String productName) throws ProductNotFoundException{
		
		
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProdByName(productName));
	}

	@DeleteMapping("/deleteprodbyid")
	public ResponseEntity<?> deleteProductById(@RequestParam("id") String id) throws ProductNotFoundException {
	
		return ResponseEntity.status(HttpStatus.OK).body(productService.deleteProduct(id));
	}


	
//	
//	@PostMapping("/add-review")
//	public ResponseEntity<Review> addReview(@RequestBody Review review) {
//		Review reviewSaved = reviewRepo.save(review);
//		return ResponseEntity.status(HttpStatus.CREATED).body(reviewSaved);
//	}
//	@GetMapping("/get-all/review")
//	public ResponseEntity<List<Review>> getAllReview() {
//		List<Review> allreview = (List<Review>) reviewRepo.findAll();
//		return ResponseEntity.status(HttpStatus.OK).body(allreview);
//	}

}
