package com.scaler.productservicejuly.services;

import com.scaler.productservicejuly.exceptions.ProductNotFoundException;
import com.scaler.productservicejuly.models.Category;
import com.scaler.productservicejuly.models.Product;
import com.scaler.productservicejuly.repositories.CategoryRepository;
import com.scaler.productservicejuly.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService{
private ProductRepository productRepository;
private CategoryRepository categoryRepository;

public SelfProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
}
    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        // Make a call to the database to fetch a product with the given ID
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + productId + " doesn't exist.");
        }

        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll() ;
    }

    //Patch method:- Used for making partial updates in resources
    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with id: " + id + "doesn't exist");
        }
        Product productInDB = optionalProduct.get();

        if(product.getTitle() != null) {
            productInDB.setTitle(product.getTitle());
        }

        if(product.getPrice() != null){
            productInDB.setPrice(product.getPrice());
        }

    return productRepository.save(productInDB);
    }

    //PUT method:- Put is typically used for replacing existing resources entirely
    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    //POST method:- Used for creating new resources
    @Override
    public Product addNewProduct(Product product) {

        Category category = product.getCategory();
        if(category.getId() == null){
            // We need to create a new category object in the DB first
            category = categoryRepository.save(category);
            product.setCategory(category);
        }


        return productRepository.save(product);

    }
}
