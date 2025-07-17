package com.scaler.productservicejuly.repositories;

import com.scaler.productservicejuly.models.Product;
import com.scaler.productservicejuly.projections.ProductWithIdAndTitle;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    //HQL
    @Query("SELECT p.id as id, p.title as title from Product p where p.id = :x")
    // x here is an input parameter to fetch data related to the imput id
    List<ProductWithIdAndTitle> randomSearchMethod(Long x); // Here we are fetching just two attributes id and title whereas a product could have 100's
// attributes but in that scenario 98 other attb. might be null cuz we are not even fetching them
// so a product object for randomSearchMethod doesn't seem like a good approach in that case we
// use the concept of projections:- Sample objects or models which we use to get the o/p from the
// hibernate language

    //SQL
    @Query
            (value = "select p.id as id, p.title as title from Product p where p.id = :productId")
    List<ProductWithIdAndTitle> randomSearchMethod2(Long productId);
}
//
//1. Repository should always be an interface.
//2. Repository should always extend JpaRepository