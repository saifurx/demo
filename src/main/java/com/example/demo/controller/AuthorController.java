package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authService;

	@PostMapping(value = "/authors")
	public String saveNewBook(@RequestBody Author author) {
		return authService.saveNewAuthor(author);
	}

	@GetMapping(value = "/authors")
	public List<Author> getAllAuthors() {
		return authService.getAuthorList();
	}
}
