package com.neo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.dto.ApiResponse;
import com.neo.dto.ProductRequest;
import com.neo.entity.Product;
import com.neo.globalexceptionhandler.StatusCodeException;
import com.neo.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
//	@GetMapping("/statuscodeexception/{id}")
//	public ResponseEntity<?> getAllProducts(@PathVariable int id, @RequestHeader(value = "User-Agent") String userAgent) throws StatusCodeException  {
//		System.out.println("User Agent ->"+userAgent);
//		if(id==0) {
//				throw new StatusCodeException("Input is 0");
//		}else {
//			return ResponseEntity.status(HttpStatus.OK).body("working fine");
//			
//		}		
//	}

	
	@GetMapping("/get-all-products")
	public ResponseEntity<?> getAllProducts() {
		List<Product> allProduct = productService.getAllProduct();
		if (allProduct.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Error in getting Products"));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(allProduct);
		}
	}

	@GetMapping("/get-product-by-id/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable int id) {
		Product findProductById = productService.findProductById(id);

		if (findProductById == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(findProductById);
		}
	}

	@PostMapping("/add-product")
	public ResponseEntity<?> addProduct(@RequestBody  ProductRequest productRequest) {
		Product productSaved = productService.addProduct(productRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
	}

	@PutMapping("/edit-product-by-id/{pid}")
	public ResponseEntity<?> editProductById(@PathVariable(value = "pid") int id, @RequestBody Product product) {
		Product findProductById = productService.editProductById(id, product);
		if (findProductById == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponse("Error While Editing Product"));
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(findProductById);
		}
	}

	@DeleteMapping("/delete-product-by-pid/{id}")
	public ResponseEntity<ApiResponse> deleteProductById(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.deleteById(id));
	}
}
