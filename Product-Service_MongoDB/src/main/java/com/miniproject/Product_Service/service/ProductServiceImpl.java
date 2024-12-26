package com.miniproject.Product_Service.service;

import com.miniproject.Product_Service.model.Product;
import com.miniproject.Product_Service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;


    @Override
    public List<Product> readProduct() {
       List<Product> productList =  productRepository.findAll();
        return productList;
    }

    @Override
    public String saveProduct(Product product) {
              productRepository.save(product);
        return product.toString();
    }

    @Override
    public String modifyProduct(String id, Product product) {

        
        Optional<Product> prod = productRepository.findById(id);
        if(!prod.isEmpty()) {
        	Product currProd = prod.get();
        	currProd.setId(id);
        	currProd.setPrice(product.getPrice());
        	currProd.setName(product.getName());
        	currProd.setDescription(product.getDescription());
            productRepository.save(currProd);
            return "Product Modified Successfully = "+ currProd.toString();
        }
        else {
            productRepository.save(product);
        }

        return "New Product Inserted = "+ product.toString();
    }

    @Override
    public String removeProduct(String id) {

        Optional<Product> prod = productRepository.findById(id);

        if(!prod.isEmpty())
        {
            productRepository.deleteById(id);
            
            return "Product deleted -> Id = "+ id;
        }
		return "Product is not available";

    }

    @Override
    public String readProductById(String id){
        Optional<Product> prod = productRepository.findById(id);
        if(!prod.isEmpty())
        {
            return prod.get().toString();
        }

        return "Product Not Found";
    }

    @Override
    public String getProductByName(String pname) {
        Product p = new Product();
        p.setName(pname);

        Example<Product> of = Example.of(p);
//       List<Product> list =  productRepository.findAll(of);
//
//       return list.toString();

       Optional<Product> pr =  productRepository.findOne(of);
        return pr.get().toString();

    }



}
