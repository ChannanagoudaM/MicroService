package com.example.OrderService.OpenFeign;

import com.example.OrderService.Config.Books;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "BOOKSSERVICE")
public interface FeignInterface {


    @GetMapping("/books/getbookbyname/{bookName}")
    public ResponseEntity<Books> getBookByName(@PathVariable String bookName);


    @PostMapping("/books/addbook")
    public ResponseEntity<Books> addBooksFeign(@RequestBody Books books);

}
