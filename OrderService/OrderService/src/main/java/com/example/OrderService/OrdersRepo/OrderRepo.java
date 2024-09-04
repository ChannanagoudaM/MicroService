package com.example.OrderService.OrdersRepo;

import com.example.OrderService.OrdersEntity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Orders,Integer> {
}
