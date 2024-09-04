package com.microservices.MicroservicesExample.BuyerException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalBuyerExceptionHandler {

    @ExceptionHandler(BuyerNotFoundException.class)
    public ResponseEntity<?> handleException(BuyerNotFoundException exception)
    {
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

}
