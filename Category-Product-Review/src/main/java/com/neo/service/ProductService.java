package com.neo.service;

import java.util.List;

import com.neo.dto.ApiResponse;
import com.neo.dto.ProductRequest;
import com.neo.entity.Product;

public interface ProductService {
	/**
	 * @return list of all products
	 */
	public List<Product> getAllProduct();

	/**
	 * @param id Id of product
	 * @return product for given id if found, else null
	 */
	public Product findProductById(int id);

	/**
	 * @param product to be added
	 * @return saved product if saved successful else null
	 */
	public Product addProduct(ProductRequest productRequest);

	/**
	 * @param id      id of Product to be edited
	 * @param product
	 * @return edited product if edited successful
	 */
	public Product editProductById(int id, Product product);

	/**
	 * @param id id on product to be deleted
	 */
	public ApiResponse deleteById(int id);

	/**
	 * @param pageindex page index start from 0
	 * @param pageno    page no
	 * @return
	 */
	public List<Product> paginatedProduct(int pageindex, int elements);

	/**
	 * @param pageindex page index start from 0
	 * @param pageno    page no
	 * @return
	 */
	public List<Product> paginatedSortedProduct(int pageindex, int elements);
}
