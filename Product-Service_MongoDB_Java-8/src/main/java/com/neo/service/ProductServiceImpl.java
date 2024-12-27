package com.neo.service;

import com.neo.dto.ProductRequest;
import com.neo.dto.ProductResponse;
import com.neo.exception.ProductNotFoundException;
import com.neo.model.Product;
import com.neo.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public List<Product> readProduct() {
		List<Product> productList = productRepository.findAll();
		return productList;
	}

	@Override
	public String saveProduct(ProductRequest productRequest) {
		Product product1 = Product.builder()
								  .name(productRequest
								   .getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice()).build();
		productRepository.save(product1);

		log.info("Product Save Successfully = {}", product1);
		return product1.toString();
	}

	@Override
	public String modifyProduct(String id, ProductRequest productRequest) {

		 Optional<Product> prod = productRepository.findById(id);
	        Product prod1 = prod.get();
	        if(prod1 != null)
	        {
	           prod1.setDescription(productRequest.getDescription());
	           prod1.setName(productRequest.getName());
	           prod1.setPrice(productRequest.getPrice());

	            productRepository.save(prod1);
	            return "Product Modified Successfully";
	        }
	        else {
	            throw new ProductNotFoundException("Product {} cannot be modified"+id);
	        }
	}

	@Override
	public String removeProduct(String id) {

	     Optional<Product> prod = productRepository.findById(id);

	        if(!prod.isEmpty())
	        {
	            productRepository.deleteById(id);
	            log.info("Product {} Removed Successfully", id);
	            return "Product id "+ id + " Deleted Successfully";
	        }
	        else {
	            throw new ProductNotFoundException("Product {} Not Found"+id);
	        }
	    }

	@Override
	public ProductResponse readProductById(String id) {
		Optional<Product> prod = productRepository.findById(id);
        ProductResponse productResponse;
        if (prod.isEmpty()) {
            throw new ProductNotFoundException("Product {} Not Found"+id);
        } else {
            productResponse = (ProductResponse) prod.stream()
                    .map(this::mapToProductResponse);
        }
        return productResponse;
    }

	@Override
	public ProductResponse getProductByName(String pname) {
		Product p = new Product();
		p.setName(pname);

		Example<Product> of = Example.of(p);
//       List<Product> list =  productRepository.findAll(of);
//
//       return list.toString();

		Optional<Product> pr = productRepository.findOne(of);
		if(pr.isPresent()) {			
			return(ProductResponse) pr.stream().map(this :: mapToProductResponse);
		}
		else {
			throw new ProductNotFoundException("Product {} Not Found with name "+pname);
		}

	}
	
    private ProductResponse mapToProductResponse(Product obj)
    {
        ProductResponse productResponse = ProductResponse.builder()
                .id(obj.getId())
                .name(obj.getName())
                .description(obj.getDescription())
                .price(obj.getPrice())
                .build();

        return productResponse;
    }

}
