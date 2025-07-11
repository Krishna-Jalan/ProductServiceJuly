package com.scaler.productservicejuly.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//This class will be hosting a set of HTTP API's
@RestController   //Allows you to write HTTP API's
@RequestMapping("/say")
public class SampleController {

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String xyz) {
        return "Hello" + xyz;
    }

    @GetMapping("/bye")
    public String sayBye() {
        return "Bye Everyone!";
    }

}
/*

 https://localhost:8080/say/hello
 */