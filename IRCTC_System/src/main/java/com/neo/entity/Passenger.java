package com.neo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "Passengers")
@Builder
//@JsonIgnoreProperties(value = "train")
public class Passenger {
	
	@Id
	private String ticketId;
	
	private String passengerName;
	
//	@CreationTimestamp
	private LocalDate date;
	
	private Integer age;
	
	private String gender;
	
	@ManyToOne
	@JoinColumn(name = "train_id")
	@JsonIgnore
//@JsonBackReference	//if we use @JsonManagedReference 
	private Train train;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "passenger" , cascade = CascadeType.ALL)
	private java.util.List<FoodOrder> foodOrders;
	
	

}


//Train = TrainNo, Source, Destination
//Passenger = TicketId, TrainId ,Date, Age, Gender //one to many
//FoodOrder = TicketId, TrainId, Price // one to many / one to many