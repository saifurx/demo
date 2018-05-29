package com.example.demo.service;


import com.example.demo.model.Book;
import com.example.demo.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService  {


    @Autowired
    BooksRepository repository;


    public String saveNewBook(Book book){
        Book save = repository.save(book);
        return save.toString();

    }

    public List<Book> getList() {

        return repository.findAll();

    }
}
