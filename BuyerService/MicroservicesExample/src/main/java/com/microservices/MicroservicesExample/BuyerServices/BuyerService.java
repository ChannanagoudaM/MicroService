package com.microservices.MicroservicesExample.BuyerServices;

import com.microservices.MicroservicesExample.BuyerEntity.Buyer;
import com.microservices.MicroservicesExample.BuyerRepository.BuyerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuyerService {

    @Autowired
    private BuyerRepo buyerRepo;

    public Buyer addBuyer(Buyer buyer)
    {
        return buyerRepo.save(buyer);
    }

    public Optional<Buyer> getBuyerById(Integer buyerId)
    {
        return buyerRepo.findById(buyerId);
    }

    public Buyer getBuyerByName(String buyerName)
    {
        return buyerRepo.findByBuyerName(buyerName);
    }

    public List<Buyer> getAll()
    {
       return buyerRepo.findAll();
    }

    public void deleteBuyerById(Integer buyerId)
    {
        buyerRepo.deleteById(buyerId);
    }
}
