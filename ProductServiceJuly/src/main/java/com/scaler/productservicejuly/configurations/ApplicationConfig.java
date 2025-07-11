package com.scaler.productservicejuly.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration // This annotation means that spring will have to go to that class and execute all the bean methods
public class ApplicationConfig {
    @Bean
    public RestTemplate getRestTemplate() { // getRestTemplate is a var so it can be named anything
        return new RestTemplate();
    }
}
