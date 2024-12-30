package com.neo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.dto.DishRequest;
import com.neo.exception.BillAlreadyPaidException;
import com.neo.exception.DishNotFoundException;
import com.neo.exception.TableOccupiedException;
import com.neo.model.Dish;
import com.neo.model.Order;
import com.neo.repo.DishRepo;
import com.neo.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;

	@Autowired
	private DishRepo dishRepo;

	private Map<Integer, List<Dish>> newOrder = new HashMap<>();
//	private List<Dish> orderdList = new ArrayList<>();
// get new order from table no.

	public String placeNewOrder(Integer tableNum, DishRequest dishRequest)
			throws DishNotFoundException, TableOccupiedException {

		Optional<Order> occupiedTable = orderRepo.findByTableNumber(tableNum);
		Optional<Dish> dish = dishRepo.findByDishName(dishRequest.getDishName());
		
		if(occupiedTable.isEmpty()) {
			newOrder.put(tableNum, new ArrayList<Dish>(List.of(dish.get())));
			orderRepo.save(new Order(tableNum));
		}	
		

		System.out.println(dish.get());

		if (dish.isEmpty()) {
			throw new DishNotFoundException("Dish is not found...");
		}
		
		if (newOrder.containsKey(tableNum)) {

			List<Dish> currList = newOrder.get(tableNum);
			currList.add(dish.get());
			newOrder.put(tableNum, currList);
		} 

		System.out.println(newOrder);
		return "Order placed at table number= " + tableNum;

	}

	public Double billing(Integer tableNumber) throws BillAlreadyPaidException {
//		Optional<Order> order = orderRepo.findByTableNumber(tableNumber);

		List<Dish> orderedDishes = newOrder.get(tableNumber);

		if (orderedDishes == null) {
			orderRepo.deletePaidTable(tableNumber);
			throw new BillAlreadyPaidException("Bill is already paid by customer...");
		} else {
			double total = 0.0;
			for (Dish dish : orderedDishes) {
				total += dish.getDishPrice();
			}
			
			System.out.println("-------------------+"+total);
			orderRepo.modifiedPayment(true , tableNumber);
			
			newOrder.remove(tableNumber);
			
			orderRepo.deletePaidTable(tableNumber);
			System.out.println("bill paid successfully............");
			
			//remove from map
			
			return total;
		}
	}
}

//if (currOrder != null && dish != null) {
//	currOrder.getDishes().add(dish);
//
//} else {
//	Order order = new Order();
//	order.setTableNumber(tableNum);
//	order.setDishes(new ArrayList<Dish>());
//	orderRepo.save(order);
//}
