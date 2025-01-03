package com.neo.mongodb.enitity;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Builder
@Document(collection = "product")
public class Product {
	
	@Id
	@Field(name = "_id")
	@JsonProperty(access = Access.READ_ONLY)
	private String productId;
	private String productName;
	private Double price;
	
	private List<Review> reviews;

	
}
//@JsonProperty(access = Access.READ_ONLY)
//@JsonIgnore if eager fetch to avoid the lazy initialization error



