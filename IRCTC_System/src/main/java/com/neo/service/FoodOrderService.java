package com.neo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.event.ListSelectionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dto.FoodOrderResponse;
import com.neo.dto.FoodOrderRquest;
import com.neo.entity.Food;
import com.neo.entity.FoodOrder;
import com.neo.entity.Passenger;
import com.neo.repository.FoodOrderRepo;
import com.neo.repository.FoodRepo;
import com.neo.repository.PassengerRepo;

@Service
public class FoodOrderService {

	@Autowired
	private PassengerRepo passengerRepo;

	@Autowired
	private FoodOrderRepo foodOrderRepo;

	@Autowired
	private FoodRepo foodRepo;

//	public String orderFood(FoodOrderRquest foodOrderRequest) {
//
//		// get the passenger by ticket ID
//		Optional<Passenger> passenger = passengerRepo.findById(foodOrderRequest.getTicketId());
//		if (passenger.isEmpty()) {
//			throw new RuntimeException("Invalid Ticket Id...");
//		}
//		Optional<Food> food = foodRepo.findByFoodName(foodOrderRequest.getFoodName());
//		System.out.println(food.get());
//		if (food.isEmpty()) {
//			throw new RuntimeException("Food not found ....");
//		}else {
//		List<Food> fd1 = passenger.get().getFoodOrders().stream().flatMap(fd -> fd.getFoods().stream()).toList();
//		fd1.add(food.get());
//			FoodOrder newFoodOrder = FoodOrder.builder()
//					.train(passenger.get().getTrain())
//					.passenger(passenger.get())
//					.foods(fd1)
//					.build();
//			foodOrderRepo.save(newFoodOrder);
//		}
//		return null;
//	}
	
	
}