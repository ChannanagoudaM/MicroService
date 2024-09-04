package com.example.OrderService.OpenFeign;


import com.example.OrderService.Config.Buyers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "MICROSERVICESEXAMPLE")
public interface FeignInterfaceBuyers {

    @GetMapping("/buyers/getbuyerbyname/{buyerName}")
    public ResponseEntity<Buyers> getBuyerByName(@PathVariable String buyerName);

    @PostMapping("/buyers/addbuyer")
    public ResponseEntity<Buyers> addBuyer(@RequestBody Buyers buyer);
}
