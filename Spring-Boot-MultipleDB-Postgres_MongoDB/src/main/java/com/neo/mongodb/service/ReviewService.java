package com.neo.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.mongodb.enitity.Product;
import com.neo.mongodb.enitity.Review;
import com.neo.mongodb.exception.ProductNotFoundException;
import com.neo.mongodb.repo.ProductRepository;

@Service
public class ReviewService {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	//Add Review
	public String addRivew(String prodId, Review review) throws ProductNotFoundException {
		Optional<Product> prod = productRepository.findById(prodId);
		
		if(prod.isEmpty()) {
			throw new ProductNotFoundException("Product is ${productRequest.getProductName()} not found");
		}
		Product currProd = prod.get();
		List<Review> currList = currProd.getReviews();
		currList.add(review);
		currProd.setReviews(currList);
		
		
		return "Review added to productID = "+prodId;
		
	}
	
//	
//	// Delete Review
//	
//	public String deleteReviewFromProduct(String reviewId) {
//		
//		
//	}
	
	

}
