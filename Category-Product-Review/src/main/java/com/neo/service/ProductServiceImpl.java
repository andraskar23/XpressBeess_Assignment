package com.neo.service;

import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.neo.dto.ApiResponse;
import com.neo.dto.ProductRequest;
import com.neo.entity.Product;
import com.neo.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private ModelMapper mapper;

	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product findProductById(int id) {
		Product product = productRepo.findById(id).orElse(null);
		return product;
	}

	@Override
	public Product editProductById(int id, Product product) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		if (optionalProduct.isPresent()) {
			Product productRevived = optionalProduct.get();
			productRevived.setName(product.getName());
			productRevived.setPrice(product.getPrice());
			productRepo.save(productRevived);
			return productRevived;

		} else {
			return null;
		}

	}

	@Override
	public ApiResponse deleteById(int id) {

		if (productRepo.findById(id).isPresent()) {
			productRepo.deleteById(id);
			return new ApiResponse("Product with id " + id + " Deleted");
		} else {
			return new ApiResponse("Error while deleting product");
		}
	}

	@Override
	public List<Product> paginatedProduct(int pageindex, int elements) {
		PageRequest pagingCriteria = PageRequest.of(pageindex, elements);
		Page<Product> findAllbyPaging = productRepo.findAll(pagingCriteria);
		return findAllbyPaging.getContent();

	}

	@Override
	public List<Product> paginatedSortedProduct(int pageindex, int elements) {
		PageRequest pagingCriteria = PageRequest.of(pageindex, elements, Sort.by("price").descending());
		Page<Product> findAllbyPaging = productRepo.findAll(pagingCriteria);
		return findAllbyPaging.getContent();
	}

	@Override
	public Product addProduct(ProductRequest productRequest) {
		log.info("********* ProductDto Received ->{} ", productRequest.toString());
		Product validProduct = mapper.map(productRequest, Product.class);
		log.info("********* Valid Project Object,will be saved ->{} ", validProduct.toString());
		//return validProduct;
		Product savedProduct = productRepo.save(validProduct);
		return savedProduct;
	}

	/*
	 * Hibernate Fetch Behaviour
	 * 
	 * @Override public Product findProductById(int id) { Product product =
	 * productRepo.findById(id).orElse(null); System.out.println(
	 * product.getName()); System.out.println("waiting session to close"); try {
	 * Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
	 * System.out.println(" session to closed"); return product; }
	 */

}
