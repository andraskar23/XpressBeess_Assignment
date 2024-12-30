package com.neo.controller;


import com.neo.dto.ProductRequest;
import com.neo.model.Product;
import com.neo.service.ProductService;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/read")
    public ResponseEntity<?> readAll()
    {
       return new ResponseEntity<>(productService.readProduct(),HttpStatus.OK);
    }

    @GetMapping("/readbyid/{id}")
    public ResponseEntity<?> readById(@PathVariable("id") String id)
    {
        return new ResponseEntity<>(productService.readProductById(id),HttpStatus.OK);
    }

    @PutMapping("/modifybyid")
    public ResponseEntity<?> modifyByid(@RequestParam("id") String id , @RequestBody ProductRequest productRequest)
    {
        return new ResponseEntity<>(productService.modifyProduct(id,productRequest),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest productRequest)
    {
        return new ResponseEntity<>(productService.saveProduct(productRequest),HttpStatus.OK);
    }

    @DeleteMapping("/deletebyid/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable String id)
    {
        productService.removeProduct(id);
        return new ResponseEntity<>("Delete Product Successfully",HttpStatus.OK);
    }

    @GetMapping("/querybyexample")
    public ResponseEntity<?> getByProductName(@RequestParam("pname") String pname){

        return new ResponseEntity<>(productService.getProductByName(pname),HttpStatus.OK);

    }



}