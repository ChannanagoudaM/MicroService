package com.example.OrderService.OrdersException;

public class BuyerNotFoundException extends  RuntimeException{

    String message;

    public BuyerNotFoundException(String message)
    {
        super(message);
    }
}
