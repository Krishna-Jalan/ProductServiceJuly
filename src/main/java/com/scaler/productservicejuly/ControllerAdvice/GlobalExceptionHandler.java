package com.scaler.productservicejuly.ControllerAdvice;

import com.scaler.productservicejuly.dtos.ExceptionDto;
import com.scaler.productservicejuly.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Arithmetic exception has happened");
        exceptionDto.setSolution("I don't know, please try again");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
        return response;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<String> handleArrayIndexOutOfBoundsException() {

        ResponseEntity<String> response = new ResponseEntity<>(
                "ArrayIndexOutOfBoundsException has occured, Inside the controllerAdvice",
                HttpStatus.BAD_REQUEST
        );
        return response;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Product Not Found");
        exceptionDto.setSolution("Please try again with a valid Product Id");

        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                exceptionDto,
                HttpStatus.BAD_REQUEST
        );
        return response;
    }
}
