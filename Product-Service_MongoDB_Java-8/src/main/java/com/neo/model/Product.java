package com.neo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "products")
@Builder
@ToString
public class Product {

    @Id
    private String id;
   // private Integer productId;
    private String name;
    private String description;
    private Double price;



}
