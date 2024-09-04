package com.example.OrderService.Config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Buyers {

    private Integer buyerId;
    private String buyerName;
    private String buyerEmail;
}
