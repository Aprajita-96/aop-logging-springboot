package com.example.asedemo.service;

import com.example.asedemo.domain.Book;
import com.example.asedemo.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

//TEST DRIVEN DEVELOPMENT


@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookServiceTest {

    @Autowired BookRepository bookRepository;
    @Autowired BookService bookService;


    @Test
    void create() {

        Book book = new Book();
        book.setTitle("Harry Potter");
        book.setAuthor("J.K.Rolling");
        bookService.create(book);

        System.out.println(book.getTitle());
        System.out.println(book.getId());
        Book result = bookService.findBook(book.getId());
        assertEquals(book, result);

    }

    @Test
    void findAll() {
    }

    @Test
    void findBook() {
    }
}