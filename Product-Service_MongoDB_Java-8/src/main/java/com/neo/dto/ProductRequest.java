package com.neo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {


    private String name;
    private String description;
    private Double price;
    private String customerFName;
    private String customerLName;
    private String mobileNumber;  
    private String city;
}