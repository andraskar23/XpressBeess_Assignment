package com.neo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderRquest {
	
//	private Integer trainId;
	
	private String ticketId;
	
	private String foodName;

}
