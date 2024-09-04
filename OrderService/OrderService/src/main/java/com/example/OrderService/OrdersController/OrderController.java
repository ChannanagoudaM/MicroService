package com.example.OrderService.OrdersController;

import com.example.OrderService.Config.Books;
import com.example.OrderService.Config.Buyers;
import com.example.OrderService.OrdersEntity.Orders;
import com.example.OrderService.OrdersService.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orderbook")
    public ResponseEntity<?> buyBook(@RequestBody Orders order)
    {
        return orderService.orderBook(order);
    }

    @GetMapping("/getallorders")
    public ResponseEntity<List<Orders>> listAllOrders()
    {
        return ResponseEntity.ok(orderService.listAllOrders());
    }


    @GetMapping("/getbuyer/{buyerName}")
    public ResponseEntity<Buyers> getBuyer(@PathVariable String buyerName) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
       ResponseEntity<Buyers>response=orderService.getBuyerByName(buyerName);
//        JsonNode root=mapper.readTree(String.valueOf(response.getBody()));
        return response;
    }

    @GetMapping("/getbook/{bookName}")
    public ResponseEntity<Books> getBook(@PathVariable String bookName)
    {
        ResponseEntity<Books>response=orderService.getBookByName(bookName);
    return response;
    }

    @PostMapping("/addbook")
    public ResponseEntity<Books> addBooks(@RequestBody Books books)
    {
        return orderService.addBooks(books);
    }

    //WebClient

    @GetMapping("/findbookbyname/{bookName}")
    public ResponseEntity<Mono<Books>> findBookByName(@PathVariable String bookName)
    {
        return ResponseEntity.ok( orderService.findByBookName(bookName));
    }

    @PostMapping("/addbooks")
    public ResponseEntity<Mono<Books>> addbooks(@RequestBody Books books)
    {
        return ResponseEntity.ok(orderService.findAddBooks(books));
    }


    @PostMapping("/ad")
    public Orders findOrderBook(@RequestBody Orders orders)
    {
        return orderService.findOrderBook(orders);
    }



    //Feign
    @GetMapping("/feignget/{bookName}")
    public ResponseEntity<Books> getBookFeign(@PathVariable String bookName)
    {
        return orderService.getBookFeign(bookName);
    }


    @PostMapping("/addbooksfeign")
    public ResponseEntity<Books> addBooksFeign(@RequestBody Books books)
    {
        return orderService.addBookFeign(books);
    }

    @GetMapping("/getbuyerfeign/{buyerName}")
    public ResponseEntity<Buyers> getBuyersFeign(@PathVariable String buyerName)
    {
        return orderService.getBuyersFeign(buyerName);
    }


    @PostMapping("/addbuyerbyfeign")
    public ResponseEntity<Buyers> addBuyersFeign(@RequestBody Buyers buyers)
    {
        return orderService.addBuyersFeign(buyers);
    }
}
