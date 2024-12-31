package com.neo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neo.entity.Food;
import com.neo.repository.FoodRepo;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepo foodRepo;
	
	 
	
	
//	private Map<String,List<Food>> orderedFood = new HashMap<>();
	
	
	public String addFood(Food food) {
		return foodRepo.save(food).toString();
	}
	
	public List<Food> listOfFood(){
		return foodRepo.findAll();
		
	}
	
	
}
