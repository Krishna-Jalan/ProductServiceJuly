package com.scaler.productservicejuly.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto { // dto --> data transfer object, obj that u will be using to transfer data
    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;

}
