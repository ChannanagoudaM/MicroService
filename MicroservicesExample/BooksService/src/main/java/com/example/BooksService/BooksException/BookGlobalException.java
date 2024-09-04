package com.example.BooksService.BooksException;

import com.example.BooksService.BooksException.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookGlobalException {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> bookNotFoundException(BookNotFoundException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

    }
}
