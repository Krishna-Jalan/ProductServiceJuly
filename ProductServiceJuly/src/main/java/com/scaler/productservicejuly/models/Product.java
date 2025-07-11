package com.scaler.productservicejuly.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel {
    private String Title;
    private double price;
    private Category category;



}
