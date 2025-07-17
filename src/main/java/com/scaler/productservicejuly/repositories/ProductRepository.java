package com.scaler.productservicejuly.repositories;

import com.scaler.productservicejuly.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //Product Repo should contain all the methods (CRUD) related to product model.
    List<Product> findByPriceGreaterThan(Double Price);


    List<Product> findProductByTitleLike(String word); // Case sensitive

    List<Product> findByTitleIgnoreCase(String word); // Case Insensitive

//    List<Product> findTopByTitleContains(String word, Limit top);

    List<Product> findProductByTitleContainsAndPriceGreaterThan(String word, double price);



    Optional<Product> findById(Long id);


    @Override
    List<Product> findAll(Sort sort);


}
//
//1. Repository should always be an interface.
//2. Repos itory should always extend JpaRepository