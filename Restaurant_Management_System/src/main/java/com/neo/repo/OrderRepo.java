package com.neo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.neo.model.Order;

import jakarta.transaction.Transactional;

public interface OrderRepo extends JpaRepository<Order, Integer>{

	
	public Optional<Order> findByTableNumber(Integer tableNumber);
	
	
//	@Modifying
//	@Query("UPDATE Order o SET o.payment = :payment WHERE o.tableNumber = :tableNum")
//	public void modifiedPayment(@Param("payment") Boolean payment, @Param("tableNum") Integer tableNum);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE orders SET payment = :payment WHERE table_number = :tableNum", nativeQuery = true)
	public void modifiedPayment(@Param("payment") Boolean payment, @Param("tableNum") Integer tableNum);


	@Transactional
	@Modifying
	@Query(value = "DELETE FROM orders WHERE table_number = :tableNum", nativeQuery = true)
	public void deletePaidTable(@Param("tableNum") Integer tableNum);
	
}

//update orders
//set payment = 0
//where table_number = 1;