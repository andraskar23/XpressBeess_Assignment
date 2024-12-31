package com.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.dto.PassengerFilterDto;
import com.neo.dto.PassengerRequest;
import com.neo.dto.SpecificPassengerTrainDto;
import com.neo.dto.TotalOrderOfPassengerRequest;
import com.neo.entity.Passenger;
import com.neo.exception.TrainNotFoundException;
import com.neo.service.PassengerService;


@RestController
@RequestMapping("/passenger")
public class PassengerController {

	@Autowired
	private PassengerService passengerService;

	@PostMapping("/addpassenger")
	public ResponseEntity<?> addPassenger(@RequestBody PassengerRequest passengerRequest)
			throws TrainNotFoundException {
		return new ResponseEntity<>(passengerService.addPassenger(passengerRequest), HttpStatus.CREATED);
	}

	@GetMapping("/getspecificlist")
	public ResponseEntity<?> getSpecificList(@RequestBody SpecificPassengerTrainDto dto) throws TrainNotFoundException {
		return new ResponseEntity<>(passengerService.getSpecificList(dto), HttpStatus.OK);
	}

	@GetMapping("/getspecificrecords")
	public ResponseEntity<?> getListOfGenderAgeFromXandY(@RequestBody PassengerFilterDto passengerFilterDto) {
		List<Passenger> passengers = passengerService.listOfGenderAgeFromXandY(passengerFilterDto.getDestination(), passengerFilterDto.getGender(), passengerFilterDto.getAgeFrom(), passengerFilterDto.getAgeTo());
		return new ResponseEntity<>(passengers , HttpStatus.OK);
	}
	
//	@GetMapping("/totalpriceoffood")
//	public ResponseEntity<?> getTotalOfPassenger(@RequestBody TotalOrderOfPassengerRequest orderOfPassengerRequest)
//	{
//		return new ResponseEntity<>(passengerService.getTotalOfPassenger(orderOfPassengerRequest),HttpStatus.OK);
//	}
	
}
