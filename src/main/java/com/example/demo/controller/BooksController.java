package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

//rest controller
@RestController
public class BooksController {

	@Autowired
	private BookService bookService;

	// get all book by author id
	@GetMapping(value = "/authors/{authorId}/books")
	public Page<Book> getAllBooksByAuthorId(@PathVariable(value = "authorId") Integer authorId, Pageable pageable) {
		return bookService.getAllBooksByAuthorId(authorId, pageable);
	}

	// create books using author id
	@PostMapping(value = "/authors/{authorId}/books")
	public void createBook(@PathVariable(value = "authorId") Integer authorId, @RequestBody Book book) {
		bookService.createBook(authorId, book);

	}

	// Works only if cascading is not all
	@PutMapping(value = "/authors/{authorId}/books/{bookId}")
	public void updateBook(@PathVariable(value = "authorId") Integer authorId,
			@PathVariable(value = "bookId") Integer bookId, @RequestBody Book bookRequest) {
		bookService.updateBook(authorId, bookId, bookRequest);
	}

	@DeleteMapping(value = "/authors/{authorId}/books/{bookId}")
	public void deleteBook(@PathVariable(value = "authorId") Integer authorId,
			@PathVariable(value = "bookId") Integer bookId) {
		bookService.deleteBook(authorId, bookId);
	}

}
