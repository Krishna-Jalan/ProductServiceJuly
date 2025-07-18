package com.scaler.productservicejuly.repositories;

import com.scaler.productservicejuly.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
Category save(Category category);

}
