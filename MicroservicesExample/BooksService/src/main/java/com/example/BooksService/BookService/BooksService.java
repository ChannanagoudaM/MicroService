package com.example.BooksService.BookService;


import com.example.BooksService.BookEntity.Books;
import com.example.BooksService.BooksRepo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {

    @Autowired
    private BooksRepo booksRepo;

    public Books addBooks(Books books)
    {
        return booksRepo.save(books);
    }

    public Optional<Books> getBook(Integer bookId)
    {
        return booksRepo.findById(bookId);
    }

    public Books getBookByName(String bookName)
    {
        return booksRepo.findByBookName(bookName);
    }

    public List<Books> findAll()
    {
        return booksRepo.findAll();
    }

    public void deleteById(Integer bookId)
    {
        booksRepo.deleteById(bookId);
    }


    public void deleteAll()
    {
        booksRepo.deleteAll();
    }



}
