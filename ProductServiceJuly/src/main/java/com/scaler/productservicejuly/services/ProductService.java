package com.scaler.productservicejuly.services;

import com.scaler.productservicejuly.exceptions.ProductNotFoundException;
import com.scaler.productservicejuly.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService  {
    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product updateProduct(Long id, Product product);

    Product replaceProduct(Long id, Product product);

    void deleteProduct(Long id);
}
