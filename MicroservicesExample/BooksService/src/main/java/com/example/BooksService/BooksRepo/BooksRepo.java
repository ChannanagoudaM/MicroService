package com.example.BooksService.BooksRepo;

import com.example.BooksService.BookEntity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends JpaRepository<Books,Integer> {

    Books findByBookName(String bookName);
}