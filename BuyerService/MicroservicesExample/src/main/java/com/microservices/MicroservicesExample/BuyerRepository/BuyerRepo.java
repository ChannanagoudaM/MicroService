package com.microservices.MicroservicesExample.BuyerRepository;

import com.microservices.MicroservicesExample.BuyerEntity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepo extends JpaRepository<Buyer,Integer> {

    Buyer findByBuyerName(String buyerName);
}
