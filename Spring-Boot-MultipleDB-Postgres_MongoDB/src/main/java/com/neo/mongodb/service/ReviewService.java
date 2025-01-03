package com.neo.mongodb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.mongodb.dto.ReviewRequest;
import com.neo.mongodb.enitity.Product;
import com.neo.mongodb.enitity.Review;
import com.neo.mongodb.exception.ProductNotFoundException;
import com.neo.mongodb.repo.ProductRepository;

@Service
public class ReviewService {

	@Autowired
	private ProductRepository productRepository;

	// Add Review
	public String addReview(String prodId, ReviewRequest reviewRequest) throws ProductNotFoundException {
		Optional<Product> prod = productRepository.findById(prodId);

		System.out.println("=====" + reviewRequest);
		if (prod.isPresent()) {

			Review review = new Review();
			review.setReviewId(UUID.randomUUID().toString().replace("-", ""));
			review.setComment("idxsadsd");
			review.setRatings(8);

			// .reviewId(UUID.randomUUID().toString().replace("-",""))
			// .ratings(reviewRequest.getRatings())
			// .comment(reviewRequest.getComment())
			// .build();

			Product currProd = prod.get();
			List<Review> currList = currProd.getReviews();
			currList.add(review);
			currProd.setReviews(currList);

			System.out.println("====" + currProd);
			System.out.println("====" + currList);

			productRepository.save(currProd);
		} else {

			throw new ProductNotFoundException("Product ID " + prodId + " not found");
		}

		return "Review added to productID = " + prodId;
	}

//	
//	// Delete Review
//	
//	public String deleteReviewFromProduct(String reviewId) {
//		
//		
//	}

}
