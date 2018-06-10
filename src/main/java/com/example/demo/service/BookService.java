package com.example.demo.service;


import com.example.demo.model.Book;
import com.example.demo.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service contains business logic to get data from database
@Service
public class BookService  {

    @Autowired
    private BooksRepository repository;

    //save new book
    public String saveNewBook(Book book){
        Book save = repository.save(book);
        return save.toString();
        
    }

    //get all books
    public List<Book> getList() {

        return repository.findAll();
    }
    
    //get book by id
    public Optional<Book> getBookById(Integer id)
    {
    	Optional<Book> findById = repository.findById(id);
    	if (!findById.isPresent())
    		System.out.println("null--->");
    	return findById;	
    }

    //delete book my id
    public void deleteBookById(Integer id)
    {
    	repository.deleteById(id);
    }

    //update the existing book 
	public void updateBook(Book book, Integer id) {
		book.setId(id);
		repository.save(book);
		
	}
    
    
}
