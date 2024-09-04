package com.example.OrderService.OrdersException;


public class BookNotFoundException extends RuntimeException {

    String message;

    public  BookNotFoundException(String message)
    {
        super(message);
    }
}
