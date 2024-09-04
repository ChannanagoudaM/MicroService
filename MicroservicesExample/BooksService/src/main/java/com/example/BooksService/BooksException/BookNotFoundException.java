package com.example.BooksService.BooksException;

public class BookNotFoundException extends RuntimeException{


    String message;
    public BookNotFoundException(String message)
    {
        super(message);
    }
}
