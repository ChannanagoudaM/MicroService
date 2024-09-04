package com.example.BooksService.BookController;


import com.example.BooksService.BookEntity.Books;
import com.example.BooksService.BookService.BooksService;
import com.example.BooksService.BooksException.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;


    @PostMapping("/addbook")
    public ResponseEntity<?> addBooks(@RequestBody Books books)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(booksService.addBooks(books));
    }

    @GetMapping("/getbookbyname/{bookName}")
    public ResponseEntity<Books> getBookByName(@PathVariable String bookName)
    {
        return ResponseEntity.status(HttpStatus.FOUND).body(booksService.getBookByName(bookName));
    }

    @GetMapping("/getbook/{bookId}")
    public ResponseEntity<?>getBook(@PathVariable Integer bookId)
    {
        Optional<Books>books =booksService.getBook(bookId);
        if(books.isEmpty())
        {
            throw new BookNotFoundException("Book not found");
        }

        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/deletebook")
    public ResponseEntity<?>deleteBook(@PathVariable Integer bookId)
    {
        booksService.deleteById(bookId);
        return ResponseEntity.ok("Deleted");
    }


    @DeleteMapping("/deleteallbook")
    public ResponseEntity<?> deleteAll()
    {
        booksService.deleteAll();
        return ResponseEntity.ok("All books are deleted");
    }



}
