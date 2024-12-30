package com.neo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name ="dishes")
public class Dish {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dishId;
	
	
	@NotBlank(message = "Must provide dish name")
	private String dishName;
	
	@Positive(message = "provide positive value")
	private Double dishPrice;
	
	
		

	public Dish() {
		super();
	}

	public Dish(String dishName2) {
		// TODO Auto-generated constructor stub
		
		this.dishName = dishName2;
	}

	public Integer getDishId() {
		return dishId;
	}

	public void setDishId(Integer dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public Double getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(Double dishPrice) {
		this.dishPrice = dishPrice;
	}
	

	@Override
	public String toString() {
		return "Dish [dishId=" + dishId + ", dishName=" + dishName + ", dishPrice=" + dishPrice + "]";
	}
	
	

}
