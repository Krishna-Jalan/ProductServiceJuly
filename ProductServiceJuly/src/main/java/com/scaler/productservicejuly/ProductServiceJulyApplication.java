package com.scaler.productservicejuly;

import com.scaler.productservicejuly.models.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  ProductServiceJulyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceJulyApplication.class, args);

        Product product = new Product();
        product.setTitle("iPhone 15 Pro");

    }

}
