package com.neo.mongodb.enitity;


import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Builder
@Getter
@Setter
public class Review {
	
	
	private String  reviewId;
	
	private Integer ratings;
	
	private String comment;
	
}
