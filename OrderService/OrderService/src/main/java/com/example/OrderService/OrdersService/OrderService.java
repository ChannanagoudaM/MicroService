package com.example.OrderService.OrdersService;


import com.example.OrderService.Config.Books;
import com.example.OrderService.Config.Buyers;
import com.example.OrderService.OpenFeign.FeignInterface;
import com.example.OrderService.OpenFeign.FeignInterfaceBuyers;
import com.example.OrderService.OrdersEntity.Orders;
import com.example.OrderService.OrdersRepo.OrderRepo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;


@Service
public class OrderService {


    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webclient;

    @Autowired
    FeignInterface feignClient;

    @Autowired
    FeignInterfaceBuyers feignInterfaceBuyers;


    public ResponseEntity<?> orderBook(Orders orders)
    {
        String bookName=orders.getBookName();
        String buyerName=orders.getBuyerName();
        System.out.println(bookName+" "+buyerName);
        Buyers buyers=restTemplate.getForObject("http://localhost:8899/buyers/getbuyerbyname/{buyerName}",Buyers.class,buyerName);
        Books books=restTemplate.getForObject("http://localhost:8898/books/getbookbyname/{bookName}", Books.class,bookName);
        if(buyers==null || books==null)
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("You've Entered Incorrected Details");
        }
        Orders orders1=new Orders();
            orders1.setBookName(books.getBookName());
            orders1.setAuthorName(books.getAuthorName());
            orders1.setBuyerName(buyers.getBuyerName());
            orders1.setTotalPrice(books.getPrice());
        orderRepo.save(orders1);
        return ResponseEntity.ok(orders1);
    }


    public List<Orders> listAllOrders() {
        return orderRepo.findAll();
    }



    @HystrixCommand(fallbackMethod = "getBuyersRestHystrix")
    public ResponseEntity<Buyers> getBuyerByName(String buyerName) {
         Buyers buyers=restTemplate.getForObject("http://localhost:8899/buyers/getbuyerbyname/{buyerName}", Buyers.class, buyerName);
//         HttpHeaders httpHeaders =restTemplate.headForHeaders("http://localhost:8899/buyers/getbuyerbyname/{buyerName}");
//        System.out.println(httpHeaders);
         return ResponseEntity.ok(buyers);
    }


    public ResponseEntity<Buyers> getBuyersRestHystrix(String buyerName)
    {
        return ResponseEntity.ok(restTemplate.getForObject("http://MICROSERVICESEXAMPLE/buyers/getbuyerbyname/{buyerName}", Buyers.class, buyerName));
    }


    public ResponseEntity<Books> getBookByName(String bookName)
    {
         Books books=restTemplate.getForObject("http://localhost:8898/books/getbookbyname/{bookName}", Books.class,bookName);
    return ResponseEntity.ok(books);
    }


    public ResponseEntity<Books> addBooks(Books books)
    {
        Books books1=restTemplate.postForObject("http://localhost:8898/books/addbook",books, Books.class);
        return ResponseEntity.ok(books1);
    }


    //webClient


    public Mono<Books> findByBookName(String  bookName)
    {
        return webclient.build()
                .get()
                .uri("http://localhost:8898/books/getbookbyname/{bookName}",bookName)
                .retrieve()
                .bodyToMono(Books.class);

    }


    public Mono<Books> findAddBooks(Books books)
    {
    return webclient.build()
            .post()
            .uri("http://localhost:8898/books/addbook")
            .body(Mono.just(books), Books.class)
            .retrieve()
            .bodyToMono(Books.class);


    //to handle the error
//        retreive().onStatus(HttpStatus::is4xxClientError,resposne->{
//            return Mono.error(throw new ClientException("nmjsjd"),resposne.getstatuscode);
//        })
    }


    public Orders findOrderBook(Orders orders)
    {
        Mono<Books> books=webclient.build().get().uri("http://localhost:8898/books/getbookbyname/{bookName}",orders.getBookName()).retrieve()
                .bodyToMono(Books.class);

        Mono<Buyers> buyers=webclient.build().get().uri("http://localhost:8899/buyers/getbuyerbyname/{buyerName}",orders.getBuyerName()).retrieve()
                .bodyToMono(Buyers.class);
//        books.subscribe(books1-> System.out.println(books1));
//        buyers.subscribe(buyers1-> System.out.println(buyers1));

        return null;
    }

    //FeignClient


    public ResponseEntity<Books> getBookFeign(String bookName)
    {
        return feignClient.getBookByName(bookName);
    }


    public ResponseEntity<Books> addBookFeign(Books books)
    {
        return feignClient.addBooksFeign(books);
    }

    public ResponseEntity<Buyers> getBuyersFeign(String buyerName)
    {
        return feignInterfaceBuyers.getBuyerByName(buyerName);
    }

    public ResponseEntity<Buyers> addBuyersFeign(Buyers buyers)
    {
        return feignInterfaceBuyers.addBuyer(buyers);
    }





}