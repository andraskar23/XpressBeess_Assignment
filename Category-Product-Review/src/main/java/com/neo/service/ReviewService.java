package com.neo.service;

import java.util.List;

import com.neo.dto.ApiResponse;
import com.neo.entity.Review;

public interface ReviewService {

	
	public Review getReviewById(int id);

	
	public Review saveReviewByProductId(Review review, int productId);

	
	public List<Review> getReviewsByProductId(int productId);


	public Review editReviewById(int id, Review review);

	public ApiResponse deleteById(int id);

}
