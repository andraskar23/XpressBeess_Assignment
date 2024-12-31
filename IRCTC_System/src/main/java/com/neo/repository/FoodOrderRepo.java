package com.neo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neo.entity.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer> {
	
	@Query(value = "Select * from food_orders where passenger_id = :ticketId", nativeQuery = true)
	 List<FoodOrder> findByTicketId(@Param("ticketId") String ticketId );

}
