package com.scaler.productservicejuly.services;

import com.scaler.productservicejuly.dtos.FakeStoreProductDto;
import com.scaler.productservicejuly.exceptions.ProductNotFoundException;
import com.scaler.productservicejuly.models.Category;
import com.scaler.productservicejuly.models.Product;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

// We can use @Controller or @Component as well in place of service
@Service("FakeStoreProductService")
// @Primary
public class FakeStoreProductService implements ProductService{
        private RestTemplate restTemplate;

        public FakeStoreProductService(RestTemplate restTemplate) {
            this.restTemplate = restTemplate;
        }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
    //        throw new RuntimeException("Something Went Wrong");
        //Call FakeStore to fetch the Product with given id. ==> HTTP Call.
        // throw new ArithmeticException();

        FakeStoreProductDto fakeStoreProductDto  = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + productId,
                FakeStoreProductDto.class
        );

        if(fakeStoreProductDto == null) {
        throw new ProductNotFoundException("Product with id" + productId + "doesn't exist");
        }



        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
                    "https://fakestoreapi.com/products",
                    FakeStoreProductDto[].class
            );
            //Convert List of FakeStoreProductDto into list of List of Product.
        List<Product> products = new ArrayList<>();
         for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos)
             products.add(convertFakeStoreProductToProduct(fakeStoreProductDto));

        return products;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        //PUT
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreProductDto.class);
        HttpMessageConverterExtractor<FakeStoreProductDto> responseExtractor = new HttpMessageConverterExtractor(FakeStoreProductDto.class,
                restTemplate.getMessageConverters());
        FakeStoreProductDto response = restTemplate.execute("https://fakestoreapi.com/products/" + id,
                HttpMethod.PATCH, requestCallback, responseExtractor);

        return convertFakeStoreProductToProduct(response);
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public Product addNewProduct(Product product) {
        return null;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());

        Category category = new Category();
        category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
        }
}
