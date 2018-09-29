package com.hellokoding.jpa.controller;

import com.hellokoding.jpa.HelloJpaApplication;
import com.hellokoding.jpa.model.Book;
import com.hellokoding.jpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rest")
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(HelloJpaApplication.class);

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/test")
    public String test() {
        return "Spring Boot 2.0.5 Application is working!";
    }

    @PostMapping("/save/book")
    public Book save(@RequestBody Book book) {
        logger.info("MainController.save: save book");
        return bookRepository.save(book);
    }

    @GetMapping("/all")
    public List<Book> retrieveAll() {
        return bookRepository.findAll();
    }
}
