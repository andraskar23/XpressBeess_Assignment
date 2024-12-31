package com.neo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PassengerRequest {

	private String passengerName;
	
	private Integer age;
	
	private String gender;
	
	private Integer trainId;

}
