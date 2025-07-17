package com.scaler.productservicejuly.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Product extends BaseModel {
    private String title;
    private Double price;

    @ManyToOne
    private Category category;


//    public Category getcategory() { this is a method for getcategory() in selfproductservice
//        return category;            instead when we use getCategory() it uses the above pvt method
//    }
}
