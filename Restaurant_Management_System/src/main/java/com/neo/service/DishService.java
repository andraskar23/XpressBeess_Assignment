package com.neo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.neo.dto.DishResponse;
import com.neo.exception.DishAlreadyExistException;
import com.neo.model.Dish;
import com.neo.repo.DishRepo;


@Service
public class DishService {

	@Autowired
	private DishRepo dishRepo;
	
	
	public Dish addDish(Dish dish) {

		if (dishRepo.findByDishName(dish.getDishName()) != null) {
			new DishAlreadyExistException("Dish Already exist");
			
		}
		return dishRepo.save(dish);

	}
	

	public List<DishResponse> getAllDishes(){
		List<Dish> list =  dishRepo.findAll();
		List<DishResponse> dishList= new ArrayList<DishResponse>();
		for (Dish dish : list) {
			DishResponse newDish = new DishResponse();
			newDish.setDishId(dish.getDishId());
			newDish.setDishName(dish.getDishName());
			newDish.setDishPrice(dish.getDishPrice());
			
			dishList.add(newDish);			
		}
		return dishList;
		
	}
	

}
