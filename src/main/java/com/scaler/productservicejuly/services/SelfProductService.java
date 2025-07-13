package com.scaler.productservicejuly.services;

import com.scaler.productservicejuly.exceptions.ProductNotFoundException;
import com.scaler.productservicejuly.models.Product;
import com.scaler.productservicejuly.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelfProductService implements ProductService{
private ProductRepository productRepository;

public SelfProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
}
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        // Make a call to the database to fetch a product with the given ID
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }
}
