package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neo.dto.FoodOrderRquest;
import com.neo.service.FoodOrderService;

@RestController
@RequestMapping("/foodorder")
public class FoodOrderController {
	
	@Autowired
	private FoodOrderService foodOrderService;
	
//	@PostMapping("/placeorder")
//	public ResponseEntity<?> placeOrder(@RequestBody FoodOrderRquest foodOrderRequest){
//		
//		return new ResponseEntity<>(foodOrderService.orderFood(foodOrderRequest),HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/getorderbyticketid")
//	public ResponseEntity<?> getOrderByTicketId(@RequestParam("getbyid") String ticketId){
//		return new ResponseEntity<>(foodOrderService.getOrderByTicketId(ticketId),HttpStatus.OK);
//	}
	

}
