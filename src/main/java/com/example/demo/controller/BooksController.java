package com.example.demo.controller;


import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//rest controller
@RestController
public class BooksController {


    @Autowired
    BookService service;

    @PostMapping(value = "/book/save")
    public String saveNewBook(@RequestBody Book book) {
        return service.saveNewBook(book);
    }

    @GetMapping(value = "/books/")
    public List<Book> list() {
        return service.getList();
    }
}
