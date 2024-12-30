package com.neo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neo.model.Dish;

public interface DishRepo extends JpaRepository<Dish, Integer>{

	public Optional<Dish> findByDishName(String dishName);
	
	
//	@Query(value = "select dish_id, dish_name ,dish_price from dishes", nativeQuery = true)
//	public List<Dish> getAllDishes();
	
}
