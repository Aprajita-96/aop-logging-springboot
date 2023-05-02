package com.example.asedemo.service;


import com.example.asedemo.domain.Book;
import com.example.asedemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public Book create(Book book){
    long start = System.currentTimeMillis();

        try {
            return bookRepository.save(book);
        }finally {
            long endtime = System.currentTimeMillis();
            long exetime = endtime - start;
            System.out.println("execution time = " + exetime);
        }

    }


    @Transactional(readOnly = true)
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Book findBook(Long id){

        return bookRepository.findById(id).orElseThrow(()->new IllegalArgumentException("check id"));

    }



}
