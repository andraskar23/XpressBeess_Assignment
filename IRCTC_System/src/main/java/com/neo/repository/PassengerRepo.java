package com.neo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neo.dto.FoodOrderDto;
import com.neo.entity.FoodOrder;
import com.neo.entity.Passenger;

public interface PassengerRepo extends JpaRepository<Passenger, String> {

//	Find total No of female passengers of age between X and Y(X < = Y) who
//	ended their destination at city C.
	@Query(value = "select * from passengers where train_id in (Select train_no from trains where destination = :destination) and gender = :gender and age between :agefrom and :ageto", nativeQuery = true)
	List<Passenger> listOfGenderPassengerAgeBetweenXAndY(@Param("destination") String destination,
			@Param("gender") String gender, @Param("agefrom") Integer ageFrom, @Param("ageto") Integer ageTo);

	// Get the total price of the orders placed by passengers on Date D in TrainId
	// T.

//	@Query(value = "SELECT fo.* FROM food_orders fo WHERE fo.passenger_id IN (SELECT p.ticket_id FROM passengers p WHERE p.date = :odate AND p.train_id = :trainid)",
//	    nativeQuery = true)
//	List<FoodOrder> getAllFoodOrderByDateAndTrainId(@Param("odate") LocalDate date, @Param("trainid") Integer trainId);

//	@Query(value = "select order_id, passenger_id from food_orders where passenger_id In(select ticket_id from passengers where date = :odate and train_id = :trainid)",nativeQuery = true)
//	List<FoodOrderDto> getAllFoodOrderByDateAndTrainId(@Param("odate") LocalDate date, @Param("trainid") Integer trainId);

//	@Query(value = "SELECT fo.* FROM food_orders fo JOIN passengers p ON fo.passenger_id = p.ticket_id WHERE p.date = :odate AND p.train_id = :trainid" , nativeQuery = true)
//	List<FoodOrder> getAllFoodOrderByDateAndTrainId(@Param("odate") LocalDate date, @Param("trainid") Integer trainId);

	@Query(value = "SELECT order_id, passenger_id FROM food_orders WHERE passenger_id IN ("
			+ "SELECT ticket_id FROM passengers WHERE date = :odate AND train_id = :trainid)", nativeQuery = true)
	List<Object[]> getAllFoodOrderByDateAndTrainId(@Param("odate") LocalDate date, @Param("trainid") Integer trainId);

}
