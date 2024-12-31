package com.neo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpecificPassengerTrainDto {
		
		private String source;
		private String destination;
		private LocalDate date;
	

}
