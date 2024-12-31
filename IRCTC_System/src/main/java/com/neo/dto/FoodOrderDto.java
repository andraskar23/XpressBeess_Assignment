package com.neo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodOrderDto {
	
	private Integer orderId;
	private String passengerId;

}
