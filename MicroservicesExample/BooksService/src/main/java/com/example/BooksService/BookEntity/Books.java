package com.example.BooksService.BookEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Books {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer bookId;
    private String bookName;
    private String authorName;
    private double price;
}
