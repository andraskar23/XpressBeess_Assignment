package com.neo.mongodb.enitity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Review {
	
	@Id
	private String  review_Id;
	
	private Integer ratings;
	
	private String comment;
	
}
