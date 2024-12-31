package com.neo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.entity.Train;
import com.neo.repository.TrainRepo;

@Service
public class TrainService {

	
	@Autowired
	private TrainRepo trainRepo;
	
	
	public String addTrain(Train train) {
		return trainRepo.save(train).toString();
	}
	
	public List<Train> getAllTrains(){
		return trainRepo.findAll();
	}
}
