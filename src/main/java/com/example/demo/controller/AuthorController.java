package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authService;

	@GetMapping(value = "/authors")
	public List<Author> getAllAuthors() {
		return authService.getAuthorList();
	}

	@PostMapping(value = "/authors")
	public Author saveNewBook(@RequestBody Author author) {
		return authService.saveNewAuthor(author);
	}

	@PutMapping(value = "/authors/{authorId}")
	public Author updateAuthor(@PathVariable Integer authorId, @RequestBody Author author) {

		return authService.updateAuthor(authorId, author);
	}

	@DeleteMapping(value = "/authors/{authorId}")
	public ResponseEntity<Object> deleteAuthor(@PathVariable Integer authorId) {

		return authService.deleteAuthor(authorId);
	}

}
