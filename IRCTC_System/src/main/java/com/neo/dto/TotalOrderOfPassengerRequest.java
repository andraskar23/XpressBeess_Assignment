package com.neo.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TotalOrderOfPassengerRequest {
	private LocalDate date;
	
	private Integer trainId;

}
