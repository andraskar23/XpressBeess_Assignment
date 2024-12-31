package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.entity.Train;
import com.neo.exception.TrainNotFoundException;
import com.neo.service.TrainService;

@RestController
@RequestMapping("/train")
public class TrainController {
	
	@Autowired
	private TrainService trainService;
	
	@PostMapping("/addtrain")
	public ResponseEntity<?> addtrain(@RequestBody Train train) {
		return new ResponseEntity<>(trainService.addTrain(train).toString(),HttpStatus.CREATED);
	}
	
	@GetMapping("/getalltrains")
	public ResponseEntity<?> getAllTrains(){
		return new ResponseEntity<>(trainService.getAllTrains(),HttpStatus.OK);
	}

}
