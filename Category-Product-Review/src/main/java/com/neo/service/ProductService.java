package com.neo.service;

import java.util.List;

import com.neo.dto.ApiResponse;
import com.neo.dto.ProductRequest;
import com.neo.entity.Product;

public interface ProductService {
	
	public List<Product> getAllProduct();

	
	public Product findProductById(int id);

	public Product addProduct(ProductRequest productRequest);

	public Product editProductById(int id, Product product);

	
	public ApiResponse deleteById(int id);

	
	public List<Product> paginatedProduct(int pageindex, int elements);


	public List<Product> paginatedSortedProduct(int pageindex, int elements);
}
