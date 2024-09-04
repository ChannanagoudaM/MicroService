package com.example.OrderService.Config;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Books {

    private String bookName;
    private String authorName;
    private double price;
}
