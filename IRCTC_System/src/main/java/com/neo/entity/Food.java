package com.neo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Foods")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer foodId;
	
	
	@NotBlank(message = "Must provide dish name")
	private String foodName;
	
	@Positive(message = "provide positive value")
	private Double foodPrice;
	
	@JsonIgnore
	@Exclude
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "food_order_id")
	private FoodOrder foodOrder;
}


