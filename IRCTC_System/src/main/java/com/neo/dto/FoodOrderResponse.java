package com.neo.dto;

import java.util.List;

import com.neo.entity.Food;
import com.neo.entity.FoodOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodOrderResponse {
	
	private String ticketId;
	
	private List<Food> food;

}
