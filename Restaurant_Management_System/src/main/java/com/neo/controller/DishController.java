package com.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.Dish;
import com.neo.service.DishService;

@RestController
@RequestMapping("/restaurant")
public class DishController {

	@Autowired
	private DishService dishService;
	
	@PostMapping("/createdish")
	public ResponseEntity<?> addDish(@RequestBody Dish dish){
		return new ResponseEntity<>(dishService.addDish(dish),HttpStatus.CREATED);
	}
	
	@GetMapping("/getalldishes")
	public ResponseEntity<?> getAllDishes(){
		return new ResponseEntity<>(dishService.getAllDishes(),HttpStatus.OK);
	}
	
}
