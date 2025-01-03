package com.neo.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.mongodb.dto.ReviewRequest;
import com.neo.mongodb.exception.ProductNotFoundException;

import com.neo.mongodb.service.ReviewService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	
	@PostMapping("/addreview/{prodId}")
	public ResponseEntity<?> addReview(@PathVariable String prodId, @RequestBody ReviewRequest reviewRequest) throws ProductNotFoundException {
		String reviewSaved = reviewService.addReview(prodId, reviewRequest);
				
		return ResponseEntity.status(HttpStatus.CREATED).body(reviewSaved);
	}

	
}
