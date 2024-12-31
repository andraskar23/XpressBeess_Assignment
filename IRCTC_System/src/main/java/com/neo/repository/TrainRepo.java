package com.neo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neo.entity.Train;

public interface TrainRepo extends JpaRepository<Train, Integer> {
	
	public List<Train> findBySourceAndDestination(String source,String destination);

}
