package com.neo.dto;

import java.util.List;

import com.neo.model.Dish;

public class OrderRequest {
	
	private Integer tableNumber;

	private List<Dish> dishes;

	public Integer getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(Integer tableNumber) {
		this.tableNumber = tableNumber;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	
	
	
}
