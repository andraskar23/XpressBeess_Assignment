package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.entity.Food;
import com.neo.service.FoodService;

@RestController
@RequestMapping("/food")
public class FoodController {

	@Autowired
	private FoodService foodService;

	@PostMapping("/addfood")
	public ResponseEntity<?> addFood(@RequestBody Food food) {
		return new ResponseEntity<>(foodService.addFood(food), HttpStatus.CREATED);
	}

	@GetMapping("/getallfood")
	public ResponseEntity<?> getAllFood() {
		return new ResponseEntity<>(foodService.listOfFood(), HttpStatus.OK);
	}
}
