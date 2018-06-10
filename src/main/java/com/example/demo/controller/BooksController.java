package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

//rest controller
@RestController
public class BooksController {

	@Autowired
	private BookService service;

	// home page
	@GetMapping(value = "/")
	public String homePage() {
		return "homepage";
	}

	// create books using @requestbody
	@PostMapping(value = "/books")
	public String saveNewBook(@RequestBody Book book) {
		return service.saveNewBook(book);
	}

	/*
	 * // get all books
	 * 
	 * @GetMapping(value = "/books") public List<Book> getAllBooks() { return
	 * service.getList(); }
	 */

	// get all books
	@RequestMapping(value = "/books")
	public List<Book> getAllBooks() {
		return service.getBookList();
	}

	// get book by id
	@GetMapping(value = "/books/{id}")
	public Optional<Book> getBookById(@PathVariable Integer id) {
		return service.getBookById(id);
	}
	
	//update book by id
	@PutMapping(value = "/books/{id}")
	public void updateBooks(@RequestBody Book book ,@PathVariable Integer id)
	{
		service.updateBook(book,id);
	}

	// delete book by id
	@DeleteMapping("/books/{id}")
	public void deleteBookById(@PathVariable Integer id) {
		service.deleteBookById(id);
	}

}
