package com.neo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neo.entity.Food;

public interface FoodRepo extends JpaRepository<Food, Integer> {
	
	@Query(value = "Select * from foods where food_name = :foodname", nativeQuery = true)
	Optional<Food> findByFoodName(@Param("foodname")String foodName);

}
