package com.neo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DishRequest {

	
	private Integer quantity;
	
	@NotNull(message = "dish name must be.............")
	private String dishName;
	
	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuntity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	
	
}
