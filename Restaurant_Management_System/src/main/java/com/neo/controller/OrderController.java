package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.dto.DishRequest;
import com.neo.exception.BillAlreadyPaidException;
import com.neo.exception.DishNotFoundException;
import com.neo.exception.TableOccupiedException;
import com.neo.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/placeorder/{tablenum}")
	public ResponseEntity<?> placeNewOrder(@PathVariable("tablenum") Integer tableNum , @RequestBody DishRequest dishes) throws DishNotFoundException, TableOccupiedException{
		
		return new ResponseEntity<>(orderService.placeNewOrder(tableNum, dishes),HttpStatus.CREATED);
	}
	
	@GetMapping("/payment/{tablenum}")
	public ResponseEntity<?> billing(@PathVariable("tablenum") Integer tableNumber) throws BillAlreadyPaidException{
		return new ResponseEntity<>(orderService.billing(tableNumber),HttpStatus.OK);
	}
	

}
