package com.neo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "Trains")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trainNo;
	private String source;
	private String destination;
		
	@Exclude
//	@OneToMany(mappedBy = "train" , orphanRemoval = true)
	@OneToMany(mappedBy = "train")
//	@JsonManagedReference //if we use @JsoinBackReference
	private List<Passenger> passengers;
	
	
	@Exclude
	@OneToMany(mappedBy = "train")
	private List<FoodOrder> foodOrder;
}
