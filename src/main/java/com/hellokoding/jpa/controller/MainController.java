package com.hellokoding.jpa.controller;

import com.hellokoding.jpa.HelloJpaApplication;
import com.hellokoding.jpa.model.Book;
import com.hellokoding.jpa.model.BookDetail;
import com.hellokoding.jpa.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(HelloJpaApplication.class);

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/test")
    public String test() {
        return "Spring Boot 2.0.5 Application is working!";
    }

    @GetMapping("/save/book/{title}/{pages}")
    public Book save(@PathVariable(value = "title") String title,
                     @PathVariable(value = "pages") Integer pages) {
        logger.info("MainController.save: save book");
        return bookRepository.save(new Book(title, new BookDetail(pages)));
    }
}
