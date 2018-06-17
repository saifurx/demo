package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Author;
import com.example.demo.repository.AuthorsRepository;

@Service
public class AuthorService {

	@Autowired
	public AuthorsRepository repositoryAuthor;

	// save new author
	public String saveNewAuthor(Author author) {

		return repositoryAuthor.save(author).toString();
	}

	// get all authors
	public List<Author> getAuthorList() {
		return repositoryAuthor.findAll();
	}

}
