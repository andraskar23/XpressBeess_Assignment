package com.neo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerFilterDto {
	
	private String destination;
	
	private String gender;
	
	private Integer ageFrom;
	
	private Integer ageTo;

}
