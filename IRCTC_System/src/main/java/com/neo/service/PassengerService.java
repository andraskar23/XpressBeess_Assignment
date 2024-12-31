package com.neo.service;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.neo.dto.FoodOrderDto;
import com.neo.dto.PassengerRequest;
import com.neo.dto.SpecificPassengerTrainDto;
import com.neo.dto.TotalOrderOfPassengerRequest;
import com.neo.dto.TotalOrderOfPassengerResponse;
import com.neo.entity.Food;
import com.neo.entity.FoodOrder;
import com.neo.entity.Passenger;
import com.neo.entity.Train;
import com.neo.exception.TrainNotFoundException;
import com.neo.repository.FoodOrderRepo;
import com.neo.repository.PassengerRepo;
import com.neo.repository.TrainRepo;

@Service
public class PassengerService {

	@Autowired
	private PassengerRepo passengerRepo;
//	
//	@Autowired
//	private UUID uuid;

	@Autowired
	private TrainRepo trainRepo;
	
	@Autowired
	private FoodOrderRepo foodOrderRepo;

//	POST API - Add a Passenger with ticketId , trainId ,Date,age,gender
	public String addPassenger(PassengerRequest passengerRequest) throws TrainNotFoundException {

		Optional<Train> train = trainRepo.findById(passengerRequest.getTrainId());

		if (!train.isPresent()) {

			throw new TrainNotFoundException("Train is not found .....");

		}
		Passenger passenger = Passenger.builder().ticketId(UUID.randomUUID().toString()).age(passengerRequest.getAge())
				.passengerName(passengerRequest.getPassengerName()).date(LocalDate.now())
				.gender(passengerRequest.getGender()).train(train.get()).build();
		passengerRepo.save(passenger);
		return passenger.toString();
	}

//Dynamic Query Creation using Example 

//	Find the Number of passengers travelling from City X To City Y on Date D
	public List<Passenger> getSpecificList(SpecificPassengerTrainDto trainDto) throws TrainNotFoundException {

		List<Passenger> newList = new ArrayList<>();

		List<Train> trains = trainRepo.findBySourceAndDestination(trainDto.getSource(), trainDto.getDestination());

		if (trains.isEmpty()) {
			throw new TrainNotFoundException("train is not found on this source " + trainDto.getSource()
					+ " and Destination " + trainDto.getDestination());
		}

		System.out.println("=================" + trains);

		Passenger passenger = Passenger.builder().date(trainDto.getDate()).build();

		for (Train train : trains) {

			passenger.setTrain(train);

			Example<Passenger> of = Example.of(passenger);

//			List<Passenger> currList =  passengerRepo.findAll(of);

			newList.addAll(passengerRepo.findAll(of));

		}

		return newList;
	}
	
	
	
	public List<Passenger> listOfGenderAgeFromXandY(String destination , String gender , Integer ageFrom , Integer ageTo){
		
		List<Passenger> list = passengerRepo.listOfGenderPassengerAgeBetweenXAndY(destination, gender, ageFrom, ageTo);
		
		if(list.isEmpty()) {
			throw new RuntimeException("No Records found.....");
		}
		return list;
		
	}
	
//	
//	public TotalOrderOfPassengerResponse getTotalOfPassenger(TotalOrderOfPassengerRequest request) {
//		List<FoodOrder> list = passengerRepo.getAllFoodOrderByDateAndTrainId(request.getDate(), request.getTrainId());
//		
//		System.out.println("============="+list);
//		if(list.isEmpty()) {
//			throw new RuntimeException("No Orders found....");
//		}
//		Double total = list.stream()
//				.flatMap(foods -> foods.getFoods().stream())
//				.mapToDouble(foodPrice -> foodPrice.getFoodId())
//				.sum();
//		
//		System.out.println(total+"==================");
//		
//		return TotalOrderOfPassengerResponse.builder()
//				.totalBillOfOrder(total)
//				.foods((List<Food>) list.stream().map(foods -> foods.getFoods()))
//				.build();
//		
//	}  // Not working this API
	

// Working This API	
//	public TotalOrderOfPassengerResponse getTotalOfPassenger(TotalOrderOfPassengerRequest request) {
//	    // Fetch and map food orders
//	    List<FoodOrderDto> list = mapToDTO(passengerRepo.getAllFoodOrderByDateAndTrainId(request.getDate(), request.getTrainId()));
//	    
//	    
//	    if (list.isEmpty()) {
//	        throw new RuntimeException("No Orders found....");
//	    }
//	    List<List<Food>> listFoods = list.stream()
//	    		.map(lst -> foodOrderRepo.findById(lst.getOrderId()).get().getFoods())
//	    		.toList();
//	    
//		Double total = listFoods.stream()
//		.flatMap(foods -> foods.stream())
//		.mapToDouble(foodPrice -> foodPrice.getFoodPrice())
//		.sum();
//
//	    // Return the response
//	    return TotalOrderOfPassengerResponse.builder()
//	            .totalBillOfOrder(total)
//	            .foods(listFoods.stream()
//	            		.flatMap(foods -> foods.stream()).toList()) // Assuming the response accepts DTOs
//	            .build();
//	}

	private List<FoodOrderDto> mapToDTO(List<Object[]> results) {
	    return results.stream()
	            .map(records -> {
	                FoodOrderDto dto = new FoodOrderDto();
	                dto.setOrderId(((Integer) records[0]).intValue()); // Assuming orderId is BigInteger
	                dto.setPassengerId((String) records[1]);              // Assuming passengerId is String
	                // Map other fields here as required
	                return dto; // Return the DTO
	            })
	            .toList(); // Collect to list
	}

	    		
	}

