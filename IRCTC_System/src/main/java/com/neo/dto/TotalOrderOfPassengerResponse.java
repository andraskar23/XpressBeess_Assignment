package com.neo.dto;

import java.util.List;

import com.neo.entity.Food;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TotalOrderOfPassengerResponse {

	private double totalBillOfOrder;

	private List<Food> foods;

}
