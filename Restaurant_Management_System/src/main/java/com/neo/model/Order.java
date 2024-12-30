package com.neo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name ="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	private Integer tableNumber;
	
	private Boolean payment = false;
	
	@OneToMany
	private List<Dish> dishes;

	public Order(Integer tableNum) {
		this.tableNumber = tableNum;
		// TODO Auto-generated constructor stub
	}

	
	public Order() {
		super();
	}


	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

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

	
	public Boolean getPayment() {
		return payment;
	}


	public void setPayment(Boolean payment) {
		this.payment = payment;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", tableNumber=" + tableNumber + ", payment=" + payment + ", dishes="
				+ dishes + "]";
	}

	
	
}
