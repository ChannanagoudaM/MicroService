package com.microservices.MicroservicesExample.BuyersController;

import com.microservices.MicroservicesExample.BuyerEntity.Buyer;
import com.microservices.MicroservicesExample.BuyerException.BuyerNotFoundException;
import com.microservices.MicroservicesExample.BuyerServices.BuyerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/buyers")
@Slf4j
public class BuyerController {


    @Autowired
    private BuyerService buyerService;

    @PostMapping("/addbuyer")
    public ResponseEntity<Buyer> addBuyer(@RequestBody Buyer buyer)
    {

     return ResponseEntity.ok(buyerService.addBuyer(buyer));
    }

    @GetMapping("/getbuyer/{buyerId}")
    public ResponseEntity<?> getBuyerById(@PathVariable Integer buyerId)
    {
        Optional<Buyer> buyer=buyerService.getBuyerById(buyerId);
        if(buyer.isEmpty())
        {
            throw new BuyerNotFoundException("Buyer not found with the Id "+buyerId);
        }
        return ResponseEntity.ok(buyer);
    }

    @GetMapping("/getbuyerbyname/{buyerName}")
    public ResponseEntity<Buyer> getBuyerByName(@PathVariable String buyerName)
    {
        Buyer buyer=buyerService.getBuyerByName(buyerName);
        if(buyer!=null)
        {
            return ResponseEntity.ok(buyer);
        }

        throw new BuyerNotFoundException("Buyer Not Found ");

    }

    @DeleteMapping("/deletebuyer/{buyerId}")
    public ResponseEntity<?> deleteBuyerById(@PathVariable Integer buyerId)
    {
        buyerService.deleteBuyerById(buyerId);
        return ResponseEntity.ok("Buyer deleted");
    }

    @GetMapping("/getallbuyer")
    public ResponseEntity<List<Buyer>> getAll()
    {
        return ResponseEntity.ok(buyerService.getAll());
    }
}
