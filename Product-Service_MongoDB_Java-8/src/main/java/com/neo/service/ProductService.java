package com.neo.service;

import java.util.List;

import com.neo.dto.ProductRequest;
import com.neo.dto.ProductResponse;
import com.neo.model.Product;

public interface ProductService {

    List<Product> readProduct();
   String saveProduct(ProductRequest productRequest);

   String modifyProduct(String id,ProductRequest productRequest);

   String removeProduct(String id );

   ProductResponse readProductById(String id);


   ProductResponse getProductByName(String pname);
}
