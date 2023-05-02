package com.example.asedemo.controller;

import com.example.asedemo.domain.Book;
import com.example.asedemo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BookController {

    //RESTFul API
    //HTTP methods : GET, POST, PUT, DELETE
    //response data includes HTTP status code
    //HATEOAS -- link
    //includs all link information

    private final BookService bookService;

    @GetMapping("/book")
    public String findBook(){
        return "Hello World";
    }


    @PostMapping("/book")
    public ResponseEntity<?> save(@RequestBody Book book){
        return new ResponseEntity<>(bookService.create(book), HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/book/{id}")
    public ResponseEntity<?> find( @PathVariable Long id){
        return new ResponseEntity<>(bookService.findBook(id), HttpStatus.OK);
    }




}
