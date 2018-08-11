package com.example.demo.service;

import com.example.demo.Exception.ResourceNotFoundException;
import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorsRepository;
import com.example.demo.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service contains business logic to get data from database
@Service
public class BookService {

	@Autowired
	private BooksRepository bookRepository;

	@Autowired
	public AuthorsRepository authorRepository;

	public Page<Book> getAllBooksByAuthorId(Integer authorId, Pageable pageable) {

		if (!authorRepository.existsById(authorId)) {
			throw new ResourceNotFoundException("AuthorId " + authorId + " not found", null, pageable);
		}
		
		return bookRepository.findByAuthorAuthorId(authorId, pageable);
	}

	public Book createBook(Integer authorId, Book book) {
		return authorRepository.findById(authorId).map(author -> {
			book.setAuthor(author);
			return bookRepository.save(book);
		}).orElseThrow(() -> new ResourceNotFoundException("AuthorId " + authorId + " not found"));
	}

	public Book updateBook(Integer authorId, Integer bookId, Book bookRequest) {
		if (!bookRepository.existsById(authorId)) {
			throw new ResourceNotFoundException("AuthorId " + authorId + " not found");
		}
		return bookRepository.findById(bookId).map(book -> {
			book.setBookName(bookRequest.getBookName());
			return bookRepository.save(book);
		}).orElseThrow(() -> new ResourceNotFoundException("BookId " + bookId + " not found"));

	}

	public ResponseEntity<Object> deleteBook(Integer authorId, Integer bookId) {

		if (!authorRepository.existsById(authorId)) {
			throw new ResourceNotFoundException("AuthorId " + authorId + " not found");
		}

		return bookRepository.findById(bookId).map(book -> {
			bookRepository.delete(book);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("BookId " + bookId + " not found"));
	}

}
