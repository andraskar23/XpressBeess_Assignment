package com.miniproject.Product_Service.service;

import com.miniproject.Product_Service.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> readProduct();
   String saveProduct(Product product);

   String modifyProduct(String id,Product product);

   String removeProduct(String id );

    String readProductById(String id);


    String getProductByName(String pname);
}
