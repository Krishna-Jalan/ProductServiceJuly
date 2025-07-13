package com.scaler.productservicejuly.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String Title;
    private double price;

    @ManyToOne
    private Category category;



}
