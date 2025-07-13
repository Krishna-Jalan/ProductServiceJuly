package com.scaler.productservicejuly.controllers;

import com.scaler.productservicejuly.exceptions.ProductNotFoundException;
import com.scaler.productservicejuly.models.Product;
import com.scaler.productservicejuly.services.ProductService;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {

       // throw new RuntimeException("Something went wrong");
//        ResponseEntity<Product> responseEntity = null;
//    try {
//        Product product = productService.getSingleProduct(id);git config --global user.nam
//
//        responseEntity = new ResponseEntity<>(
//                product,
//                HttpStatus.OK
//        );
//    } catch (RuntimeException e) {
//        responseEntity = new ResponseEntity<>(
//                HttpStatus.NOT_FOUND
//        );
//    }
        ResponseEntity<Product> response = new ResponseEntity<>(
                productService.getSingleProduct(id),
                HttpStatus.OK
        );
        return response;
    }
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    public void deleteProduct(Long productId){

    }
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
    return null;
    }
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
    return null;
    }
//    @ExceptionHandler(ArithmeticException.class)
//    public ResponseEntity<String> handleArithmeticException(){
//        ResponseEntity<String> response = new ResponseEntity<>(
//                "ArrayIndexOutOfBoundsException has happened, Inside the controller",
//                HttpStatus.NOT_FOUND
//        );
//
//        return response;
//    }
}
