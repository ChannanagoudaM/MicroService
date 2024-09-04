package com.example.OrderService.OrdersException;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(BuyerNotFoundException.class)
    public ResponseEntity<String> buyerNotFoundException(BuyerNotFoundException exception)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> bookNotFoundException(BuyerNotFoundException exception)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }


}
