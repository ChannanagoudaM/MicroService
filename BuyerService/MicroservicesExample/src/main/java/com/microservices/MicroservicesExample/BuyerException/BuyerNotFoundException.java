package com.microservices.MicroservicesExample.BuyerException;

public class BuyerNotFoundException extends RuntimeException{

    String message;
    public BuyerNotFoundException(String message)
    {
        super(message);
    }
}
